package br.com.library_management.Model;

import java.util.ArrayList;



public class Book {

    // Atributos da classe Book (Recomendado pelo IDE elas serem Constante)
    private final int idBook;

    private final String name;

    private final ArrayList<String> imageUrl;



    // Construtor que será usado na classe BookInformation para inicializar os atributos com os dados do banco de dados
    public Book (int idBook, String name, ArrayList<String> imageUrl) {
        this.idBook = idBook;
        this.name = name;
        this.imageUrl = imageUrl;
    }


    // Métodos getters para acessar as informações dos atributos
    public int getIdBook() {
        return idBook;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getImageUrl() {
        return imageUrl;
    }
}