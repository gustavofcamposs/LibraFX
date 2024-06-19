package br.com.library_management.Conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/LibraryDb";

    private static final String USER = "root";

    private static final String PASSWORD = "patinhosz27";

    private static Connection connection = null; //Armazenando a Conexão em uma var


    //Método Responsável pela Conexão do Banco de dados
    public static Connection getConnection() {
        try {
            connection =  DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    //Método Responsável por Encerrar a conexão do Banco de dados
    public static void closeConnection() {
        if (getConnection() != null) {
            try{

                //Encerrando conexão
                connection.close();

                //Verificando se foi Encerrado
                boolean isClosed = connection.isClosed();

                if (isClosed) {
                    System.out.println("Conexão encerrada com sucesso!" + isClosed); //TRUE Encerrado
                } else{
                    System.out.println("Falha ao encerrar conexão! " + isClosed); //FALSE não Encerrado
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
            
        } else {
            System.out.println("Conexão não foi inicializada!");
        }
    }
    
}