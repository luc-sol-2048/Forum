package pl.lukasz.Forum.Repo;

import org.springframework.data.repository.CrudRepository;
import pl.lukasz.Forum.Model.User;

public interface UserRepo extends CrudRepository<User,Long> {

}
