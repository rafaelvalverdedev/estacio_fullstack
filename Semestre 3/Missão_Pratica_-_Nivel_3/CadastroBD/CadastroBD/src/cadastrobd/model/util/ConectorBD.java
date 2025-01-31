package cadastrobd.model.util;

import java.sql.*;

public class ConectorBD {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=loja;encrypt=true;trustServerCertificate=true";
    private static final String USUARIO = "loja";
    private static final String SENHA = "loja";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static PreparedStatement getPrepared(Connection conn, String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public static ResultSet getSelect(PreparedStatement stmt) throws SQLException {
        return stmt.executeQuery();
    }

    public static void close(Connection conn) throws SQLException {
        if (conn != null) conn.close();
    }

    public static void close(PreparedStatement stmt) throws SQLException {
        if (stmt != null) stmt.close();
    }

    public static void close(ResultSet rs) throws SQLException {
        if (rs != null) rs.close();
    }
}
