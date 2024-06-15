package arisimons.simons.controller;

import arisimons.simons.Entity.User;
import arisimons.simons.Exceptions.EmailFoundException;
import arisimons.simons.Exceptions.NameFoundException;
import arisimons.simons.Exceptions.UserNameException;
import arisimons.simons.Exceptions.UserNotFoundException;
import arisimons.simons.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/") // for connecting to the React App
@AllArgsConstructor
public class userController {
    @Autowired
    private final UserService userService;

    @PostMapping(path = "/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) throws EmailFoundException {
        userService.saveUser(user);
        return ResponseEntity.ok("Saved!");
    }
    @GetMapping(path = "/displayAllUsers")
    public List<User> displayAllUser(User user){
        return userService.displayAllUser(user);
    }
    @GetMapping(path = "/displaySingleUser/{id}")
    public User displaySingleUser(@PathVariable("id")Long userId) throws UserNotFoundException {
        return userService.displaySingleUser(userId);
    }
    @PutMapping(path = "/updateUser/{id}")
    public ResponseEntity<String> UpdateUser(@RequestBody User user, @PathVariable("id") Long userId) throws UserNameException, NameFoundException, UserNotFoundException, EmailFoundException {
        userService.UpdateUser(userId,user);
        return ResponseEntity.ok("Updated!");
    }
    @DeleteMapping(path = "/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) throws UserNotFoundException {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Deleted!");
    }
}
