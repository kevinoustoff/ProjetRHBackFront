import { Component, OnInit } from '@angular/core';
import { Folder } from '../../models/Folder';
import { FolderService } from '../../services/folder.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-folder-list',
  templateUrl: './folder-list.component.html',
  styleUrl: './folder-list.component.scss'
})
export class FolderListComponent implements OnInit{

  folders:Folder[]=[];

  constructor(private folderService:FolderService, private router:Router){

  }
  ngOnInit(): void {
    this.folderService.getAllFolders().subscribe((folders:Folder[])=>{
      this.folders=folders;
    });
  }

  onClickFolder(folder:Folder){
    this.router.navigate(['/folder', folder.id]);
  }


}
