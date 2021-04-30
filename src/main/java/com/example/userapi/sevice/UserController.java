package com.example.userapi.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/*RestController annotation automatically serializes and return object into HTTPResponse*/
@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    /* @GetMapping ensures that HTTP Get requests to /users that are mapped to the users() method*/
    /*Get entire list of user*/
    @GetMapping("/users")
    public List<Users> all() {
        return repository.findAll();
    }

    /*Get specific user depending on id */
    @GetMapping("/users/{userid}")
    public Users getUserById(@PathVariable(value = "userid") Integer userid) {
        return repository.findById(userid).orElse(null);
    }

    /*Remove specific user*/
    @DeleteMapping("/users/{userid}")
    public void deleteUser(@PathVariable(value = "userid") Integer userid) {

        repository.deleteById(userid);
    }


    /*Update a specific user depending on ID*/
    @PutMapping("/users/{userid}")
    public Optional<Users> updateUser(@PathVariable(value = "userid") Integer userid, @RequestBody Users userDetails) {
        return repository.findById(userid).map(user -> {
            user.setProfilePicture(userDetails.getProfilePicture());
            user.setName(userDetails.getName());
            user.setCompany(userDetails.getCompany());
            user.setEmail(userDetails.getEmail());
            user.setPhone(userDetails.getPhone());
            return repository.save(user);
        });
    }

    /*Add new user*/
    @PostMapping("/users")
    public Users newUser(@RequestBody Users newUser) {
/*
        Users user = new Users(newUser.getProfilePicture(),newUser.getName(), newUser.getCompany(), newUser.getEmail(), newUser.getPhone());
*/

        return repository.save(newUser);

    }

}

