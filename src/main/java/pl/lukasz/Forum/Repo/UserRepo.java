package pl.lukasz.Forum.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.lukasz.Forum.Model.User;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
