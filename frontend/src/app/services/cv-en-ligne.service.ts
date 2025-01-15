import { Injectable } from '@angular/core';
import {catchError, map, Observable, of} from "rxjs";
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
  getCvById(id: number): Observable<CvEnLigne> {
    return this.http.get<CvEnLigne>(`${geturl()}/api/cvsenligne/${id}`);
  }

  updateCv(cv: CvEnLigne): Observable<CvEnLigne> {
    return this.http.put<CvEnLigne>(`${geturl()}/api/cvsenligne/${cv.id}`, cv);
  }

  hasACv(userId: number): Observable<boolean> {
    return this.getCvByUserId(userId).pipe(
        map((cv) => !!cv), // Retourne `true` si un CV existe
        catchError(() => of(false)) // Retourne `false` en cas d'erreur (ex. 404)
    );
  }
}
