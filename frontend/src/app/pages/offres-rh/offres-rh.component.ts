import { Component, OnInit } from '@angular/core';
import { AgGridAngular } from "ag-grid-angular";
import { ColDef, CellClickedEvent,ICellRendererParams } from "ag-grid-community";
import { AllCommunityModule, ModuleRegistry } from "ag-grid-community";
import { MenuComponent } from '../../layout/menu/menu.component';
import {FolderService} from "../../services/folder.service";
import {Router} from "@angular/router";
import {Folder} from "../../models/Folder";
import {OffresService} from "../../services/offres.service";
import {Offre} from "../../models/Offre";
import {CommonModule} from "@angular/common";

// Register AG Grid Modules
ModuleRegistry.registerModules([AllCommunityModule]);

// Define the row data structure

@Component({
  selector: 'app-offres-rh',
  standalone: true,
  imports: [AgGridAngular,MenuComponent,CommonModule], // Removed AgGridModule
  templateUrl: './offres-rh.component.html',
  styleUrls: ['./offres-rh.component.scss'] // Corrected styleUrls (plural)
})
export class OffresRHComponent implements OnInit {
  offres:Offre[]=[];
  colDefs: ColDef<Offre>[] = [
    { field: "reference", headerName: "Reference" },
    { field: "nom", headerName: "Nom" },
    { field: "statut", headerName: "Statut" },
    { field: "datePublication",
      headerName: "Date de Publication",
      valueFormatter: (params) => this.formatDate(params.value) },
    {
      headerName: "Actions", // Custom action column
      cellRenderer: (params: ICellRendererParams) => {
        return `<button class="btn btn-primary">Voir les détails</button>`;
      },
      onCellClicked: (params: CellClickedEvent) => this.onActionClick(params),
      width: 200,
    }
  ];

  rowData: Offre[] = [

  ];

  constructor(private offreService:OffresService, private router:Router){
    this.offreService.getAllOffres().subscribe((offres:Offre[])=>{
      this.rowData = offres
      console.log('Offres loaded:', this.rowData);
    });


  }

  ngOnInit(): void {}

  // Action click handler with proper typing
  onActionClick(params: CellClickedEvent): void {
    const rowData = params.data; // Access the row data
    console.log('Action button clicked for row:', rowData);
    //alert(`Action clicked for: ${rowData.nom}`);
    this.router.navigate(['/offres-rh', rowData.id])
  }

  formatDate(date: string | Date): string {
    const options: Intl.DateTimeFormatOptions = { year: 'numeric', month: '2-digit', day: '2-digit' };
    return new Date(date).toLocaleDateString('fr-FR', options);
  }
}
