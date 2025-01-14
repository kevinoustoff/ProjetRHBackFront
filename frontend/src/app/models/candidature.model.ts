export interface Candidature {
  id: number;  // L'id est requis
  dateCandidature: string;
  lettreMotivation: string;
  statut: string;
  utilisateurId: number; // utilisateur doit inclure un id
  offreEmploiId: number; // offreEmploi doit être un objet avec un id
}

