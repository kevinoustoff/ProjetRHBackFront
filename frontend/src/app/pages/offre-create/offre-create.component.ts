import { Component } from '@angular/core';
import {MenuComponent} from "../../layout/menu/menu.component";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {OffresService} from "../../services/offres.service";
import {CommonModule} from "@angular/common";
import {Router} from "@angular/router";

@Component({
  selector: 'app-offre-create',
  standalone: true,
  imports: [
    MenuComponent,CommonModule, ReactiveFormsModule
  ],
  templateUrl: './offre-create.component.html',
  styleUrl: './offre-create.component.scss'
})
export class OffreCreateComponent {
  offreForm: FormGroup;

  constructor(private fb: FormBuilder, private offreService: OffresService, private router: Router) {
    this.offreForm = this.fb.group({
      nom: ['', Validators.required],
      description: ['', Validators.required],
      reference: ['', Validators.required],
      duree: [''],
      typeEmploi: ['', Validators.required],
    });
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.offreForm.valid) {
      const nouvelleOffre = {...this.offreForm.value,
      datePublication: new Date()};
      this.offreService.createOffre(nouvelleOffre).subscribe({
        next: (response) => {
          console.log('Offre créée avec succès :', response);
          //redirection vers la liste des offres
          this.router.navigate(['/offres-rh']);
        },
        error: (err) => {
          console.error('Erreur lors de la création de l\'offre :', err);
          // Gestion des erreurs
        },
        complete: () => {
          console.log('Requête terminée');
          // Actions à effectuer une fois la requête terminée
        },
      });
    } else {
      console.log('Formulaire invalide');
    }
  }
  get f() {
    return this.offreForm.controls;
  }
}
