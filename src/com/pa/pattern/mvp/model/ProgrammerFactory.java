package com.pa.pattern.mvp.model;

import java.util.HashMap;
import java.util.Map;

public class ProgrammerFactory {

    /**
     * Class to support the example - Encpsulate the creation of a base list of Programmers
     */
    private static Map<Integer, Programmer> programmerMap = generateProgrammerList();

    private static Map<Integer, Programmer> generateProgrammerList() {


        Map<Integer, Programmer> programmerMap = new HashMap();
        programmerMap.put(1, new Programmer(1, "Ana",5,2));
        programmerMap.put(2, new Programmer(2, "Pedro",5,10));
        programmerMap.put(3, new Programmer(3, "Rui",6,12));
        programmerMap.put(4, new Programmer(4, "Joao",2,5));
        programmerMap.put(5, new Programmer(5, "Luis",8,3));
        programmerMap.put(6, new Programmer(6, "Rita",5,3));
        programmerMap.put(7, new Programmer(7, "Sonia",15,4));
        programmerMap.put(8, new Programmer(9, "Sofia",10,4));
        programmerMap.put(9, new Programmer(10, "Pedro",15,14));
        programmerMap.put(10, new Programmer(11, "Alberto",11,5));
        programmerMap.put(11, new Programmer(12, "Andre",16,2));
        programmerMap.put(12, new Programmer(13, "Sara",5,4));
        programmerMap.put(13, new Programmer(14, "Marta",15,2));

        return programmerMap;

    }

    /**
     *
     * @param id - id of the programmer to lookfor
     * @return a programmer with a sepcific id
     */
    public static Programmer getProgrammer(int id) {

        Programmer p = programmerMap.get(id);
        if (p == null) throw new GroupException("Programmer " + id + " does not exist");
        return p;

    }


}
