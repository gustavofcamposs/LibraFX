package br.com.library_management;


import java.io.IOException;

import br.com.library_management.Model.AuthenticatedUser;
import br.com.library_management.Model.Employee;
import br.com.library_management.Model.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class LoginController {

    @FXML
    private Label messageLabel;

    @FXML
    private TextField userLogin;

    @FXML
    private PasswordField userPassword;

    //Instanciando o Objeto login
    private Login login = new Login();

    
    //Método que executa o Login.
    @FXML
    void executeLogin(ActionEvent event) {

        if ( userLogin.getText().isEmpty()  ||  userPassword.getText().isEmpty() ) {
            messageLabel.setText("Por favor, preencha os campos corretamente");
        } else{

            //Atribuição dos valores para validação.
            String username = userLogin.getText();
            String password = userPassword.getText();

            Employee employee = login.verificarLogin(username, password);
            if (employee != null) {

                //Responsável por registrar os valores do Funcionário
                AuthenticatedUser.getInstance().setAuthenticatedEmployee(employee);
                openNewWindow();
            } else {  
                messageLabel.setText("Nome de usuário ou senha incorretos");
            }
        }
    }


    //Método responsável por carregar a Main.fxml
    private void openNewWindow() {
        try {
            // Carrega o arquivo FXML da nova janela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/library_management/View/MainScreens/MainView.fxml"));
            Scene scene = new Scene(loader.load());
            
            // Obtém a referência da janela atual
            Stage stage = (Stage) userLogin.getScene().getWindow();
            
            // Define a nova cena na janela atual
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}