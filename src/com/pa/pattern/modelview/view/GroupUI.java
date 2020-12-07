/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.pattern.modelview.view;


import com.pa.pattern.modelview.model.Group;
import com.pa.pattern.modelview.model.GroupException;
import com.pa.pattern.modelview.model.Programmer;
import com.pa.pattern.modelview.model.ProgrammerFactory;
import com.pa.pattern.observer.Observer;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Collection;


/**
 *
 * @author patriciamacedo
 */
public class GroupUI extends VBox implements Observer {

    //controlos
    private TextField txtInputId;
    private Button btAdd;
    private ListView<com.pa.pattern.modelview.model.Programmer> groupListView;
    private Label lblError;
    private Label lblCount;

    //modelo
    private final Group model;
    
    public GroupUI(Group model) {
        this.model = model;
        initComponents();
        setTriggers();
        update(model);
    }
    
    @Override
    public void update(Object o) {
        if(o instanceof Group) {
            Group model = (Group)o;
            Collection<Programmer> listProgrammers = model.getPersonList();
            this.groupListView.getItems().clear();
            groupListView.getItems().addAll(listProgrammers);

            lblCount.setText(String.format("%.1f", model.calculateGlobalIndex()));
        }
    }
    
    private void initComponents() {
        
        this.txtInputId = new TextField();
        this.btAdd = new Button("Add");
        this.groupListView = new ListView<>();
        lblError = new Label();
        
        lblCount = new Label("0");
        
        HBox firstRow = new HBox(txtInputId, btAdd, new Label("Global Index"),lblCount);
        firstRow.setAlignment(Pos.CENTER);
        firstRow.setPadding(new Insets(2,2,2,2));
        firstRow.setSpacing(4);

        this.getChildren().addAll(firstRow, groupListView, lblError);
    }

    private void setTriggers() {
        btAdd.setOnAction((ActionEvent event) -> {
            doAddMember();
        });

    }

    private void doAddMember() {
        String id = getInputProgrammerId();

        try {
            model.addMembers(ProgrammerFactory.getProgrammer(Integer.parseInt(id)));
            clearInput();
        } catch (GroupException e) {
            showError(e.getMessage());
        }
        catch (NumberFormatException e) {
            showError("it is not a number");
        }
    }



    private void showError(String msg) {
        lblError.setText(msg);
    }



    private String getInputProgrammerId() {
        return txtInputId.getText().trim();
    }

    private void clearInput() {
        txtInputId.setText("");
    }

   
    
}
