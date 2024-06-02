package br.com.library_management;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private AnchorPane contentPane; //contentPane é ID referente ao AnchorPane que está centralizado    

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;


    //Responsável por setar o AnchorPane (Center) as diferentes Telas.
    @FXML
    public void initialize() {
        //e -> (Expressão Lambda) && setContent(Caminho/Para/Tela1.fxml)
        button1.setOnAction(e -> setContent("Tela 1"));
        button2.setOnAction(e -> setContent("Tela 2"));
        button3.setOnAction(e -> setContent("Tela 3"));
    }

    private void setContent(String content) {
        contentPane.getChildren().clear(); //Responsável por limpar qualquer contéudo que estiver sendo aprensentado (RESET);

        Label contentLabel = new Label(content); //Novo Rótulo que exibirá o conteúdo passado como argumento (content)
        
        //Node Child e Valor (Parâmetros).
        AnchorPane.setTopAnchor(contentLabel, 100.00);
        AnchorPane.setLeftAnchor(contentLabel, 100.00); 

        contentPane.getChildren().add(contentLabel);
    }
}