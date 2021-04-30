package com.example.userapi.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
    public void deleteUser(@PathVariable(value="userid") Integer userid){

        repository.deleteById(userid);
    }


    /*Update a specific user*/
    /*TODO does not work in insomnia*/
/*    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") long id, @RequestBody User userDetails) {
        User user = this.users.stream().filter(u -> u.getId() == id).findAny().orElse(null);

        //https://stackoverflow.com/questions/8520808/how-to-remove-specific-object-from-arraylist-in-java

        if (user == null) {
            return null;
        } else {
            User u = new User(user.getId(), userDetails.getProfilePicture(),userDetails.getName(),userDetails.getCompany(), userDetails.getEmail(), userDetails.getPhone());

            this.users.remove(user);
            this.users.add(u);
            return ResponseEntity.ok(u);

        }


    }*/
}

