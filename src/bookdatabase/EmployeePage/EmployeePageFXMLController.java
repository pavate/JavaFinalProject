/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookdatabase.EmployeePage;

import bookdatabase.Books;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class EmployeePageFXMLController implements Initializable {

    @FXML
    private Button btnLogout, btnAdd, btnDelete, btnRefresh, btnClear, btnEmployeePageExit,btnEmployeeLogin;

    @FXML
    private ListView lstEmployeeBookList;

    @FXML
    private TextField txtISBN, txtTitle, txtAuthor, txtCategory, txtEdition;

    ObservableList<Books> obsBookList = FXCollections.observableArrayList();
    ObservableList<Books> obsEmptyList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnLogout.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) btnLogout.getScene().getWindow();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPageFXMLDocument.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setTitle("Employee Page");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                System.out.println("Logout on Employee Page not working");
            }
        });

        btnAdd.setOnAction((ActionEvent event) -> {
            try {
                Books book = new Books();

                book.setISBN(Integer.parseInt(txtISBN.getText()));
                book.setTitle(txtTitle.getText());
                book.setAuthor(txtAuthor.getText());
                book.setEdition(Integer.parseInt(txtEdition.getText()));
                book.setCategory(txtCategory.getText());

                obsBookList.add(book);

                lstEmployeeBookList.setItems(obsEmptyList);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Add books(Employee) - not working");
            }

        });

        // TODO
        btnRefresh.setOnAction((ActionEvent event) -> {
            try {
                lstEmployeeBookList.setItems(obsBookList);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Refresh books(Employee) - not working");
            }
        });

        btnClear.setOnAction((ActionEvent event) -> {
            try {
                txtISBN.setText("");
                txtTitle.setText("");
                txtEdition.setText("");
                txtCategory.setText("");
                txtAuthor.setText("");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Clear books(Employee) - not working");
            }
        });

        btnDelete.setOnAction((ActionEvent event) -> {
            try {
                obsBookList.remove(lstEmployeeBookList.getSelectionModel().getSelectedItem());

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Remove books(Employee) - not working");
            }
        });

        btnEmployeePageExit.setOnAction((ActionEvent event) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setX(500);
            alert.setY(350);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Exit Application");
            alert.setContentText("Are you sure you want to quit?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.exit(0);
            }
        });

    }

}
