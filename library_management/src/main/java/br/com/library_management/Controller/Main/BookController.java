package br.com.library_management.Controller.Main;

import br.com.library_management.Model.Book;
import br.com.library_management.Model.BookInformation;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class BookController {

    @FXML
    private VBox contentContainer;

    @FXML
    public void initialize() {
        // Obtém a lista de livros
        BookInformation bookInfo = new BookInformation();
        List<Book> books = bookInfo.getAllBooks();

        int maxBooksPerHBox = 4;
        int bookCount = 0;

        // Cria o primeiro HBox para organizar as imagens em uma linha
        HBox currentHBox = createNewHBox();
        contentContainer.getChildren().add(currentHBox);

        // Itera sobre cada livro na lista
        for (Book book : books) {

            // Itera sobre cada URL de imagem do livro
            for (String imageUrl : book.getImageUrl()) {
                if (bookCount == maxBooksPerHBox) { //
                    // Cria um novo HBox e adiciona ao VBox
                    currentHBox = createNewHBox();
                    contentContainer.getChildren().add(currentHBox);
                    bookCount = 0; // Reseta a contagem de livros para o novo HBox
                }

                // Cria um ImageView para cada URL de imagem
                ImageView imageView = new ImageView();
                Image image = new Image(imageUrl); // Carrega a imagem a partir da URL
                imageView.setImage(image); // Define a imagem no ImageView
                imageView.setFitWidth(150); // Define a largura do ImageView
                imageView.setPreserveRatio(true); // Mantém a proporção da imagem

                // Adiciona o ImageView ao HBox atual
                currentHBox.getChildren().add(imageView);
                bookCount++;
            }
        }

    }

    private HBox createNewHBox() {
        HBox hbox = new HBox(15); // Espaço de 15 pixels entre as imagens
        hbox.setMinWidth(650);
        hbox.setMinHeight(250);
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }
}
