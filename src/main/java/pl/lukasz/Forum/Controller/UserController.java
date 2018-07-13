package pl.lukasz.Forum.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lukasz.Forum.Model.User;
import pl.lukasz.Forum.Repo.UserRepo;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class UserController {

   @Autowired
    private UserRepo userRepository;


   @PostMapping("/user/add")
   public String register(@ModelAttribute @Valid User user, BindingResult result){
       if(result.hasErrors()){
           return "redirect:/register";
       }
        userRepository.save(user);
        return "redirect:/login";
   }


    @GetMapping("/user/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();

    }




}
