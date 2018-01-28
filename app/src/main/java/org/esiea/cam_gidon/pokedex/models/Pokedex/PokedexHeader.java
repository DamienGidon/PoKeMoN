package org.esiea.cam_gidon.pokedex.models.Pokedex;

import java.util.ArrayList;
/**
 * Created by Damien on 28/01/2018.
 */

public class PokedexHeader {
    private PokedexMetaHeader meta;
    private ArrayList<PokedexObjectHeader> objects;

    public PokedexMetaHeader getMeta() {
        return meta;
    }

    public void setMeta(PokedexMetaHeader meta) {
        this.meta = meta;
    }

    public ArrayList<PokedexObjectHeader> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<PokedexObjectHeader> objects) {
        this.objects = objects;
    }
}

