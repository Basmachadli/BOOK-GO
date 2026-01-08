package fr.miage.bookandgo.Service;

import fr.miage.bookandgo.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class LoueurService extends User {

    public boolean peutLouer(User user) {
        return "ACTIF".equals(user.getStatusCompte());
    }

    public void publierAnnonce(User user) {
        if (!peutLouer(user)) {
            throw new IllegalStateException("Compte inactif");
        }
        // logique métier
    }
}
