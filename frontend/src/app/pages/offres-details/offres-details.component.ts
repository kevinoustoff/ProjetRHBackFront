import { Component, OnInit } from '@angular/core';
import { MenuComponent } from "../../layout/menu/menu.component";
import { OffresService } from "../../services/offres.service";
import { ActivatedRoute, Router } from "@angular/router";
import { Offre } from "../../models/Offre";
import { CommonModule } from "@angular/common";
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';  // Importation du service AuthService
import { Candidature } from '../../models/candidature.model'; // Importation de l'interface Candidature
import { CandidaturesService } from '../../services/candidatures.service'; // Importation du service CandidaturesService

@Component({
  selector: 'app-offres-details',
  standalone: true,
  imports: [
    MenuComponent,
    CommonModule,
    FormsModule
  ],
  templateUrl: './offres-details.component.html',
  styleUrls: ['./offres-details.component.scss']
})
export class OffresDetailsComponent implements OnInit {
  offre: Offre | undefined;
  offreId: any;
  lettreMotivation: string = ''; // Contient la lettre de motivation
  userId: number |null =null;
  userNom: string |null=null;
  

  constructor(
    private offreService: OffresService,
    private router: ActivatedRoute,
    private authService: AuthService,  // Injection du service AuthService
    private candidaturesService: CandidaturesService,  // Service pour envoyer la candidature
    private route: Router  // Pour naviguer après l'envoi de la candidature
  ) {
    // Récupérer les informations de l'utilisateur connecté depuis AuthService
    this.userId = this.authService.getId(); // Récupérer l'ID de l'utilisateur connecté
    this.userNom = this.authService.getUsername(); // Récupérer le nom d'utilisateur
    // Vous pouvez récupérer l'email de la même manière, ou depuis un autre endroit
  

    // Récupérer l'ID de l'offre depuis la route
    this.router.paramMap.subscribe(params => {
      this.offreId = params.get('id')!;
      console.log('ID récupéré depuis la route (réactif) :', this.offreId);

      // Charger les détails de l'offre avec l'ID
      this.offreService.getOffreDetail(this.offreId).subscribe(offre => {
        this.offre = offre;
        console.log('Détails de l\'offre:', this.offre);
      });
    });
  }

  ngOnInit(): void {}

  postuler(): void {
    // Vérifier si la lettre de motivation est vide
    if (this.lettreMotivation.trim() === '') {
      alert('Veuillez saisir une lettre de motivation.');
      return;
    }

    // Vérification de la présence des informations de l'utilisateur
    if (this.userId === null ) {
      alert('Utilisateur non authentifié ou informations manquantes.');
      return;
    }

    // Créer l'objet candidature
    const candidature: Candidature = {
      id: 0,  // L'id peut être laissé à 0 car il sera généré côté backend
      dateCandidature: new Date().toISOString(),
      lettreMotivation: this.lettreMotivation,
      statut: 'En attente',
      utilisateurId: this.userId, // utilisateur doit inclure un id
      offreEmploiId: this.offreId
    };

    // Log de la candidature (facultatif, pour déboguer)
    console.log('Candidature envoyée:', candidature);

    // Appeler le service pour soumettre la candidature
    this.candidaturesService.addCandidature(candidature).subscribe({
      next: (response) => {
        console.log('Candidature envoyée avec succès:', response);
        // Après la soumission, rediriger l'utilisateur vers la page des candidatures RH
        this.route.navigate(['/candidatures-rh']);
      },
      error: (err) => {
        console.error('Erreur lors de l\'envoi de la candidature:', err);
        alert('Une erreur est survenue lors de l\'envoi de la candidature.');
      }
    });
  }
}
