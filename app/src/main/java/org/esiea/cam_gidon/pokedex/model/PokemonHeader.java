package org.esiea.cam_gidon.pokedex.model;

import java.util.ArrayList;

/**
 * Created by dgidon on 26/01/2018.
 */

public class PokemonHeader {
    private PokemonMetaHeader meta;
    private ArrayList<PokemonObjectHeader> objects;

    public PokemonMetaHeader getMeta() {
        return meta;
    }

    public void setMeta(PokemonMetaHeader meta) {
        this.meta = meta;
    }

    public ArrayList<PokemonObjectHeader> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<PokemonObjectHeader> objects) {
        this.objects = objects;
    }
}
