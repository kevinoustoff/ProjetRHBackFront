export interface Candidature {
  id: number;  // L'id est requis
  dateCandidature: string;
  lettreMotivation: string;
  statut: string;
  utilisateur: Utilisateur; // utilisateur doit inclure un id
  offreEmploi: Offre; // offreEmploi doit être un objet avec un id
}

export interface Utilisateur {
  id: number;
  nom: string;
  prenoms: string;
  email: string;
  // Ajoutez d'autres champs si nécessaire
}

export interface Offre {
  id: number;
  nom: string;
  description: string;
  reference: string;
  statut: string;
  datePublication: string;
  duree: string;
  typeEmploi: string;
}
