package br.com.library_management.Model;

import br.com.library_management.Conexao.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;



public class BookInformation {

    // Método para obter todos os livros do banco de dados
    public List<Book> getAllBooks() {

        // Obtém uma conexão com o banco de dados utilizando a classe DatabaseConnection
        Connection conn = DatabaseConnection.getConnection();

        // Declara uma lista de livros que será retornada
        List<Book> books = new ArrayList<>();

        if (conn != null) {

            // Consulta SQL para selecionar todos os registros da tabela 'books'
            String query = "SELECT * FROM books";

            try {

                // Prepara a declaração SQL.
                PreparedStatement stmt = conn.prepareStatement(query);

                // Executa a consulta e obtém o resultado.
                ResultSet rs = stmt.executeQuery();

                // Enquanto tiver informações, percorrer e passar as informações ao Construtor da classe Book
                while (rs.next()) {

                    // Obtém os dados de cada coluna do registro atual
                    int idBook = rs.getInt("id_book");
                    String name = rs.getString("title");

                    // Uma lista para armazenar URLs das imagens do livro
                    ArrayList<String> bookImagesUrl = new ArrayList<>();

                    //Essa variável recebe de forma única cada valor que depois será adicionado a Lista criada acima.
                    String bookImage = rs.getString("book_image");
                    bookImagesUrl.add(bookImage); // Adiciona a URL da imagem à lista

                    // Cria um objeto Book com os dados obtidos para o Construtor da Classe.
                    Book book = new Book(idBook, name, bookImagesUrl);

                    // Adiciona o objeto Book à lista de livros
                    books.add(book);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // Finalmente encerrando a conexão com o Banco de dados
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        // Retorna a lista de livros
        return books;
    }
}
