import { Component, OnInit } from '@angular/core';
import { File } from '../../models/File';
import { ActivatedRoute } from '@angular/router';
import { FolderService } from '../../services/folder.service';
import { Folder } from '../../models/Folder';

@Component({
  selector: 'app-file-list',
  templateUrl: './file-list.component.html',
  styleUrl: './file-list.component.scss'
})
export class FileListComponent implements OnInit{

  files:File[]=[];
  constructor(private route: ActivatedRoute,private folderService:FolderService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = params['id'];
      this.folderService.getFolderById(id).subscribe((folder:Folder)=>{
        this.files=folder.files;
      });
    });
  }
}
