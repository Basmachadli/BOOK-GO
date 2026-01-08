package fr.miage.bookandgo.Controller;

import fr.miage.bookandgo.Entity.User;
import fr.miage.bookandgo.Service.AuthService;
import fr.miage.bookandgo.dto.ConnexionDTO;
import fr.miage.bookandgo.dto.InscriptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    // Inscription
    @GetMapping("/inscription")
    public String showInscriptionForm(Model model) {
        model.addAttribute("inscriptionDTO", new InscriptionDTO());
        return "inscription";
    }

    @PostMapping("/inscription")
    public String inscriptionSubmit(@ModelAttribute InscriptionDTO inscriptionDTO, Model model) {
        try {
            User user = authService.inscription(inscriptionDTO);
            model.addAttribute("message", "Inscription réussie !");
            return "connexion"; // redirige vers la page de connexion après inscription
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "inscription"; // reste sur la page inscription si erreur
        }
    }

    // Connexion
    @GetMapping("/connexion")
    public String showConnexionForm(Model model) {
        model.addAttribute("connexionDTO", new ConnexionDTO());
        return "connexion";
    }

    @PostMapping("/connexion")
    public String connexionSubmit(@ModelAttribute ConnexionDTO connexionDTO, Model model) {
        try {
            User user = authService.connexion(connexionDTO);
            model.addAttribute("user", user);
            return "dashboard"; // redirige vers une page après connexion
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "connexion"; // reste sur la page connexion si erreur
        }
    }
}
