package models;

import java.util.ArrayList;
import java.util.List;

public class Cake {
    private Integer id;
    private String sponge;
    private String cream;
    private String filling;
    private String shape;
    private Integer tier;
    List<Cake> cakery = new ArrayList<Cake>();


    public List<Cake> getCakery() {
        return cakery;
    }


    public Cake() {}

    public Cake(String sponge, String cream, String filling) {
        this.sponge = sponge;
        this.cream = cream;
        this.filling = filling;
    }

    public Cake(Integer id, String sponge, String cream, String filling, String shape, Integer tier) {
        this.id = id;
        this.sponge = sponge;
        this.cream = cream;
        this.filling = filling;
        this.shape = shape;
        this.tier = tier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSponge() {
        return sponge;
    }

    public void setSponge(String sponge) {
        this.sponge = sponge;
    }

    public String getCream() {
        return cream;
    }

    public void setCream(String cream) {
        this.cream = cream;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    public void add(Cake cake) {
        cake.add(cake);
    }
}
