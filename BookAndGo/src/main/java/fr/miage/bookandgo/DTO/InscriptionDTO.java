package fr.miage.bookandgo.dto;

import fr.miage.bookandgo.Entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscriptionDTO {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Role role; // LOUEUR, AGENT, AGENT_PRO
    private String siret; // uniquement pour agent pro
    private String rib;   // pour agent (les deux)
}
