/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookdatabase.StudentPage;

import bookdatabase.BookList;
import bookdatabase.Books;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class StudentPageFXMLController implements Initializable {

    @FXML
    private Button btnLogout, btnStudentPageExit;

    @FXML
    private Button btnSeeList;
    private final ObservableList<String> studentBookList = FXCollections.observableArrayList();

    @FXML
    private ListView<String> listViewStudent;

    List<Books> bookList = new ArrayList<Books>();

    //adding a few books for example
    Books book1 = new Books(1234, "title", "author", 258, "category");

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
                stage.setTitle("Student Book List");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                System.out.println("Student Book List - not working");
            }
        });

        btnSeeList.setOnAction((ActionEvent event) -> {

            try {
                //            studentBookList.clear();
//            bookList.clear();
//            bookList.add(book1);
//
//            for (int i = 0; i <= bookList.size() - 1; i++) {
//
//                studentBookList.add(bookList.get(i).toString());
//            }
//            listViewStudent.setItems(studentBookList);

//Code for RAF
                RandomAccessFile raf = new RandomAccessFile(new File("test.txt"), "r");

                System.out.println("Length: " + raf.length());
                int num_records = (int) (raf.length() / 188);
                System.out.println("num records is " + num_records);
                int loc = 0;

                raf.seek(loc);
                System.out.println(raf.readInt());
                loc = loc + 4;
                System.out.println("Loc after title is " + loc);

                raf.seek(loc);
                String n = "";
                for (int i = 0; i < 40; i++) {
                    n += String.valueOf(raf.readChar());
                }
                System.out.println(n);
                loc = loc + 80;
                System.out.println("Loc after title is " + loc);

                raf.seek(loc);
                String n1 = "";
                for (int i = 0; i < 30; i++) {
                    n1 += String.valueOf(raf.readChar());
                }
                System.out.println(n1);
                loc = loc + 60;
                System.out.println("Loc after author is " + loc);

                raf.seek(loc);
                System.out.println(raf.readInt());
                loc = loc + 4;
                System.out.println("Loc after edition is " + loc);

                raf.seek(loc);
                String n2 = "";
                for (int i = 0; i < 20; i++) {
                    n2 += String.valueOf(raf.readChar());
                }
                System.out.println(n2);
                loc = loc + 40;
                System.out.println("Loc after category is " + loc);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(StudentPageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StudentPageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        btnStudentPageExit.setOnAction((ActionEvent event) -> {
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

    public static String readString(RandomAccessFile raf, int loc, int size)
            throws java.io.IOException {
        raf.seek(loc);
        String n = "";
        for (int i = 0; i < size; i++) {
            n += String.valueOf(raf.readChar());
        }
        return n;
    }

}
