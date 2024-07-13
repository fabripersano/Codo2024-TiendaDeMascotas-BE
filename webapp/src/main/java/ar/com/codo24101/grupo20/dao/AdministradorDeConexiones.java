package ar.com.codo24101.grupo20.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {

    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/tiendamascotas?serverTimeZone=UTC&userSSL=false";
        String user = "root";
        String password = "@admin12345!!"; // System.getenv("Nombre variable");    
        String driver = "com.mysql.cj.jdbc.Driver";

        Connection conn = null;
        try {
            Class.forName(driver); // carga el driver de la jvm
            conn = DriverManager.getConnection(url, user, password); 
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }
        return conn;
    }

    public static void desconectar(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }
    }

}
