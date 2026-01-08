package fr.miage.bookandgo.Repository;

import fr.miage.bookandgo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Recherche par nom (ignore la casse)
    @Query("SELECT u FROM User u WHERE LOWER(u.nom) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<User> findByNomContainingIgnoreCase(@Param("keyword") String keyword);

    // Tu peux aussi ajouter une recherche par prénom si besoin
    @Query("SELECT u FROM User u WHERE LOWER(u.prenom) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<User> findByPrenomContainingIgnoreCase(@Param("keyword") String keyword);

    // Vérifier si un email existe déjà
    boolean existsByEmail(String email);

    // Chercher un utilisateur par email (utile pour la connexion)
    User findByEmail(String email);
}
