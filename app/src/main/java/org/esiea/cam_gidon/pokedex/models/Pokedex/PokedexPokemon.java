package org.esiea.cam_gidon.pokedex.models.Pokedex;

import android.util.Log;
import android.view.View;

import java.util.Comparator;
/**
 * Created by Damien on 28/01/2018.
 */

public class PokedexPokemon {
    private String name;
    private String resource_uri;

    public String getName() {
        return name.substring(0,1).toUpperCase() + name.substring(1);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource_uri() {
        return resource_uri;
    }

    public void setResource_uri(String resource_uri) {
        this.resource_uri = resource_uri;
    }

    public int getPokedexId() {
        return Integer.parseInt(getResource_uri().substring(15, getResource_uri().length() - 1));
    }

    public String get3DigitPokeId() {
        String threeDigitId = "" + getPokedexId();
        while (threeDigitId.length() < 3) {
            threeDigitId = '0' + threeDigitId;
        }
        return threeDigitId;
    }

    public String getImageUrl() {
        return "http://assets22.pokemon.com/assets/cms2/img/pokedex/full/" + get3DigitPokeId() + ".png";
    }
}
