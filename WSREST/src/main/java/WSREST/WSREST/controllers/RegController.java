package WSREST.WSREST.controllers;

import WSREST.WSREST.entities.Role;
import WSREST.WSREST.entities.User;
import WSREST.WSREST.repositories.UsersRepository;
import WSREST.WSREST.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/registration")
@PreAuthorize("hasRole('ADMIN')")
public class RegController {
    static long USER_ROLE = 3,
                GUEST_ROLE = 2,
                ADMIN_ROLE = 1;

    Set<Role> rolesSet = new HashSet<>();
    Set<User> usersSet = new HashSet<>();


    @Autowired
    UsersRepository users;
    @Autowired
    RolesRepository roles;


    @PostMapping
    public String addUser(@RequestParam String username, @RequestParam String password, @RequestParam String confirm_password)
    {
        //no empty fields allowed
        if (username.isEmpty() || password.isEmpty() || confirm_password.isEmpty())
            return null;
        //passwords should match
        if (!password.equals(confirm_password))
            return null;

        Role role = roles.findByRole("ADMIN");
        rolesSet.add(role);

        User user = new User(username, password, rolesSet);
        usersSet.add(user);

        role.setUsers(usersSet);

        users.saveAll(usersSet);

        return "login";
    }
}
