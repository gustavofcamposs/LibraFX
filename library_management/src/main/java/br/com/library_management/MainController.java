package br.com.library_management;


import java.io.IOException;

//Importado para encerrar a conexão com o banco
import br.com.library_management.Conexao.DatabaseConnection;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class MainController {

    @FXML
    private VBox dynamicContent; //contentPane é ID referente ao AnchorPane que está centralizado    

    @FXML
    private Button home;

    @FXML
    private Button registerNewBook;

    @FXML
    private Button settings;

    @FXML
    private Button logoutButton; // Referência ao botão de logout   



    //Responsável por setar o AnchorPane (Center) as diferentes Telas.
    @FXML
    public void initialize() {

        //e -> (Expressão Lambda) && setContent(Caminho/Para/Tela1.fxml)
        Platform.runLater(() -> {
            home.setOnAction(e -> setContent("/fxml/main/tela1.fxml"));
            registerNewBook.setOnAction(e -> setContent("/fxml/main/tela1.fxml"));  
            settings.setOnAction(e -> setContent("/br/com/library_management/MainScreens/Screen_Settings.fxml"));
        });

    }


    private void setContent(String fxmlPath) {
        dynamicContent.getChildren().clear(); // Limpa qualquer conteúdo que estiver sendo apresentado (RESET);

        try {
            // Carrega o novo conteúdo do arquivo FXML
            Parent newContent = FXMLLoader.load(getClass().getResource(fxmlPath));

            // Defina as dimensões do AnchorPane
            AnchorPane.setTopAnchor(newContent, 0.0);
            AnchorPane.setRightAnchor(newContent, 0.0);
            AnchorPane.setBottomAnchor(newContent, 0.0);
            AnchorPane.setLeftAnchor(newContent, 0.0);

            // Adiciona o novo conteúdo ao contentPane
            dynamicContent.getChildren().add(newContent);

        } catch (IOException e) {
            e.printStackTrace();
            // Em caso de erro, você pode exibir uma mensagem ou realizar outra ação
            Label errorLabel = new Label("Erro ao carregar a tela!" + fxmlPath);
            dynamicContent.getChildren().add(errorLabel);
        }
    }


    // Método de Logout
    public void logout(){

        Alert alert = new Alert(AlertType.NONE, "Deseja realmente sair?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {

            try {

                //Método para Encerrar a conexão do banco de dados PRINCIPAL
                DatabaseConnection.closeConnection();

                //Obtém a janela Atual.
                Stage stage =  (Stage) logoutButton.getScene().getWindow();

                //Carreaga a próxima Janela(Login)
                Parent root = FXMLLoader.load(getClass().getResource("/br/com/library_management/LoginScreen/loginScreen.fxml"));

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

}