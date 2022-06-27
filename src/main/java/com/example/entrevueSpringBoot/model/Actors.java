package com.example.entrevueSpringBoot.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
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

    @ManyToMany(cascade = {PERSIST, MERGE}, fetch = LAZY)
    private Set<Movie> movies = new HashSet<>();

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
