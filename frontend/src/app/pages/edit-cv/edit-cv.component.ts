import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CvEnLigneService} from "../../services/cv-en-ligne.service";
import {CvEnLigne} from "../../models/CvEnLigne";
import {MenuComponent} from "../../layout/menu/menu.component";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-edit-cv',
  standalone: true,
  imports: [
    MenuComponent,
    FormsModule,CommonModule
  ],
  templateUrl: './edit-cv.component.html',
  styleUrl: './edit-cv.component.scss'
})
export class EditCvComponent implements OnInit{
  cv!: CvEnLigne;

  constructor(
      private cvService: CvEnLigneService,
      private route: ActivatedRoute,
      private authService: AuthService,
      private router: Router
  ) {}

  ngOnInit(): void {
    const cvId = this.route.snapshot.paramMap.get('id');
    if (cvId) {
      this.cvService.getCvById(+cvId).subscribe((data) => {
        this.cv = data;
      });
    }
  }

  onSubmit() {
    if (!this.cv.userId) {
      this.cv.userId = this.authService.getId();
    }
    this.cvService.updateCv(this.cv).subscribe({
      next: () => console.log('CV mis à jour avec succès!'),
      error: (err: any) => console.error('Erreur lors de la mise à jour:', err),
    });
    this.router.navigate(['/see-mon-cv']);
  }

  addCompetence() {
    this.cv.competences.push({ name: '' });
  }
  removeCompetence(index: number) {
    this.cv.competences.splice(index, 1);
  }
  addExperience() {
    this.cv.experiences.push({
      jobTitle: '',
      company: '',
      location: '',
      startDate: '',
      endDate: '',
      description: '',
    });
  }
  removeExperience(index: number) {
    this.cv.experiences.splice(index, 1);
  }
  addLangue() {
    this.cv.langues.push({ language: '', proficiency: '' });
  }
  removeLangue(index: number) {
    this.cv.langues.splice(index, 1);
  }
  addCertification() {
    this.cv.certifications.push({
      certificationName: '',
      issuingOrganization: '',
      issueDate: '',
    });
  }
  removeCertification(index: number) {
    this.cv.certifications.splice(index, 1);
  }
  addFormation() {
    this.cv.formations.push({
      degree: '',
      institution: '',
      location: '',
      graduationDate: '',
    });
  }
  removeFormation(index: number) {
    this.cv.formations.splice(index, 1);
  }
}
