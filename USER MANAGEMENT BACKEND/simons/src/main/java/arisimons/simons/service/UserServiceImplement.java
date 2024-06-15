package arisimons.simons.service;

import arisimons.simons.Entity.User;
import arisimons.simons.Exceptions.EmailFoundException;
import arisimons.simons.Exceptions.NameFoundException;
import arisimons.simons.Exceptions.UserNameException;
import arisimons.simons.Exceptions.UserNotFoundException;
import arisimons.simons.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServiceImplement implements UserService{
    @Autowired
    private final UserRepository userRepository;

    @Override
    public void saveUser(User user) throws EmailFoundException {
        User emailChecker=userRepository.findUserByEmail(user.getEmail());
        if (emailChecker!=null){
            throw new EmailFoundException("email already exists, try another email");
        }
        userRepository.save(user);
    }

    @Override
    public List<User> displayAllUser(User user) {
        return userRepository.findAll();
    }

    @Override
    public User displaySingleUser(Long userId) throws UserNotFoundException {
        User findUserId=userRepository.findUserByUserId(userId);
        if (findUserId!=null){
            return userRepository.findUserByUserId(userId);
        }
        throw new UserNotFoundException("Could not find the user with id "+userId);
    }

    @Override
    public void UpdateUser(Long userId, User user) throws EmailFoundException, UserNameException, NameFoundException, UserNotFoundException {
        User userCheckerId=userRepository.findUserByUserId(userId);
        if (userCheckerId==null){
            throw new UserNotFoundException("Could not find the user with id "+userId);
        }else{
            if (Objects.nonNull(user.getUserName())
            && !"".equalsIgnoreCase(user.getUserName())){
                User userCheckerUserName=userRepository.findUserByUserName(user.getUserName());
                if (userCheckerUserName!=null){
                    throw new UserNameException("Username already exists, try another Username");
                }
                userCheckerId.setUserName(user.getUserName());
            }
            if (Objects.nonNull(user.getName())&&!"".equalsIgnoreCase(user.getName())){
                User userCheckerName=userRepository.findUserByName(user.getName());
                if (userCheckerName!=null){
                    throw new NameFoundException("Name already exists, try another Name");
                }
                userCheckerId.setName(user.getName());
            }
            if (Objects.nonNull(user.getEmail())&&!"".equalsIgnoreCase(user.getEmail())){
                User userEmailChecker=userRepository.findUserByEmail(user.getEmail());
                if (userEmailChecker!=null){
                    throw new EmailFoundException("Email taken");
                }
                userCheckerId.setEmail(user.getEmail());
            }
        }
        userRepository.save(userCheckerId);
    }

    @Override
    public void deleteUser(Long userId) throws UserNotFoundException {
        User userCheckerId=userRepository.findUserByUserId(userId);
        if (userCheckerId==null){
            throw new UserNotFoundException("Could not find the user with id "+userId);
        }
        userRepository.deleteById(userId);
    }
}
