package task1.entity;

import java.io.Serializable;

public enum Type implements Serializable {
    DESSERT("Dessert"), FISH("Fish"), SALAD("Salad");

    private final String name;

    Type(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return " Type = " + name;
    }

}
