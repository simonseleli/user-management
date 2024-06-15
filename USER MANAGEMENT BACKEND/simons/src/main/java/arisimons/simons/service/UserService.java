package arisimons.simons.service;

import arisimons.simons.Entity.User;
import arisimons.simons.Exceptions.EmailFoundException;
import arisimons.simons.Exceptions.NameFoundException;
import arisimons.simons.Exceptions.UserNameException;
import arisimons.simons.Exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    void saveUser(User user) throws EmailFoundException;

    List<User> displayAllUser(User user);

    User displaySingleUser(Long userId) throws UserNotFoundException;

    void UpdateUser(Long userId, User user) throws EmailFoundException, UserNameException, NameFoundException, UserNotFoundException;

    void deleteUser(Long userId) throws UserNotFoundException;
}
