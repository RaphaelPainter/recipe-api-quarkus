package com.rpainter.repository;

import com.rpainter.model.Chef;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Singleton;

import java.util.Set;

@Singleton
public class CookRepository implements PanacheRepository<Chef> {

}
