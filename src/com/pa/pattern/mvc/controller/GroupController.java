/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.pattern.mvc.controller;


import com.pa.pattern.mvc.model.Group;
import com.pa.pattern.mvc.model.GroupException;
import com.pa.pattern.mvc.model.Programmer;
import com.pa.pattern.mvc.model.ProgrammerFactory;
import com.pa.pattern.mvc.view.GroupUI;

import java.util.Collection;

/**
 *
 * @author patriciamacedo
 */
public class GroupController {
    
    
    private final GroupUI view;
    private final Group model;


    public GroupController(GroupUI view, Group model) {
        this.view = view;
        this.model = model;
        model.addObservers(view);
    }

    /**
     *  Do the action of add a Member to the group - delegate the "work" to the model class.
     *  Handling possible erros and ask view to show them
     *
     */
    public void doAddMember() {
        String id = view.getInputProgrammerId();

        try {
            Programmer p= ProgrammerFactory.getProgrammer(Integer.parseInt(id));
            model.addMember(p);
            view.clearInput();
        } catch (GroupException e) {
           view. showError(e.getMessage());
        }
        catch (NumberFormatException e) {
            view.showError("it is not a number");
        }
    }

}
