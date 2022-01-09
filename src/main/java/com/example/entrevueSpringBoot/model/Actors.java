package com.example.entrevueSpringBoot.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Actors {

    @Id
    @SequenceGenerator(
            name = "actor_id_sequence",
            sequenceName = "actor_id_sequence"
    )
    @GeneratedValue(strategy = SEQUENCE,
            generator = "actor_id_sequence")
    private Long id;
    private String nom;
    private String prenom;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Actors actors = (Actors) o;
        return id != null && Objects.equals(id, actors.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
