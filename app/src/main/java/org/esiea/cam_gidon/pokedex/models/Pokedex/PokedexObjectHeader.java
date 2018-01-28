package org.esiea.cam_gidon.pokedex.models.Pokedex;

import java.util.ArrayList;
/**
 * Created by Damien on 28/01/2018.
 */

public class PokedexObjectHeader {
    private String created;
    private String modified;
    private String name;
    private ArrayList<PokedexPokemon> pokemon;
    private String resource_uri;

    public ArrayList<PokedexPokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(ArrayList<PokedexPokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
