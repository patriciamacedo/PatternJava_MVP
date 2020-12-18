/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.pattern.mvp.presenter;


import com.pa.pattern.mvp.model.*;
import com.pa.pattern.mvp.view.GroupUI;

/**
 *
 * @author patriciamacedo
 */
public class GroupPresenter {
    
    
    private final GroupUI view;
    private final Group model;


    public GroupPresenter(GroupUI view, Group model) {
        this.view = view;
        this.model = model;
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
