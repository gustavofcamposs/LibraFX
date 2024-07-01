package br.com.library_management.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.library_management.Conexao.DatabaseConnection;


public class Login {

        /**
     * Método para verificar o login do usuário.
     * @param username Nome de usuário fornecido.
     * @param senha Senha fornecida.
     * @return Retorna um objeto Employee se a autenticação for bem-sucedida, caso contrário, retorna null.
     */
    public Employee verificarLogin(String username, String senha) {

        // Obtém a conexão com o banco de dados.
        Connection conn = DatabaseConnection.getConnection();

        // Declara um objeto Employee que será retornado.
        Employee employee = null;

        // Verifica se a conexão foi estabelecida com sucesso.
        if (conn != null) {

            // Define a consulta SQL para verificar o login e a senha.
            String query = "SELECT * FROM Employee WHERE nm_login = ? AND nm_password = ?";

            try {

                // Prepara a declaração SQL.
                PreparedStatement stmt = conn.prepareStatement(query);

                // Define os parâmetros da consulta (os valores de username e senha).
                stmt.setObject(1, username);
                stmt.setObject(2, senha);

                // Executa a consulta e obtém o resultado.
                ResultSet rs = stmt.executeQuery();

                // Se um resultado for encontrado, cria um objeto Employee com os dados retornados.
                if (rs.next()) {
                    int id = rs.getInt("id_registration");
                    String nome = rs.getString("nm_employee");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    employee = new Employee(id, nome, email, phone);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // Finalmente, encerra a conexão com o banco de dados.
                    conn.close();

                    // Verifica se a conexão foi realmente encerrada e imprime o status.
                    boolean closed = conn.isClosed();

                    System.out.println("isClosed DB: " + closed);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Retorna o objeto Employee ou null se a autenticação falhar.
        return employee;
    }
}