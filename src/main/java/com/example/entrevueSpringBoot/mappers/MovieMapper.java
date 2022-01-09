package com.example.entrevueSpringBoot.mappers;

import com.example.entrevueSpringBoot.dto.MovieDTO;
import com.example.entrevueSpringBoot.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring"/*, uses = ActorsMapper.class*/)
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "acteurs.id", ignore = true)
    Movie toMovie(MovieDTO movieDTO);

}
