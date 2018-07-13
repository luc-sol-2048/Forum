package pl.lukasz.Forum.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.lukasz.Forum.Model.Article;

import java.util.List;


public interface ArticleRepo extends CrudRepository<Article,Integer> {
}
