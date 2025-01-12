import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {CvEnLigne} from "../models/CvEnLigne";
import {geturl} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CvEnLigneService {


  constructor(private http: HttpClient) { }

  createCv(cv: CvEnLigne): Observable<CvEnLigne> {
    const url=`${geturl()}/api/cvsenligne`;
    return this.http.post<CvEnLigne>(url, cv);
  }
  getCvByUserId(id: number): Observable<CvEnLigne> {
    return this.http.get<CvEnLigne>(`${geturl()}/api/cvsenligne/user/${id}`);
  }
}
