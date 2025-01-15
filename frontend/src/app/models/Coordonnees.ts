export interface Coordonnees {
    id?: number;           // Utilisé si vous avez besoin d'un identifiant pour les coordonnées
    city: string;      // Adresse de l'utilisateur
    address: string;
    phoneNumber: string;    // Numéro de téléphone
    email: string;       // Email de l'utilisateur (facultatif)
}