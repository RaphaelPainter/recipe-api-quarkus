package com.rpainter.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.ws.rs.Path;

import java.util.UUID;

@Entity
public class Chef extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID id;

    public String name;

}
