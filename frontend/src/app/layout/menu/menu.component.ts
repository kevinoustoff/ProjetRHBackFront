import { Component } from '@angular/core';
import {Router, RouterLink, RouterLinkActive, RouterOutlet} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {jwtDecode} from "jwt-decode";
import { CommonModule } from '@angular/common';
import {CvEnLigneService} from "../../services/cv-en-ligne.service";

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [
    RouterOutlet, RouterLink, RouterLinkActive,CommonModule
  ],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent {
  userInfo: { [key: string]: any } = {};
  hasCv: boolean = false;

  constructor(public authService: AuthService, public router: Router, public cvService: CvEnLigneService){
    const token = sessionStorage.getItem("ACCESS_TOKEN");

    if (token) {
      try {
        this.userInfo = jwtDecode<{ [key: string]: any }>(token);
      } catch (error) {
        console.error("Invalid token:", error);
        this.userInfo = {}; // Valeur par défaut en cas d'erreur
      }
    } else {
      console.warn("ACCESS_TOKEN not found in sessionStorage.");
      this.userInfo = {}; // Valeur par défaut si le token n'existe pas
    }

    console.log(this.userInfo)
    console.log(this.isUser())
  }

  ngOnInit(): void {
    if (this.isUser()) {
      const userId = this.authService.getId();
      this.cvService.hasACv(userId).subscribe((hasCv) => {
        this.hasCv = hasCv;
      });
    }
  }

  isAdmin():boolean{
    return this.userInfo?.['roles']?.includes("ROLE_ADMIN") ?? false;
  }

  isUser():boolean{
    return this.userInfo?.['roles']?.includes("ROLE_USER") ?? false;
  }
  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}
