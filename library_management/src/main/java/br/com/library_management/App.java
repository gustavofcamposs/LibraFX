package br.com.library_management;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import br.com.library_management.Conexao.DatabaseConnection;
import br.com.library_management.Util.WindowsManager;

import java.io.IOException;
    
public class App extends Application {

    private static Scene scene;


    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        scene = new Scene(loadFXML("/br/com/library_management/View/LoginScreen/loginScreen")/* 978, 708 */);/*Não preciso definir o tamnho */
        
        //Instanciando WindowsManager, class responsável por padronizar o tamanho das telas.
        WindowsManager windowsmanager = new WindowsManager();
        windowsmanager.applyStandardSize(stage); 

        

        stage.setScene(scene);

        //Realizando a conexão com o Banco de dados PRINCIPAL
        DatabaseConnection.getConnection();
        
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));  
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void main(String[] args) {
        launch();
    }
}   