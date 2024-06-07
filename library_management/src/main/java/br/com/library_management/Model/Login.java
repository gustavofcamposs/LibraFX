package br.com.library_management.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.library_management.Conexao.DatabaseConnection;

public class Login {

    public boolean verificarLogin(String username, String senha) {

        Connection conn = DatabaseConnection.getConnection();

        if (conn != null) {

            String query = "SELECT * FROM Employee WHERE username = ? AND userpassword = ?";

            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                //ParâmetroIndex posição d "?" 
                stmt.setObject(1, username);
                stmt.setObject(2, senha);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();//Finalmente  encerrar a Conexão com o Banco de Dados

                    //Verificando se foi realmente encerrado
                    boolean closed = conn.isClosed();
                    System.out.println("isClosed DB: " + closed);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

}