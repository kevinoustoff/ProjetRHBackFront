import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Folder} from "../models/Folder";
import {geturl} from "../../environments/environment";
import {Offre} from "../models/Offre";
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OffresService {

  constructor(private http:HttpClient) { }

  getAllOffres():Observable<Offre[]> {
    const url=`${geturl()}/api/offres`;

    return this.http.get<Offre[]>(url);
  }

  getOffreDetail(id: number): Observable<Offre> {
    const url = `${geturl()}/api/offres/${id}`;
    return this.http.get<Offre>(url);
  }
}
