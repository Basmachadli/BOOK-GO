package fr.miage.bookandgo.Controller;

import fr.miage.bookandgo.Entity.User;
import fr.miage.bookandgo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Page pour afficher tous les utilisateurs
    @GetMapping("/users")
    public String listUsers(Model model,
                            @RequestParam(value = "keyword", required = false) String keyword) {

        List<User> users;

        if (keyword != null && !keyword.isEmpty()) {
            // Recherche par nom
            users = userRepository.findByNomContainingIgnoreCase(keyword);
        } else {
            // Affiche tous les utilisateurs
            users = userRepository.findAll();
        }

        model.addAttribute("users", users);
        model.addAttribute("keyword", keyword);

        return "users"; // nom de la vue Thymeleaf (users.html)
    }
}
