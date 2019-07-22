/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookdatabase.Mainscreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author acer
 */
public class MainPageFXMLDocumentController implements Initializable {
    @FXML
    private Button btnStudent , btnEmployee;
    @FXML
    private Button btnMainExit;
    @FXML
    private ImageView imgMainscreen;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Image img =new Image(("images/books.jpg"));
        imgMainscreen.setImage(img);
         btnStudent.setOnAction((ActionEvent event) -> {
             Stage stage =(Stage)btnStudent.getScene().getWindow();
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserloginFXML.fxml"));
                 Parent root1 = (Parent) fxmlLoader.load();
                 stage.setTitle("2ndpage");
                 stage.setScene(new Scene(root1));
                 stage.show();
             } catch (Exception e) {
                 System.out.println("not working");
             }
       });
          btnEmployee.setOnAction((ActionEvent event) -> {
             Stage stage =(Stage)btnEmployee.getScene().getWindow();
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmployeeloginFXML.fxml"));
                 Parent root1 = (Parent) fxmlLoader.load();
                 stage.setTitle("2ndpage");
                 stage.setScene(new Scene(root1));
                 stage.show();
             } catch (Exception e) {
                 System.out.println("not working");
             }
       });
    }    
    
}
