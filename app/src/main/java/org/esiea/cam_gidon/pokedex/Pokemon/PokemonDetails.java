package org.esiea.cam_gidon.pokedex.Pokemon;

import java.util.ArrayList;

/**
 * Created by dgidon on 26/01/2018.
 */

public class PokemonDetails {
    ArrayList<PokemonDetailItem> abilities;
    int attack;
    int catch_rate;
    String created;
    ArrayList<PokemonDetailItem> descriptions;
    int egg_cycles;
    ArrayList<PokemonDetailItem> egg_groups;
    String ev_yield;
    ArrayList<PokemonEvolution> evolutions;
    int exp;
    String growth_rate;
    int happiness;
    String height;
    int hp;
    String male_female_ratio;
    String modified;
    ArrayList<PokemonMove> moves;
    String name;
    int national_id;
    int pkdx_id;
    String resource_uri;
    int sp_atk;
    int sp_def;
    String species;
    int speed;
    ArrayList<PokemonDetailItem> sprites;
    int total;
    ArrayList<PokemonType> types;
    String weight;

    public String getName() {
        return name;
    }

    public ArrayList<PokemonType> getTypes() {
        return types;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAttack() {
        return attack;
    }

    public int getHp() {
        return hp;
    }
}
