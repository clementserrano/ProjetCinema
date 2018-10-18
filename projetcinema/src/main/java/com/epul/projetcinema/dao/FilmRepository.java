package com.epul.info.projetcinema.dao;

import com.epul.info.projetcinema.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public abstract class FilmRepository implements JpaRepository<Film, Long> {
}
