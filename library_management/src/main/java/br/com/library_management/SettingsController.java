package br.com.library_management;


import br.com.library_management.Model.AuthenticatedUser;
import br.com.library_management.Model.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;



public class SettingsController {


    @FXML
    private ScrollPane containerScrollPane;

    @FXML
    private Label labelName;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelPhone;   

    private MainController mainController; //Atributo para armazenar a instancia da Cena 

    private MainController menuController; //Atributo para armazenar a instancia da Cena 



    @FXML
    public void initialize() {
        showInformationEmployee();
        setMainController(mainController);
        setMenuController(menuController);
    }


    //Método responsável por Armazenar a instancia usada no momento
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setMenuController(MainController menuController) {
        this.menuController = menuController;
    }


    @FXML
    public void switchToDarkTheme() {
        if (mainController != null || menuController != null) {

            //Instanciando e atribuindo o Container do Main && menuContent
            VBox dynamicContent = mainController.getDynamicContent();
            VBox menuContent = menuController.getMenuContent();


            //Limpando e atribuindo a nova folha de Estilo

            menuContent.getStylesheets().clear();  //Menu começa com o whiteThme ATIVO, por isso preciso limpar as StyleSeeths e adicionar dnv.
            dynamicContent.getStylesheets().clear();
            containerScrollPane.getScene().getStylesheets().clear();


            //Adicionando thema 

            menuContent.getScene().getStylesheets().add(getClass().getResource("/br/com/library_management/style/Themas/darkTheme.css").toExternalForm());
            menuContent.getScene().getStylesheets().add(getClass().getResource("/br/com/library_management/style/Components/menu.css").toExternalForm());

            dynamicContent.getScene().getStylesheets().add(getClass().getResource("/br/com/library_management/style/Themas/darkTheme.css").toExternalForm());
            containerScrollPane.getScene().getStylesheets().add(getClass().getResource("/br/com/library_management/style/Themas/darkTheme.css").toExternalForm());
        } else {
            System.out.println("MainController or Menu is not set.");
        }
    }


    @FXML
    public void switchToWhiteTheme() {
        if (mainController != null || menuController != null) {

            //Instanciando e atribuindo o Container do Main && menuContent
            VBox dynamicContent = mainController.getDynamicContent();   
            VBox menuContent = menuController.getMenuContent();
           
            //Limpando e atribuindo a nova folha de Estilo

            menuContent.getStylesheets().clear();
            dynamicContent.getStylesheets().clear();
            containerScrollPane.getScene().getStylesheets().clear();


            //Adicionando thema 
            
            menuContent.getScene().getStylesheets().add(getClass().getResource("/br/com/library_management/style/Themas/clearTheme.css").toExternalForm());
            menuContent.getScene().getStylesheets().add(getClass().getResource("/br/com/library_management/style/Components/menu.css").toExternalForm());

            dynamicContent.getScene().getStylesheets().add(getClass().getResource("/br/com/library_management/style/Themas/clearTheme.css").toExternalForm());
            containerScrollPane.getScene().getStylesheets().add(getClass().getResource("/br/com/library_management/style/Themas/clearTheme.css").toExternalForm());
        } else {
            System.out.println("MainController or Menu is not set.");
        }
    }
    
    
    @FXML
    public void showInformationEmployee(){
        Employee authenticatedEmployee = AuthenticatedUser.getInstance().getAuthenticatedEmployee();

        //Atribuindo o valor extraido do Banco de dados na Label para exibição
        labelName.setText(authenticatedEmployee.getNomeEmployee());
        labelEmail.setText(authenticatedEmployee.getEmail());
        labelPhone.setText(authenticatedEmployee.getPhone());
    }    

}