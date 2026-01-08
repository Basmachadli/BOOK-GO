package fr.miage.bookandgo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agent")
public class Agent {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_user")
    private User user;

    @Enumerated(EnumType.STRING)
    private TypeAgent typeAgent;
}

