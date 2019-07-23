/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookdatabase.Mainscreen;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
          btnMainExit.setOnAction((ActionEvent event) -> {
              Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setX(500);
                alert.setY(350);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Would you like to Quit?");
                alert.setContentText("Are you ok with this?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.exit(0);
                }
       });
    }    
    
}
