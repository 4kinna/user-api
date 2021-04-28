package com.example.userapi;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*RestController annotation automatically serializes and return object into HTTPResponse*/
@RestController
public class UserController {

    //Array with all users
    public User[] users = {
            new User(1, "", "Ted Nilsson", "Green Adviser", "tednilsson@greenadviser.se", "0700000000"),
            new User(2, "", "Anton Stålhandske", "Green Adviser", "Antonstalhandske@greenadviser.se", "0700000000"),
            new User(3, "", "Victor Håkansson", "Green Adviser", "Victorhakansson@greenadviser.se", "0700000000"),
    };

    /* @GetMapping ensures that HTTP Get requests to /users that are mapped to the users() method*/
    @GetMapping("/users")
    public List<User> users() {
        return Arrays.asList(users.clone());
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") int id) {
        try {
            List<User> ourUsers = Arrays.asList(users);

            User user = ourUsers.stream().filter(u -> u.getId() == id).findAny().orElse(null);
            //return ourUsers.stream().filter(u -> u.getId()==id).findAny();
            return user;
        } catch (Exception e) {
            return null; //TODO vill skriva ut ett felmeddelande..
        }
    }

    /*Update a specific user*/
    @PutMapping("/update-users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") int id, @RequestBody User userDetails) {
        List<User> currentUsers = Arrays.asList(users);
        User user = currentUsers.stream().filter(u -> u.getId() == id).findAny().orElse(null);


        if (user == null) {
            return null;
        } else {
            if(currentUsers.remove(user)) {
                user.setId(userDetails.getId());
                user.setProfilePicture(userDetails.getProfilePicture());
                user.setName(userDetails.getName());
                user.setEmail(userDetails.getEmail());
                user.setPhone(userDetails.getPhone());

                currentUsers.add(user);
                return ResponseEntity.ok(user);
            } else {
                return null;
            }

        }


    }
}

