import {Component, OnInit} from '@angular/core';
import {MenuComponent} from "../../layout/menu/menu.component";
import {OffresService} from "../../services/offres.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Offre} from "../../models/Offre";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-offres-details',
  standalone: true,
    imports: [
        MenuComponent,
        DatePipe
    ],
  templateUrl: './offres-details.component.html',
  styleUrl: './offres-details.component.scss'
})
export class OffresDetailsComponent implements OnInit {
  ngOnInit(): void {

  }

  offre: Offre | undefined
  offreId:any
  constructor(private offreService: OffresService, private router: ActivatedRoute) {
    this.router.paramMap.subscribe(params => {
      this.offreId = params.get('id')!;
      console.log('ID récupéré depuis la route (réactif) :', this.offreId);

      // Charger les détails de l'offre avec l'ID
      this.offreService.getOffreDetail(this.offreId).subscribe(offre => {
        this.offre = offre;
        console.log('Détails de l\'offre:', this.offre);
      });
    });
  }
}
