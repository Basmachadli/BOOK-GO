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
@Table(name = "agent_professionnel")
public class AgentProfessionnel {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_agent")
    private Agent agent;

    private String nomPro;
}

