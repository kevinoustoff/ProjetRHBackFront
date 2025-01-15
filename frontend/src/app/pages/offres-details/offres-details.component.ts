import { Component, OnInit } from '@angular/core';
import { MenuComponent } from "../../layout/menu/menu.component";
import { OffresService } from "../../services/offres.service";
import { ActivatedRoute, Router } from "@angular/router";
import { Offre } from "../../models/Offre";
import { CommonModule } from "@angular/common";
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';  // Importation du service AuthService
import { Candidature } from '../../models/candidature.model'; // Importation de l'interface Candidature
import { CandidaturesService } from '../../services/candidatures.service';
import {AgGridAngular} from "ag-grid-angular"; // Importation du service CandidaturesService
import { ColDef, CellClickedEvent,ICellRendererParams } from "ag-grid-community";
import { AllCommunityModule, ModuleRegistry } from "ag-grid-community";
import {Candidaturecomplet} from "../../models/candidaturecomplet.model";
// Register AG Grid Modules
ModuleRegistry.registerModules([AllCommunityModule]);

@Component({
  selector: 'app-offres-details',
  standalone: true,
    imports: [
        MenuComponent,
        CommonModule,
        FormsModule,
        AgGridAngular
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
  candidatures: Candidaturecomplet[] = [];
  colDefs: ColDef<Candidaturecomplet>[] = [
    { field: 'id', headerName: 'ID' },
    {
      field: 'dateCandidature',
      headerName: 'Date de Candidature',
      valueFormatter: (params) => this.formatDate(params.value)
    },
    { field: 'statut', headerName: 'Statut' },
    { field: 'utilisateur.nom', headerName: 'Nom du Candidat' },
    { field: 'offreEmploi.nom', headerName: 'Offre d\'Emploi' },
    { field: 'lettreMotivation', headerName: 'Lettre de Motivation' },
    {
      headerName: 'Actions',  // Colonne d'actions personnalisée
      cellRenderer: (params: ICellRendererParams) => {
        return `<button class="btn btn-primary">Voir les détails</button>`;
      },
      onCellClicked: (params: CellClickedEvent) => this.onActionClick(params),
      width: 200,
    }
  ];
  

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

      this.candidaturesService.getCandidaturesByOffre(this.offreId).subscribe((candidaturess: Candidaturecomplet[])=>{
        this.candidatures=candidaturess
      })
    });
  }

  ngOnInit(): void {}
  // Format la date au format français
  formatDate(date: string | Date): string {
    const options: Intl.DateTimeFormatOptions = { year: 'numeric', month: '2-digit', day: '2-digit' };
    return new Date(date).toLocaleDateString('fr-FR', options);
  }

  // Action sur le clic du bouton dans le tableau
  onActionClick(params: CellClickedEvent): void {
    const rowData = params.data;
    console.log('Action button clicked for row:', rowData);
    this.route.navigate(['/candidatures-rh', rowData.id]);  // Redirige vers le détail de la candidature
  }
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
