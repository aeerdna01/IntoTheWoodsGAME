package PaooGame;

import java.sql.*;
/*! \class DataBase
    \brief Clasa care ne permite crearea obiectelor ce faciliteaza conectarea la o baza de date SQLite
           Metodele acesteia se rezuma doar la citit si scris din/in baza de date "settings.db".
 */
public class DataBase {
    Connection c;
    Statement stmt;
    ResultSet rs;

    public DataBase(){
        try {
            Class.forName("org.sqlite.JDBC"); //incarcam driverul
            c = DriverManager.getConnection("jdbc:sqlite:settings.db"); // facem conexiunea cu baza de date.
            stmt = c.createStatement();
        /*   String sql = "CREATE TABLE SAVEGAME " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    "HeroX INT      NOT NULL," +
                   "HeroY INT       NOT NULL," +
                    "HeroHealth INT      NOT NULL," +
                    "Level   INT         NOT NULL," +
                    "Score INT      NOT NULL)";
            String sql2 = "INSERT INTO SAVEGAME (ID,HeroX, HeroY, HeroHealth, Level, Score) " + "VALUES(1,288,340,3,1,0)";
            stmt.executeUpdate(sql2);
         */
            stmt.close();
            //c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        //System.out.println("Table created successfully");
    }


    /*! \fn public void updateMenuMusicVolume(int volume) throws  SQLException
        \brief Functie ce scrie in baza de date volumul muzicii din MenuState pe care-l doreste utilizatorul(Selectand din setari).
        \param volume este intregul care reprezinta procentajul la care utilizatorul doreste sa se auda muzica.
     */
    public void updateMenuMusicVolume(int volume) throws SQLException {
        String instruction = "UPDATE SETTINGS set MENU_MUSIC_VOLUME =" + volume + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
    }

    /*! \fn public void updateGameMusicVolume(int volume) throws  SQLException
        \brief Functie ce scrie in baza de date volumul muzicii din PlayState pe care-l doreste utilizatorul(Selectand din setari).
        \param volume este intregul care reprezinta procentajul la care utilizatorul doreste sa se auda muzica.
     */
    public void updateGameMusicVolume(int volume) throws SQLException {
        String instruction = "UPDATE SETTINGS set GAME_MUSIC_VOLUME =" + volume + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
    }


    /*! \fn public int getMenuVolume() throws SQLException
        \brief Functie de extragere a volumului din meniu din baza de date pentru a-l modifica in timp real.
     */
    public int getMenuVolume() throws SQLException {
        rs = stmt.executeQuery("SELECT * FROM SETTINGS;");
        return rs.getInt("MENU_MUSIC_VOLUME");
    }

    /*! \fn public int getGameVolume() throws SQLException
        \brief Functie de extragere a volumului din joc din baza de date pentru a-l modifica in timp real.
    */
    public int getGameVolume() throws SQLException {
        rs = stmt.executeQuery("SELECT * FROM SETTINGS WHERE ID=1;");
        return rs.getInt("GAME_MUSIC_VOLUME");
    }

    /*! \fn  public void updateAll(int heroX, int heroY, int heroHealth, int level, int score ) throws SQLException
        \brief Functie de salvare a parametrilor vitali din joc pentru a-i incarca la apasarea butonului "Load".
    */
    public void updateAll(int heroX, int heroY, int heroHealth, int level, int score ) throws SQLException
    {
        String instruction = "UPDATE SAVEGAME set HeroX =" + heroX + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
        instruction = "UPDATE SAVEGAME set HeroY =" + heroY + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
        instruction = "UPDATE SAVEGAME set HeroHealth =" + heroHealth + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
        instruction = "UPDATE SAVEGAME set Level =" + level + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
        instruction = "UPDATE SAVEGAME set Score =" + score + " WHERE ID=1;";
        stmt.executeUpdate(instruction);

    }

    public void updateDifficulty(int x) throws SQLException {
        String instruction = "UPDATE SETTINGS set DIFFICULTY =" + x + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
    }

    public int getDifficulty() throws SQLException {
        rs=stmt.executeQuery("SELECT * FROM SETTINGS;");
        return rs.getInt("DIFFICULTY");
    }

    public void updateEnemyKilled(int x) throws SQLException {
        String instruction = "UPDATE SAVEGAME set EnemyKilled =" + x + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
    }

    public int getEnemyKilled() throws SQLException {
        rs=stmt.executeQuery("SELECT * FROM SAVEGAME;");
        return rs.getInt("EnemyKilled");
    }

    public int getHeroX() throws SQLException {
        rs=stmt.executeQuery("SELECT * FROM SAVEGAME;");
        return rs.getInt("HeroX");
    }

    public int getHeroY() throws SQLException {
        rs=stmt.executeQuery("SELECT * FROM SAVEGAME;");
        return rs.getInt("HeroY");
    }

    public int getHeroHealth() throws SQLException {
        rs=stmt.executeQuery("SELECT * FROM SAVEGAME;");
        return rs.getInt("HeroHealth");
    }

    public int getScore() throws SQLException {
        rs=stmt.executeQuery("SELECT * FROM SAVEGAME;");
        return rs.getInt("Score");
    }

    public int getLevel() throws SQLException {
        rs=stmt.executeQuery("SELECT * FROM SAVEGAME;");
        return rs.getInt("Level");
    }


    public void updateHeroX(int heroX) throws SQLException {
        String instruction = "UPDATE SAVEGAME set HeroX =" + heroX + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
    }

    public void updateHeroY(int heroY) throws SQLException {
        String instruction = "UPDATE SAVEGAME set HeroY =" + heroY + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
    }

    public void updateHeroHealth(int heroHealth) throws SQLException {
        String instruction = "UPDATE SAVEGAME set HeroHealth =" + heroHealth + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
    }

    public void updateScore(int score) throws SQLException {
        String instruction = "UPDATE SAVEGAME set Score =" + score + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
    }

    public void updateLevel(int level) throws SQLException {
        String instruction = "UPDATE SAVEGAME set Level =" + level + " WHERE ID=1;";
        stmt.executeUpdate(instruction);
    }


}
