package com.pa.pattern.modelview.model;
/**
 * @author patricia.macedo
 */

import com.pa.pattern.observer.Subject;

import java.lang.reflect.Array;
import java.util.*;

public class Group extends Subject {

    private String name;
    private ArrayList<Programmer> personList;

    /**
     * @param name of the group
     */
    public Group(String name) {
        this.name = name;
        personList = new ArrayList<>();
    }

    /**
     * Enroll the a person to the group
     *
     * @param programmers to be added to group
     */
    public void addMembers(Programmer... programmers) {
        for (Programmer p : programmers)
            if (!personList.contains(p))
                personList.add(p);
        notifyObservers(this);
    }

    public void addMember(Programmer programmer) {
        if (!personList.contains(programmer))
            personList.add(programmer);
        notifyObservers(this);
    }



    public String getName() {
        return name;
    }

    /**
     * Calculate an indication of the value of the group
     *
     * @return the globalValueIndexoftheGroup
     */
    public float calculateGlobalIndex() {
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


    /**
     * Select the programmer with expert in more number of languages
     *
     * @return the Leader of the group
     */
    public Programmer selectLeader() {
        int max = -1;
        Programmer leader = null;
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

    public Collection<Programmer> getPersonList() {
        List<Programmer> list = new ArrayList(this.personList);
        return list;
    }
}
