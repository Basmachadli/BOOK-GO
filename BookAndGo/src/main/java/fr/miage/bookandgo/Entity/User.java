package fr.miage.bookandgo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "numero_tel")
    private String numeroTel;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(nullable = false)
    private String mdp;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "date_inscription", nullable = false)
    private LocalDateTime dateInscription;


    // ===== GETTERS / SETTERS =====

    // ===== Méthode pour remplir la date automatiquement =====
    @PrePersist
    protected void onCreate() {
        this.dateInscription = LocalDateTime.now();
    }
}

