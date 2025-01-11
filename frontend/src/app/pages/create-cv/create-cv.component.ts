import { Component } from '@angular/core';
import {CvEnLigneService} from "../../services/cv-en-ligne.service";
import {CvEnLigne} from "../../models/CvEnLigne";
import {MenuComponent} from "../../layout/menu/menu.component";
import {CommonModule} from "@angular/common";
import {FormsModule, NgForm, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-create-cv',
  standalone: true,
  imports: [MenuComponent, CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './create-cv.component.html',
  styleUrl: './create-cv.component.scss'
})
export class CreateCvComponent {
  cv: CvEnLigne = {
    title: '',
    summary: '',
    experiences: [{ jobTitle: '', company: '', location: '', startDate: '', endDate: '' }],
    formations: [],
    competences: [],
    langues: [],
    localisation: '',
    coordonnees: {
      phoneNumber: '',
      city: '',
      address: '',
      email: ''
    },
    certifications: []
  };

  constructor(private cvService: CvEnLigneService) {}

  onSubmit() {
    this.cvService.createCv(this.cv).subscribe({
      next: (response) => {
        console.log('CV créé avec succès:', response);
        // Réinitialiser le formulaire ou rediriger l'utilisateur
      },
      error: (error) => {
        console.error('Erreur lors de la création du CV:', error);
      },
      complete: () => {
        console.log('Création du CV terminée');
      }
    });
  }

  addCompetence() {
    this.cv.competences.push({ name: '' }); // Ajout d'un nouvel objet Competence
  }

  removeCompetence(index: number) {
    this.cv.competences.splice(index, 1);
  }

  addLangue() {
    this.cv.langues.push({ language: '', proficiency: '' });
  }

  removeLangue(index: number) {
    this.cv.langues.splice(index, 1);
  }

  addCertification() {
    this.cv.certifications.push({ certificationName: '', issuingOrganization: '', issueDate: '' });
  }

  removeCertification(index: number) {
    this.cv.certifications.splice(index, 1);
  }

  addFormation() {
    this.cv.formations.push({ degree: '', institution: '', location: '', graduationDate: '' });
  }

  removeFormation(index: number) {
    this.cv.formations.splice(index, 1);
  }

  addExperience() {
    this.cv.experiences.push({ jobTitle: '', company: '', location: '', startDate: '', endDate: '' }); // Ajout d'une nouvelle expérience vide
  }

  removeExperience(index: number) {
    this.cv.experiences.splice(index, 1); // Suppression de l'expérience
  }
}
