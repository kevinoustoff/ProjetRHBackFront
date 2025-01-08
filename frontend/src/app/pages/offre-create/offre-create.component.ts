import { Component } from '@angular/core';
import {MenuComponent} from "../../layout/menu/menu.component";

@Component({
  selector: 'app-offre-create',
  standalone: true,
  imports: [
    MenuComponent
  ],
  templateUrl: './offre-create.component.html',
  styleUrl: './offre-create.component.scss'
})
export class OffreCreateComponent {

}
