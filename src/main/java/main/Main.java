package main;

import model.User;
import service.LoginService;

import java.util.Optional;

public class Main
{
    public static void main(String[] args)
    {
        String endl = "\n";

        LoginService service = new LoginService();

        User u1 = new User(69, "Grog", "paasta");

        boolean ree = service.register(u1);
        Optional<User> reee = service.login(u1);
        boolean reeee = false;
        if (reee.isPresent())
        {
            service.changePassword(reee.get().getId(), "about6");
            reeee = true;
        }

        System.out.println(ree + endl + reee.toString() + endl + reeee);
    }
}
