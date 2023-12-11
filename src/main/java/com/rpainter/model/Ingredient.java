package com.rpainter.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Ingredient extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID id;

    public String name;

    public Integer season_start;

    public Integer season_end;

    public String image;


}
