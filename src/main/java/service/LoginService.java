package service;

import model.User;
import repositories.UserRepo;

import java.util.Optional;

public class LoginService
{
    private UserRepo userRepo;
    public LoginService()
    {
        userRepo = UserRepo.build(UserRepo.Type.DB);
    }

    public Optional<User> login(User user)
    {
        Optional<User> result = userRepo.findUserByUsername(user.getUsername());

        if (result.isPresent())
        {
            User u = result.get();
            if (u.getPassword().equals(user.getPassword()))
            {
                return Optional.of(u);
            }
        }

        return Optional.empty();
    }

    public boolean register(User user)
    {
        Optional<User> result = userRepo.findUserByUsername(user.getUsername());

        if (result.isEmpty())
        {
            userRepo.addUser(user);
            return true;
        }
        return false;
    }

    public void changePassword(int id, String newPassword)
    {
            userRepo.changePassword(id, newPassword);
    }
}
