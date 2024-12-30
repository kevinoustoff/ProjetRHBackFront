import { Component, OnInit } from '@angular/core';
import { AgGridAngular } from "ag-grid-angular";
import { ColDef, CellClickedEvent,ICellRendererParams } from "ag-grid-community";
import { AllCommunityModule, ModuleRegistry } from "ag-grid-community";
import { MenuComponent } from '../../layout/menu/menu.component';

// Register AG Grid Modules
ModuleRegistry.registerModules([AllCommunityModule]);

// Define the row data structure
interface IRow {
  nom: string;
  reference: string;
  statut: string;
  datePublication: string;
}

@Component({
  selector: 'app-offres-rh',
  standalone: true,
  imports: [AgGridAngular,MenuComponent], // Removed AgGridModule
  templateUrl: './offres-rh.component.html',
  styleUrls: ['./offres-rh.component.scss'] // Corrected styleUrls (plural)
})
export class OffresRHComponent implements OnInit {
  colDefs: ColDef<IRow>[] = [
    { field: "reference", headerName: "Reference" },
    { field: "nom", headerName: "Nom" },
    { field: "statut", headerName: "Statut" },
    { field: "datePublication", headerName: "Date de Publication" },
    {
      headerName: "Actions", // Custom action column
      cellRenderer: (params: ICellRendererParams) => {
        return `<button class="btn btn-primary">Voir les candidatures</button>`;
      },
      onCellClicked: (params: CellClickedEvent) => this.onActionClick(params),
      width: 150,
    }
  ];

  rowData: IRow[] = [
    { nom: "Business Analyst F/H", reference: "J1224-2339", statut: "", datePublication: "30/10/2024" },
    { nom: "Ingénieur(e) d’études et développement F/H", reference: "J1224-2340", statut: "", datePublication: "10/06/2024" },
    { nom: "Consultant(e) / Chef(fe) de Projet MES – Industrie 4.0 F/H", reference: "J1224-2337", statut: "", datePublication: "01/12/2024" },
  ];

  ngOnInit(): void {}

  // Action click handler with proper typing
  onActionClick(params: CellClickedEvent): void {
    const rowData = params.data; // Access the row data
    console.log('Action button clicked for row:', rowData);
    alert(`Action clicked for: ${rowData.nom}`);
  }
}
