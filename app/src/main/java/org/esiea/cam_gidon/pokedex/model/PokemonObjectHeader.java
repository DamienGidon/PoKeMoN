package org.esiea.cam_gidon.pokedex.model;

import java.util.ArrayList;

/**
 * Created by dgidon on 26/01/2018.
 */

class PokemonObjectHeader {
    private String created;
    private String modified;
    private String name;
    private ArrayList<Pokemon> pokemon;
    private String resource_uri;

    public ArrayList<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(ArrayList<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}

