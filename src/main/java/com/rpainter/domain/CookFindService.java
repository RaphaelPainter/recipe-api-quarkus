package com.rpainter.domain;

import com.rpainter.model.Chef;
import com.rpainter.model.Ingredient;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Singleton
public class CookFindService implements CookFindServiceInterface {

    @Inject
    private PanacheRepository<Chef> cookRepository;


    public List<Chef> findAll() {
        return cookRepository.listAll();
    }


}
