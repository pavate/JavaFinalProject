/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookdatabase.EmployeePage;

import bookdatabase.Books;
import bookdatabase.StudentPage.StudentPageFXMLController;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class EmployeePageFXMLController implements Initializable {

    @FXML
    private Button btnLogout, btnAdd, btnDelete, btnRefresh, btnClear, btnEmployeePageExit, btnEmployeeLogin;

    @FXML
    private ListView lstEmployeeBookList;

    int ISBN = 0, edition = 0;
    String title, author, category;

    List<Books> bookList = new ArrayList<Books>();

    @FXML
    private TextField txtISBN, txtTitle, txtAuthor, txtCategory, txtEdition;

    private final ObservableList<Books> obsBookList = FXCollections.observableArrayList();
    private final ObservableList<Books> obsEmptyList = FXCollections.observableArrayList();

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
//                Books book = new Books();
//
//                book.setISBN(Integer.parseInt(txtISBN.getText()));
//                book.setTitle(txtTitle.getText());
//                book.setAuthor(txtAuthor.getText());
//                book.setEdition(Integer.parseInt(txtEdition.getText()));
//                book.setCategory(txtCategory.getText());
//
//                obsBookList.add(book);
//
//                lstEmployeeBookList.setItems(obsEmptyList);
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                System.out.println("Add books(Employee) - not working");
//            }
//        });

// Code for RAF
                RandomAccessFile raf = new RandomAccessFile(new File("test.txt"), "rw");

                int TITLE_SIZE = 40;
                int AUTHOR_SIZE = 30;
                int CATEGORY_SIZE = 20;

                String title = txtTitle.getText();
                String author = txtAuthor.getText();
                String category = txtCategory.getText();

                title = title.trim();
                author = author.trim();
                category = category.trim();

                if (title.length() < TITLE_SIZE) {
                    for (int i = title.length(); i < TITLE_SIZE; i++) {
                        title = title + " ";
                    }
                    System.out.println("Length is: " + title.length());
                }

                if (author.length() < AUTHOR_SIZE) {
                    for (int i = author.length(); i < AUTHOR_SIZE; i++) {
                        author = author + " ";
                    }
                    System.out.println("Length is: " + author.length());
                }

                if (category.length() < CATEGORY_SIZE) {
                    for (int i = category.length(); i < CATEGORY_SIZE; i++) {
                        category = category + " ";
                    }
                    System.out.println("Length is:lt " + category.length());
                }

                if (title.length() > TITLE_SIZE) {
//                    for (int i = title.length(); i > TITLE_SIZE; i--) {
//                        title = title.substring(0, title.length() - 2);
//                    }
                    title = title.substring(0, 40);
                    System.out.println("Length is:gt " + title.length());
                }

                if (author.length() > AUTHOR_SIZE) {
//                    for (int i = author.length(); i > AUTHOR_SIZE; i--) {
//                        author = author.substring(0, author.length() - 2);
//                    }
                    author = author.substring(0, 30);
                    System.out.println("Length is:gt " + author.length());
                }

                if (category.length() > CATEGORY_SIZE) {
//                    for (int i = category.length(); i > CATEGORY_SIZE; i--) {
//                        category = category.substring(0, category.length() - 2);
//                    }
                    category = category.substring(0, 20);
                    System.out.println("Length is:gt " + category.length());
                }

                if ((title.length() == TITLE_SIZE) && (author.length() == AUTHOR_SIZE) && (category.length() == CATEGORY_SIZE)) {
                    raf.seek(raf.length());
                    raf.writeInt(Integer.parseInt(txtISBN.getText()));
                    System.out.println("Size of file after ISBN is " + raf.length());
                    raf.writeChars(title);
                    System.out.println("Size of file after Title is " + raf.length());
                    raf.writeChars(author);
                    System.out.println("Size of file after Author is " + raf.length());
                    raf.writeInt(Integer.parseInt(txtEdition.getText()));
                    System.out.println("Size of file after Edition is " + raf.length());
                    raf.writeChars(category);
                    System.out.println("Size of file after Category is " + raf.length());
//                    System.out.println("Length is: " + title.length());
//                    System.out.println("Length is: " + author.length());
//                    System.out.println("Length is: " + category.length());
                    raf.close();
                }

            } catch (FileNotFoundException ex) {
//            Logger.getLogger(EmployeePageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                ex.getMessage();
            } catch (IOException ex) {
                Logger.getLogger(EmployeePageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // TODO
        btnRefresh.setOnAction((ActionEvent event) -> {
            try {
                //lstEmployeeBookList.setItems(obsBookList);

// Code for reading from RAF into observable list
                obsBookList.clear();
                bookList.clear();

                RandomAccessFile raf = new RandomAccessFile(new File("test.txt"), "r");

                System.out.println("Length: " + raf.length());
                int num_records = (int) (raf.length() / 188);
                System.out.println("num records is " + num_records);

                int loc = 0;

                while (loc < raf.length()) {
                    raf.seek(loc);
                    ISBN = raf.readInt();
                    loc = loc + 4;
                    System.out.println("Loc after ISBN is " + loc);

                    raf.seek(loc);
                    String n = "";
                    for (int i = 0; i < 40; i++) {
                        n += String.valueOf(raf.readChar());
                    }
                    System.out.println(n);
                    title = n;
                    loc = loc + 80;
                    System.out.println("Loc after title is " + loc);

                    raf.seek(loc);
                    String n1 = "";
                    for (int i = 0; i < 30; i++) {
                        n1 += String.valueOf(raf.readChar());
                    }
                    System.out.println(n1);
                    author = n1;
                    loc = loc + 60;
                    System.out.println("Loc after author is " + loc);

                    raf.seek(loc);
                    edition = raf.readInt();
                    loc = loc + 4;
                    System.out.println("Loc after edition is " + loc);

                    raf.seek(loc);
                    String n2 = "";
                    for (int i = 0; i < 20; i++) {
                        n2 += String.valueOf(raf.readChar());
                    }
                    System.out.println(n2);
                    category = n2;
                    loc = loc + 40;
                    System.out.println("Loc after category is " + loc);

                    obsBookList.add(new Books(ISBN, title, author, edition, category));
                }

                lstEmployeeBookList.setItems(obsBookList);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(StudentPageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StudentPageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
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
