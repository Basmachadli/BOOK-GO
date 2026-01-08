package fr.miage.bookandgo.Repository;

import fr.miage.bookandgo.Entity.Loueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoueurRepository extends JpaRepository<Loueur, Long> {

    // chercher par email
    Loueur findByUserEmail(String email);
}
