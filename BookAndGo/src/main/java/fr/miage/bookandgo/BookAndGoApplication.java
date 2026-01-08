package fr.miage.bookandgo;

import fr.miage.bookandgo.Entity.*;
import fr.miage.bookandgo.Repository.AgentProfessionnelRepository;
import fr.miage.bookandgo.Repository.AgentRepository;
import fr.miage.bookandgo.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.LocalDate;


@SpringBootApplication
public class BookAndGoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookAndGoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(
            UserRepository userRepository,
            AgentRepository agentRepository,
            AgentProfessionnelRepository agentProRepository) {
        return args -> {

            // 1️⃣ Créer le User
            User user = new User();
            user.setNom("Philipe");
            user.setPrenom("Wala");
            user.setEmail("philipe.wala@example.com");
            user.setNumeroTel("0783127591");
            user.setDateNaissance(LocalDate.of(2025, 2, 7));
            user.setMdp("demitasse");
            user.setRole(Role.AGENT); // rôle global
            userRepository.save(user); // save User en premier

            // 2️⃣ Créer l'Agent lié au User
            Agent agent = new Agent();
            agent.setUser(user); // lien OneToOne
            agent.setTypeAgent(TypeAgent.PROFESSIONNEL);
            agentRepository.save(agent); // save Agent

            // 3️⃣ Créer AgentProfessionnel lié à l'Agent
            AgentProfessionnel agentPro = new AgentProfessionnel();
            agentPro.setAgent(agent); // lien OneToOne
            agentPro.setNomPro("Philipe Wala SARL");
            agentProRepository.save(agentPro);

            System.out.println("Agent professionnel créé avec succès !");
        };
    }

};

