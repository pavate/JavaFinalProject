/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookdatabase.UserLogin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class UserloginFXMLController implements Initializable {

    @FXML
    private Button btnLoginStudent;
    @FXML
    private TextField txtStuID;
    @FXML
    private TextField txtStuPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         btnLoginStudent.setOnAction((ActionEvent event) -> {
             Stage stage =(Stage)btnLoginStudent.getScene().getWindow();
             try {
                 if( txtStuID.getText().equals("user") &&  txtStuPass.getText().equals("user")){
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StudentPageFXML.fxml"));
                 Parent root1 = (Parent) fxmlLoader.load();
                 stage.setTitle("2ndpage");
                 stage.setScene(new Scene(root1));
                 stage.show();
                 }else{
                      Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setX(500);
                alert.setY(350);
                alert.setTitle("Wrong Combination");
                alert.setHeaderText("Password or Username is Wrong ");
                alert.setContentText("Please correct and try again");
                alert.showAndWait();
                  }
             } catch (Exception e) {
                 System.out.println("not working");
             }
       });
        
        // TODO
    }    
    
}
