package com.example.entrevueSpringBoot.dto;

import lombok.Builder;
import lombok.Value;

import java.util.HashSet;
import java.util.Set;

@Value(staticConstructor = "of")
@Builder
public class MovieDTO {
    String titre;
    String description;
    Set<ActorsDTO> acteurs = new HashSet<>();
}
