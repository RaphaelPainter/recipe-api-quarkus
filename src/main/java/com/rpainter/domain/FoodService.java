package com.rpainter.domain;

import com.rpainter.model.Ingredient;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import javax.print.attribute.IntegerSyntax;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class FoodService implements FoodServiceInterface {

    @Inject
    private PanacheRepository<Ingredient> ingredientRepository;


    public List<Ingredient> findAll() {
        return ingredientRepository.listAll();
    }

    public List<Ingredient> findSeasonalFood() {
        Date date = Date.from(Instant.now());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int current_month = cal.get(Calendar.MONTH)+1; //current month is 0 based

        return findAll().stream().filter(it ->{
            return isSeasonal(it.season_start, current_month, it.season_end);
        }).collect(Collectors.toList());
    }

    public Boolean isSeasonal(Integer startSeason, Integer currentMonth, Integer endSeason){
        var end = endSeason;
        var current = currentMonth;
        if(startSeason > endSeason){
            if(currentMonth < startSeason){
                current += 12; //nb of month in a year
            }
            end += 12;//nb of month in a year
        }
        System.out.println("start: "+startSeason);
        System.out.println("end: "+end);
        System.out.println("current: "+current);

        return current >= startSeason && current <= end;
    }
}






