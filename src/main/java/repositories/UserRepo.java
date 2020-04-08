package repositories;

import model.User;

import java.util.Optional;

public interface UserRepo
{
    void addUser(User user);
    Optional<User> findUserByUsername(String username);
    void changePassword(int id, String newPassword);

    static UserRepo build(Type type)
    {
        switch (type)
        {
            case DB: return new DBUserRepo();
            case FILE: return new FileUserRepo();
        }

        throw new RuntimeException("No such type");
    }

    enum Type
    {
        DB, FILE
    }
}
