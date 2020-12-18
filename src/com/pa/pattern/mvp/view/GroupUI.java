/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.pattern.mvp.view;




import com.pa.pattern.mvp.model.Programmer;

import com.pa.pattern.mvp.presenter.GroupPresenter;
import com.pa.pattern.mvp.model.Group;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;


/**
 *
 * @author patriciamacedo
 */
public class GroupUI extends VBox {

    //controlos
    private TextField txtInputId;
    private Button btAdd;
    private ListView<Programmer> groupListView;
    private Label lblError;
    private TextField txtGlobalIndex;
    private TextField txtLeader;

    //modelo
    private final Group model;
    
    public GroupUI(Group model) {
        this.model = model;
        initComponents();

    }
    

    
    private void initComponents() {
        
        this.txtInputId = new TextField();
        this.btAdd = new Button("Add");
        lblError = new Label();
        txtGlobalIndex = new TextField("0");
        txtGlobalIndex.setEditable(false);
        txtLeader = new TextField(model.getLeader().getName());
        txtLeader.setEditable(false);
        this.groupListView = new ListView<>();

        //bindings

       setBindings();

        //compose panel

        HBox firstRow = new HBox(txtInputId, btAdd, new Label("Global Index:"), txtGlobalIndex,new Label("Leader:") ,txtLeader);
        firstRow.setAlignment(Pos.CENTER);
        firstRow.setPadding(new Insets(2,2,2,2));
        firstRow.setSpacing(4);
        this.getChildren().addAll(firstRow, groupListView,lblError);
    }

    private void setBindings() {
        this.groupListView.setItems(model.getPersonList());

        Bindings.bindBidirectional(txtGlobalIndex.textProperty(),model.globalIndexProperty(),
                new NumberStringConverter());

        Bindings.bindBidirectional(txtLeader.textProperty(), model.leaderProperty(), new MyProgrammerConverter());

    }


    public void showError(String msg) {
        lblError.setText(msg);
    }


    public void setTriggers(GroupPresenter controller) {
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

    private class  MyProgrammerConverter extends StringConverter<Programmer> {


        @Override
        public String toString(Programmer object) {
            return object.getName();
        }

        @Override
        public Programmer fromString(String string) {
            return null;
        }
    }
}
