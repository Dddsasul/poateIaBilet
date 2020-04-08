package managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConManager
{
    public Connection createConnection()
    {
        try
        {
            String url = "jdbc:mysql://localhost/pao";
            String username = "root";
            String password = "";

            return DriverManager.getConnection(url, username, password);
        }
        catch (SQLException Reeee)
        {
            Reeee.printStackTrace();
        }
        return null;
    }

    public static DBConManager getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private final static class SingletonHolder
    {
        private static final DBConManager INSTANCE = new DBConManager();
    }
}
