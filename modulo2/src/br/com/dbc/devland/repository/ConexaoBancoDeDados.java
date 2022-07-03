package br.com.dbc.devland.repository;

import br.com.dbc.devland.model.ConsoleColors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {

    public static Connection getConnection(){
        Connection connection = null;
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "DEVLAND";
        String password = "oracle";
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(dbUrl,username,password);
            System.out.println(ConsoleColors.GREEN_UNDERLINED + "\nLoading........\n" + ConsoleColors.RESET);
        }catch (ClassNotFoundException ex){
            System.err.println("Erro" + ex.getMessage());
        }catch (SQLException ex){
            System.err.println("Erro no Servidor" + ex.getMessage());
        }
        return connection;
    }
}
