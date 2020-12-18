package com.pa.pattern.mvp.model;
/**
 * @author patricia.macedo
 */

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.util.ArrayList;

public class Group {

    private String name;
    private SimpleListProperty<Programmer> personList;
    private SimpleDoubleProperty globalIndex;
    private SimpleObjectProperty<Programmer> leader;

    public Group(String name) {
        ObservableList<Programmer> observableList = FXCollections.observableArrayList(new ArrayList<Programmer>());
        personList = new SimpleListProperty<>(observableList);
        this.name = name;
        globalIndex=new SimpleDoubleProperty(0);
        leader= new SimpleObjectProperty();
        leader.set(new Programmer(0,"none",0,0));

    }

    /**
     * Enroll the a person to the group
     *
     * @param programmers to be added to group
     */
    public void addMembers(Programmer... programmers) {
        for (Programmer p : programmers)
            if(!personList.contains(p))
                personList.add(p);

    }

    public void addMember(Programmer programmer) {
        if(!personList.contains(programmer)) {
            personList.add(programmer);
            this.globalIndex.set(calculateGlobalIndex());
            this.leader.set(selectLeader());
        }

    }

    /**
     *  remove a meber from the group
     * @param programmer
     */
    public void removeMember(Programmer programmer) throws GroupException {
        if(personList.remove(programmer)==false)
            throw new GroupException(" does not exist to be removed");
        else {
            this.globalIndex.set(calculateGlobalIndex());

            this.leader.set(selectLeader());
        }
    }

    public String getName() {
        return name;
    }

    /**
     * Calculate an indication of the value of the group
     *
     * @return the globalValueIndexoftheGroup
     */
    private float calculateGlobalIndex() {
        int value = 0;
        float res = 0.0f;
        if (personList.size() == 0) return 0;

        int countL = 0;
        for (Programmer programmer : personList) {
            if (programmer.getNumberLanguages() > 5)
                countL++;
        }
        return countL * 1.f / personList.size();
    }


    public double getGlobalIndex() {
        return globalIndex.get();
    }

    public SimpleDoubleProperty globalIndexProperty() {
        return globalIndex;
    }

    /**
     * Select the programmer with expert in more number of languages
     * @return the Leader of the group
     */
    private Programmer selectLeader() {
        int max = -1;

        Programmer leader=new Programmer(0,"none",0,0);
        for (Programmer prog : personList) {
            if (prog.getNumberLanguages() > max) {
                max = prog.getNumberLanguages();
                leader = prog;
            } else {
                // if equals
                if ((prog.getNumberLanguages() == max) && prog.getYearsOfExperience() < leader.getYearsOfExperience())
                    leader = prog;
            }
        }
        return leader;
    }
    @Override
    public String toString() {
        return name;
    }

    public SimpleListProperty<Programmer> getPersonList() {
        return personList;
    }

    public Programmer getLeader() {
        return leader.get();
    }

    public SimpleObjectProperty leaderProperty() {
        return leader;
    }
}
