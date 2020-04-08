package repositories;

import managers.DBConManager;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DBUserRepo implements UserRepo
{
    @Override
    public void addUser(User user)
    {
        String sql = "insert into users values (null, ?, ?, 0)";

        try (
                Connection con = DBConManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
            )
        {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            statement.executeUpdate();
        }
        catch (SQLException Reeee)
        {
            Reeee.printStackTrace();
        }

    }

    @Override
    public Optional<User> findUserByUsername(String username)
    {
        String sql = "select * from users where username = ?";

        try (
                Connection con = DBConManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                )
        {
            statement.setString(1, username);

            ResultSet set = statement.executeQuery();

            if (set.next())
            {
                int id = set.getInt("id");
                String u = set.getString("username");
                String p = set.getString("password");
                Boolean isAdm = set.getBoolean("isAdmin");

                return Optional.of(new User(id, u, p, isAdm));
            }
        }
        catch (SQLException Reeee)
        {
            Reeee.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void changePassword(int id, String newPassword)
    {
        String sql = "update users set password = ? where (id = ?)";
        try (
                Connection con = DBConManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        )
        {
            statement.setString(1, newPassword);
            statement.setInt(2, id);

            statement.executeUpdate();
        }
        catch (SQLException Reeee)
        {
            Reeee.printStackTrace();
        }
    }
}
