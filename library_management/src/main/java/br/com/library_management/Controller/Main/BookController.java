package br.com.library_management.Controller.Main;

import br.com.library_management.Model.Book;
import br.com.library_management.Model.BookInformation;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class BookController {

    @FXML
    private AnchorPane Pane;

    @FXML
    public void initialize() {
        // Obtém a lista de livros
        BookInformation bookInfo = new BookInformation();
        List<Book> books = bookInfo.getAllBooks();

        // Cria um VBox para organizar as imagens em uma coluna
        VBox vbox = new VBox(10); // Espaço de 10 pixels entre as imagens

        // Itera sobre cada livro na lista
        for (Book book : books) {
            // Itera sobre cada URL de imagem do livro
            for (String imageUrl : book.getImageUrl()) {
                // Cria um ImageView para cada URL de imagem
                ImageView imageView = new ImageView();
                Image image = new Image(imageUrl); // Carrega a imagem a partir da URL
                imageView.setImage(image); // Define a imagem no ImageView

                imageView.setFitWidth(150); // Define a largura do ImageView
                imageView.setPreserveRatio(true); // Mantém a proporção da imagem

                // Adiciona o ImageView ao VBox
                vbox.getChildren().add(imageView);
            }

            // Debugging: imprime informações do livro
            System.out.println("ID: " + book.getIdBook());
            System.out.println("Title: " + book.getName());
            System.out.println("Images: " + book.getImageUrl());
        }

        // Adiciona o VBox ao AnchorPane
        Pane.getChildren().add(vbox);
        // Ajusta o VBox para preencher o AnchorPane
        AnchorPane.setTopAnchor(vbox, 10.0);
        AnchorPane.setLeftAnchor(vbox, 10.0);
        AnchorPane.setRightAnchor(vbox, 10.0);
    }
}
