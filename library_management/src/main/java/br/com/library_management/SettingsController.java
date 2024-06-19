package br.com.library_management;


import br.com.library_management.Model.AuthenticatedUser;
import br.com.library_management.Model.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SettingsController {

    @FXML
    private Label teste;



    @FXML
    public void TESTE(){
        Employee authenticatedEmployee = AuthenticatedUser.getInstance().getAuthenticatedEmployee();
        teste.setText(authenticatedEmployee.getEmail());
    }    

    @FXML
    public void initialize() {
        // Exemplo de chamada no método initialize, para testar ao iniciar a tela
        TESTE();
    }
}