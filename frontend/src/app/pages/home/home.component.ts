import { Component } from '@angular/core';
import {MenuComponent} from "../../layout/menu/menu.component";
import { Router } from '@angular/router';
import {Folder} from "../../models/Folder";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
  standalone: true,
  imports: [MenuComponent],
})
export class HomeComponent {
  constructor(private router:Router){}

  onClickExplore(){
    this.router.navigate(['/offres-rh']);
  }
}
