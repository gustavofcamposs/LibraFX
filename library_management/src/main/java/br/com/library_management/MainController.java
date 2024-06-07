package br.com.library_management;


import java.io.IOException;

//Importado para encerrar a conexão com o banco
import br.com.library_management.Conexao.DatabaseConnection;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class MainController {

    @FXML
    private AnchorPane contentPane; //contentPane é ID referente ao AnchorPane que está centralizado    

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button logoutButton; // Referência ao botão de logout



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


    // Método de Logout
    public void logout(){

        Alert alert = new Alert(AlertType.NONE, "Deseja realmente sair?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {

            try {

                //Método para Encerrar a conexão do banco de dados
                DatabaseConnection.closeConnection();

                //Obtém a janela Atual.
                Stage stage =  (Stage) logoutButton.getScene().getWindow();

                //Carreaga a próxima Janela(Login)
                Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));

                // Cria uma nova cena com a tela de login
                Scene scene = new Scene(root);

                // Define a cena no stage
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
                // Mostra um alerta de erro
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Erro ao carregar a tela de login");
                errorAlert.setContentText("Ocorreu um erro ao tentar carregar a tela de login. Tente novamente.");
                errorAlert.showAndWait();
            }
        }
    }


    // Método para encerrar a conexão com o Banco de dados
}