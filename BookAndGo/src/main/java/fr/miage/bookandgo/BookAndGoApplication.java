package fr.miage.bookandgo;

import fr.miage.bookandgo.Entity.Role;
import fr.miage.bookandgo.Entity.User;
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

   
}

