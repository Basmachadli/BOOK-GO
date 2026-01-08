package fr.miage.bookandgo.Controller;

import fr.miage.bookandgo.Entity.Agent;
import fr.miage.bookandgo.Repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;

    // Page pour afficher tous les agents
    @GetMapping("/agents")
    public String listAgent(Model model,
                            @RequestParam(value = "keyword", required = false) String keyword) {

        List<Agent> agents;


        // Affiche tous les agents
        agents = agentRepository.findAll();


        model.addAttribute("agents", agents);
        model.addAttribute("keyword", keyword);

        return "agents"; // nom de la vue Thymeleaf (users.html)
    }
}

