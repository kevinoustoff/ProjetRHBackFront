import { Component, OnInit } from '@angular/core';
import { AgGridAngular } from 'ag-grid-angular';
import { ColDef, CellClickedEvent, ICellRendererParams } from 'ag-grid-community';
import { AllCommunityModule, ModuleRegistry } from 'ag-grid-community';
import { Router } from '@angular/router';
import { CandidaturesService } from '../../services/candidatures.service';
import { Candidature } from '../../models/candidature.model';
import { CommonModule } from '@angular/common';
import { MenuComponent } from '../../layout/menu/menu.component';

// Register AG Grid Modules
ModuleRegistry.registerModules([AllCommunityModule]);

@Component({
  selector: 'app-candidatures-rh',
  standalone: true,
  imports: [AgGridAngular,MenuComponent, CommonModule],  // Import AG Grid and CommonModule for *ngFor
  templateUrl: './candidatures-rh.component.html',
  styleUrls: ['./candidatures-rh.component.scss']
})
export class CandidaturesRhComponent implements OnInit {
  candidatures: Candidature[] = [];
  colDefs: ColDef<Candidature>[] = [
    { field: 'id', headerName: 'ID' },
    {
      field: 'dateCandidature',
      headerName: 'Date de Candidature',
      valueFormatter: (params) => this.formatDate(params.value)
    },
    { field: 'statut', headerName: 'Statut' },
    { field: 'utilisateur.nom', headerName: 'Nom du Candidat' },
    { field: 'offreEmploi.nom', headerName: 'Offre d\'Emploi' },
    { field: 'lettreMotivation', headerName: 'Lettre de Motivation' },
    {
      headerName: 'Actions',  // Colonne d'actions personnalisée
      cellRenderer: (params: ICellRendererParams) => {
        return `<button class="btn btn-primary">Voir les détails</button>`;
      },
      onCellClicked: (params: CellClickedEvent) => this.onActionClick(params),
      width: 200,
    }
  ];

  constructor(private candidaturesService: CandidaturesService, private router: Router) {}

  ngOnInit(): void {
    // Charger toutes les candidatures via le service
    this.candidaturesService.getAllCandidatures().subscribe((candidatures: Candidature[]) => {
      this.candidatures = candidatures;
      console.log('Candidatures loaded:', this.candidatures);
    });
  }

  // Format la date au format français
  formatDate(date: string | Date): string {
    const options: Intl.DateTimeFormatOptions = { year: 'numeric', month: '2-digit', day: '2-digit' };
    return new Date(date).toLocaleDateString('fr-FR', options);
  }

  // Action sur le clic du bouton dans le tableau
  onActionClick(params: CellClickedEvent): void {
    const rowData = params.data;
    console.log('Action button clicked for row:', rowData);
    this.router.navigate(['/candidatures-rh', rowData.id]);  // Redirige vers le détail de la candidature
  }

  // Méthode pour créer une nouvelle candidature (optionnel)
  onClickCreate() {
    this.router.navigate(['/candidatures-rh/create']);
  }
}
