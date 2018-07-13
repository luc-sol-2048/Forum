package pl.lukasz.Forum.Controller;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lukasz.Forum.Model.Article;
import pl.lukasz.Forum.Model.User;
import pl.lukasz.Forum.Repo.ArticleRepo;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller

public class HomeControler {
    @Autowired
    private ArticleRepo articleRepo;
    @GetMapping("/")
    public String all(Model model) {
        List<Article> list = new ArrayList<Article>();
        for (Article a:articleRepo.findAll()
             ) {list.add(a);

        }
        list.sort((o1,o2) -> o2.getDate().compareTo(o1.getDate()));

        model.addAttribute("article",new Article());
        model.addAttribute("articles",list);

        return "index";
    }

    @PostMapping("/article/add")
    public String addArticle(@ModelAttribute @Valid Article article, BindingResult result){
        Date date;
        LocalDate localDate = LocalDate.now();
        date = Date.valueOf(localDate);

        article.setDate(date);
        if(result.hasErrors()){
            return "redirect:/";
        }
        articleRepo.save(article);
        return "redirect:/";
    }
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("newUser", new User());
        return "Register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }


}
