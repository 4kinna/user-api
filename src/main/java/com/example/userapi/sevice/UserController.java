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
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users")
    public List<Users> all() {
        return repository.findAll();
    }

    /*Get specific user depending on id */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users/{userid}")
    public Users getUserById(@PathVariable(value = "userid") Integer userid) {
        return repository.findById(userid).orElse(null);
    }

    /*Remove specific user*/
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/users/{userid}")
    public void deleteUser(@PathVariable(value = "userid") Integer userid) {

        repository.deleteById(userid);
    }


    /*Update a specific user depending on ID*/
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/users/{userid}")
    public void updateUser(@PathVariable(value = "userid") Integer userid, @RequestBody Users userDetails) {
        System.out.println(userid);
        repository.findById(userid).map(user -> {
            user.setProfilePicture(userDetails.getProfilePicture());
            user.setName(userDetails.getName());
            user.setCompany(userDetails.getCompany());
            user.setEmail(userDetails.getEmail());
            user.setPhone(userDetails.getPhone());
            return repository.save(user);
        });
    }


    /*Add new user*/
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/users")
    public Users newUser(@RequestBody Users newUser) {
        return repository.save(newUser);
    }

}

