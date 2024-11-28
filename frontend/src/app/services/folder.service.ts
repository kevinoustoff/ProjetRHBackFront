import { Injectable } from '@angular/core';
import { Folder } from '../models/Folder';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { geturl } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FolderService {

  constructor(private http:HttpClient) { }

  getAllFolders():Observable<Folder[]> {
    const url=`${geturl()}/api/folders`;

    return this.http.get<Folder[]>(url);
  }

  getFolderById(id:number):Observable<Folder> {
    const url=`${geturl()}/api/folders/${id}`;
    return this.http.get<Folder>(url);
  }
}
