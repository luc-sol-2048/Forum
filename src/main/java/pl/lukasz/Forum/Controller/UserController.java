package pl.lukasz.Forum.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lukasz.Forum.Model.User;
import pl.lukasz.Forum.Repo.UserRepo;

import javax.validation.Valid;

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

    @PostMapping("/login")
    public  String login(@ModelAttribute User user){
        String email = user.getEmail();
        User db =userRepository.findByEmail(email);
        if(user==null){
           System.out.println("użytkownik to null!!!");
           return "redirect:/login?error=true";
       }
       if(user.getPassword().equals(db.getPassword())){
           return "redirect:/";
       }
        else{
            return "redirect:/login";
        }
    }




}
