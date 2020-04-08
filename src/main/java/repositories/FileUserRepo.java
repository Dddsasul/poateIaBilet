package repositories;

import model.User;

import java.util.Optional;

public class FileUserRepo implements UserRepo
{
    @Override
    public void addUser(User user)
    {

    }

    @Override
    public Optional<User> findUserByUsername(String user)
    {
        return Optional.empty();
    }

    @Override
    public void changePassword(int id, String newPassword)
    {

    }
}
