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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;


public class MainController {


    @FXML
    private VBox dynamicContent; //contentPane é ID referente ao AnchorPane que está centralizado

    @FXML   
    private VBox menuContent;

    @FXML
    private Button home;

    @FXML
    private Button registerNewBook;

    @FXML
    private Button settings;

    @FXML
    private Button logoutButton; // Referência ao botão de logout   


    @FXML
    public void initialize() {

        //e -> (Expressão Lambda) && setContent(Caminho/Para/Tela1.fxml)
        Platform.runLater(() -> {
            home.setOnAction(e -> loadContent("/fxml/main/tela1.fxml"));
            registerNewBook.setOnAction(e -> loadContent("/fxml/main/tela2.fxml"));  
            settings.setOnAction(e -> loadContent("/br/com/library_management/View/MainScreen/Screen_Settings.fxml"));
        });

    }


    //Usado para mudar a cor
    @SuppressWarnings("exports")
    public VBox getDynamicContent() {
        return dynamicContent;
    }

    @SuppressWarnings("exports")
    public VBox getMenuContent(){
        return menuContent;
    }


    private void loadContent(String fxmlPath) {
        try {

            /*Localiza e obtém a URL do arquivo FXML. Esta etapa é essencial para informar ao FXMLLoader onde encontrar o
            arquivo FXML que será carregado.*/
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

            //Carrega o conteúdo do arquivo FXML especificado pela URL anteriormente obtida
            Parent newContent = loader.load();
    
            // Se o controlador carregado for do tipo Settings  Controller, configura o MainController
            if (loader.getController() instanceof SettingsController) {
                SettingsController settingsController = loader.getController();
                settingsController.setMainController(this); // Passa a instância atual do MainController

                SettingsController settingsController2 = loader.getController();
                settingsController2.setMenuController(this); // Passa a instância atual do MainController
            }

            // Limpa o conteúdo atual e define o novo conteúdo
            dynamicContent.getChildren().clear();
            dynamicContent.getChildren().add(newContent); //O que foi carregado mostrará na tela
    
        } catch (Exception e) {
            e.printStackTrace();
            dynamicContent.getChildren().clear();
            Label errorLabel = new Label("Erro ao carregar a tela! " + fxmlPath);
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
                Parent root = FXMLLoader.load(getClass().getResource("/br/com/library_management/View/LoginScreen/loginScreen.fxml"));

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