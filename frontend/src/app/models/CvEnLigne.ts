import {Experience} from "./Experience";
export interface Competence {
    name: string;
}

export interface CvEnLigne {
    id?: number; // L'ID peut être facultatif lors de la création
    title: string;
    summary: string;
    experiences: Experience[]; // Vous pouvez adapter cela selon votre structure
    formations: { degree: string, institution: string, location: string, graduationDate: string }[]; // Détails des formations
    competences: Competence[]; // Liste des compétences
    langues: { language: string, proficiency: string }[]; // Liste des langues
    localisation: string;
    coordonnees: {
        phoneNumber: string;
        city: string;
        address: string;
        email: string;
    };
    certifications: { certificationName: string, issuingOrganization: string, issueDate: string }[]; // Liste des certifications
}