package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField emailField;

    @FXML
    private ListView<Teacher> teacherList;
    @FXML
    private ListView<String> classList;

    @FXML
    private void initialize(){
        teacherList.getItems().addAll(Main.getTeachers());
        idField.setDisable(true);
        nameField.setDisable(true);
        surnameField.setDisable(true);
        emailField.setDisable(true);
    }

    public void updateClasses(){
        classList.getItems().clear();
        classList.getItems().addAll(Main.getClasses(teacherList.getSelectionModel().getSelectedItem().getID()));
    }

    public void changeTeacher(){
        updateClasses();
        Teacher temp = teacherList.getSelectionModel().getSelectedItem();
        idField.setText(Integer.toString(temp.getID()));
        nameField.setText(temp.getName());
        surnameField.setText(temp.getSurname());
        emailField.setText(temp.getEmail());
    }
}
