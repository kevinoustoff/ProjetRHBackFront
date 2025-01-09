import { Component } from '@angular/core';
import {Router, RouterLink, RouterLinkActive, RouterOutlet} from "@angular/router";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [
    RouterOutlet, RouterLink, RouterLinkActive
  ],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent {
  constructor(public authService: AuthService, public router: Router){}
  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}
