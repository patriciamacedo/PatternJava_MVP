package com.pa.pattern.mvc.model;

import java.util.Objects;

/**
 * @author patricia.macedo
 *
 */
public class Programmer {
    private int id;
    private String name;

    private int yearsOfExperience;
    private int numberLanguages;

    public Programmer(int id, String name, int yearsOfExperience, int numberLanguages) {
        this.id = id;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.numberLanguages = numberLanguages;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%d:%s: Years:%d LG:%d", id,name,yearsOfExperience,numberLanguages);
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getNumberLanguages() {
        return numberLanguages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Programmer)) return false;
        Programmer that = (Programmer) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
