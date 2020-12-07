/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.pattern.mvc.view;




import com.pa.pattern.mvc.model.Programmer;

import com.pa.pattern.mvc.controller.GroupController;
import com.pa.pattern.mvc.model.Group;
import com.pa.pattern.observer.Observer;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Collection;


/**
 *
 * @author patriciamacedo
 */
public class GroupUI extends VBox implements Observer{

    //controlos
    private TextField txtInputId;
    private Button btAdd;
    private ListView<Programmer> groupListView;
    private Label lblError;
    private Label lblCount;

    //modelo
    private final Group model;
    
    public GroupUI(Group model) {
        this.model = model;
        initComponents();
        update(model);
    }
    

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
        HBox firstRow = new HBox(txtInputId, btAdd, new Label("Total Value"),lblCount);
        firstRow.setAlignment(Pos.CENTER);
        firstRow.setPadding(new Insets(2,2,2,2));
        firstRow.setSpacing(4);
        this.getChildren().addAll(firstRow, groupListView,lblError);
    }


    public void showError(String msg) {
        lblError.setText(msg);
    }


    public void setTriggers(GroupController controller) {
        btAdd.setOnAction((ActionEvent event) -> {
            controller.doAddMember();
        });

    }

    public String getInputProgrammerId() {
        return txtInputId.getText().trim();
    }


    public String getInputMemberId() {
        return null;
    }

    public void clearInput() {
        txtInputId.setText("");
    }

}
