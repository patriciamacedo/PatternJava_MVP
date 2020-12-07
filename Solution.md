Exercicio1

Na classe `GrupoUI`

```java
// acrescentar um atributo 
 private Button btRemove;

// instanciar e adicionar o componente
 private void initComponents() {
        
        this.txtInputId = new TextField();
        this.btAdd = new Button("Add");
        this.groupListView = new ListView<>();
        lblError = new Label();
        
        lblCount = new Label("0");

        this.btRemove = new Button("Remove");
        HBox firstRow = new HBox(txtInputId, btAdd, new Label("Total Value"),lblCount, btRemove);
        firstRow.setAlignment(Pos.CENTER);
        firstRow.setPadding(new Insets(2,2,2,2));
        firstRow.setSpacing(4);

        this.getChildren().addAll(firstRow, groupListView, lblError);
    }


// adicionar um trigger ao novo botão
    public void setTriggers(GroupController controller) {
        btAdd.setOnAction((ActionEvent event) -> {
            controller.doAddMember();
        });
        btRemove.setOnAction((ActionEvent event) -> {
            controller.doRemoveMember();
        });

    }

 // adicionar um metodo para devolver os items selecioandos da listVie
 public Collection<Programmer> getSelectedItem() {

        return groupListView.getSelectionModel().getSelectedItems();
    }

```

Na classe `GroupController`
```java
public void doRemoveMember() {

        try {
            Collection<Programmer> list = view.getSelectedItem();
            for(Programmer p: list)
                model.removeMember(p);

        } catch (GroupException e) {
            view. showError(e.getMessage());
        }
    }

```

Exercicio 2
Na classe `GrupoUI`

```java
// acrescentar um atributo 
 private Label leader;

// instanciar e adicionar o componente label no método initComponents
 private void initComponents() {
        //o restante manter igual
       // Acrescentar
        leader= new Label("Leader: ");
        // adicionar ao panel o componente leader
        this.getChildren().addAll(firstRow, groupListView, leader,lblError);
    }


// alterar o método update para incluir a atualização da variável leader
    

  public void update(Object o) {
         if(o instanceof Group) {
             Group model = (Group)o;
             Collection<Programmer> listProgrammers = model.getPersonList();
             this.groupListView.getItems().clear();
             groupListView.getItems().addAll(listProgrammers);
             lblCount.setText(String.format("%.1f", model.calculateGlobalIndex()));
             
             //leader
             Programmer p=model.selectLeader();
             String textLeader="Leader: ";
             if(p!=null)
                 textLeader+=p.getName();
             leader.setText (textLeader);
         }
     }
```
