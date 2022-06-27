package com.example.entrevueSpringBoot.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Value(staticConstructor = "of")
@Builder
public class ActorsDTO {
    String nom;
    String prenom;
    Set<MovieDTO> movieDTOS = new HashSet<>();
}
