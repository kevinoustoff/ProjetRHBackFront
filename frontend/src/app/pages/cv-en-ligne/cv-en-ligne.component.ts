import { Component } from '@angular/core';
import {CvEnLigne} from "../../models/CvEnLigne";
import {CvEnLigneService} from "../../services/cv-en-ligne.service";
import {AuthService} from "../../services/auth.service";
import {MenuComponent} from "../../layout/menu/menu.component";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-cv-en-ligne',
  standalone: true,
  imports: [
    MenuComponent, CommonModule, ReactiveFormsModule, FormsModule, RouterLink
  ],
  templateUrl: './cv-en-ligne.component.html',
  styleUrl: './cv-en-ligne.component.scss'
})
export class CvEnLigneComponent {
  cv: CvEnLigne | null = null;
  isLoading: boolean = true;
  constructor(private cvService: CvEnLigneService, private authService: AuthService) { }

  ngOnInit(): void {
    const userId = this.authService.getId();
    this.cvService.getCvByUserId(userId).subscribe({
      next: (data) => {
        this.cv = data;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Erreur lors du chargement du CV:', err);
        this.isLoading = false;
      }
    });
  }

}
