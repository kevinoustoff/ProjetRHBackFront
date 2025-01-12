import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { OffresService } from '../../services/offres.service';
import { CandidaturesService } from '../../services/candidatures.service';
import { Candidature } from '../../models/candidature.model';
import { Offre } from '../../models/Offre';
import { CommonModule } from '@angular/common';
import { MenuComponent } from '../../layout/menu/menu.component';

@Component({
  selector: 'app-candidature-create',
  standalone: true,
  imports:[CommonModule, MenuComponent,ReactiveFormsModule],
  templateUrl: './candidature-create.component.html',
  styleUrls: ['./candidature-create.component.scss'],
})
export class CandidatureCreateComponent implements OnInit {
  candidatureForm: FormGroup;
  offres: Offre[] = [];
  candidats:Candidature[] = [];

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private offresService: OffresService,
    private candidaturesService: CandidaturesService
  ) {
    this.candidatureForm = this.fb.group({
      offre: ['', Validators.required], // Offre sélectionnée
      candidat: ['', Validators.required], // Candidat sélectionné
      lettreMotivation: ['', Validators.required], // Lettre de motivation
      dateCandidature: ['', Validators.required], // Date de candidature
      statut: ['', Validators.required], // Statut de la candidature
    });
  }

  ngOnInit(): void {
    // Charger les offres depuis le service
    this.offresService.getAllOffres().subscribe((offres) => {
      this.offres = offres;
    });

    // Charger les candidats depuis le service
    this.candidaturesService.getAllCandidatures().subscribe((candidats) => {
      this.candidats = candidats;
    });
  }

  // Soumission du formulaire
  onSubmit() {
    if (this.candidatureForm.valid) {
      // Créer un objet avec les données du formulaire
      const candidatureData = this.candidatureForm.value;
      
      // Ajout de la candidature via le service
      this.candidaturesService.addCandidature(candidatureData).subscribe(
        (response) => {
          alert('Candidature créée avec succès !');
          // Redirection après la soumission réussie
          this.router.navigate(['/candidatures-rh']);
        },
        (error) => {
          console.error('Erreur lors de la création de la candidature', error);
          alert('Erreur lors de la création de la candidature.');
        }
      );
    } else {
      alert('Le formulaire n\'est pas valide.'); // Ajout d'une alerte en cas de formulaire invalide
    }
  }

  // Annulation
  onCancel() {
    this.router.navigate(['/candidatures-rh']); // Retour à la liste des candidatures
  }
}