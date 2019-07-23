/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookdatabase.Mainscreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class NewUserFXMLController implements Initializable {

    @FXML
    private Button btnRegister;
    @FXML
    private ImageView imgBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img1 = new Image(("images/back.png"));
        imgBack.setImage(img1);
         btnRegister.setOnAction((ActionEvent event) -> {
             Stage stage =(Stage)btnRegister.getScene().getWindow();
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPageFXMLDocument.fxml"));
                 Parent root1 = (Parent) fxmlLoader.load();
                 stage.setTitle("2ndpage");
                 stage.setScene(new Scene(root1));
                 stage.show();
             } catch (Exception e) {
                 System.out.println("not working");
             }
       });
        // TODO
    }    

    @FXML
    private void clickBack(MouseEvent event) {
         Stage stage = (Stage) btnRegister.getScene().getWindow();
        
            try {
               
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPageFXMLDocument.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setTitle("2ndpage");
                    stage.setScene(new Scene(root1));
                    stage.show();
                
            } catch (Exception e) {
                System.out.println("not working");
            }
    }
    
}
