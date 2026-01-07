package fr.miage.bookandgo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "numero_tel")
    private Integer numeroTel;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(nullable = false)
    private String mdp;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // ===== CONSTRUCTEURS =====

    public User() {
    }

    public User(String nom, String prenom, String email, Integer numeroTel,
                LocalDate dateNaissance, String mdp, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numeroTel = numeroTel;
        this.dateNaissance = dateNaissance;
        this.mdp = mdp;
        this.role = role;
    }

    // ===== GETTERS / SETTERS =====

}

