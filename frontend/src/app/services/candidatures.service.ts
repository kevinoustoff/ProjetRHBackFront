import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Candidature } from '../models/candidature.model';
import { geturl } from '../../environments/environment';
import { Candidaturecomplet } from '../models/candidaturecomplet.model';

@Injectable({
  providedIn: 'root'
})
export class CandidaturesService {

  constructor(private http: HttpClient) { }

  // Récupérer toutes les candidatures
  getAllCandidatures(): Observable<Candidaturecomplet[]> {
    const url = `${geturl()}/api/candidatures`;
    return this.http.get<Candidaturecomplet[]>(url);
  }

  // Ajouter une nouvelle candidature
  addCandidature(candidature: Candidature): Observable<Candidature> {
    const url = `${geturl()}/api/candidatures`;
    return this.http.post<Candidature>(url, candidature);
  }

  // Récupérer les détails d'une candidature spécifique
  getCandidatureDetail(id: number): Observable<Candidature> {
    const url = `${geturl()}/api/candidatures/${id}`;
    return this.http.get<Candidature>(url);
  }

  // Mettre à jour une candidature existante
  updateCandidature(id: number, candidature: Candidature): Observable<Candidature> {
    const url = `${geturl()}/api/candidatures/${id}`;
    return this.http.put<Candidature>(url, candidature);
  }

  // Supprimer une candidature
  deleteCandidature(id: number): Observable<void> {
    const url = `${geturl()}/api/candidatures/${id}`;
    return this.http.delete<void>(url);
  }
}
