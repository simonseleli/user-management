package arisimons.simons.repository;

import arisimons.simons.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByUserId(Long userId);
    User findUserByEmail(String email);
    User findUserByName(String name);
    User findUserByUserName(String userName);

}
