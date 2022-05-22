package PaooGame;

import java.sql.*;

public class DataBase {
    Connection c;
    Statement stmt;
    ResultSet rs;

    public DataBase() {
        try {
            Class.forName("org.sqlite.JDBC"); //incarcam driverul
            c = DriverManager.getConnection("jdbc:sqlite:Database.db"); // facem conexiunea cu baza de date.
            stmt = c.createStatement();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void updateAll(int playerX, int playerY, int playerLife, int score, int level ) throws SQLException
    {
        String instruction = "UPDATE SaveGame set PlayerX =" + playerX + " WHERE Nr=1;";
        stmt.executeUpdate(instruction);
        instruction = "UPDATE SaveGame set PlayerY =" + playerY + " WHERE Nr=1;";
        stmt.executeUpdate(instruction);
        instruction = "UPDATE SaveGame set PlayerLife =" + playerLife + " WHERE Nr=1;";
        stmt.executeUpdate(instruction);
        instruction = "UPDATE SaveGame set Score =" + score + " WHERE Nr=1;";
        stmt.executeUpdate(instruction);
        instruction = "UPDATE SaveGame set Level =" + level + " WHERE Nr=1;";
        stmt.executeUpdate(instruction);

    }
}
