package com.beanos.backend;

import com.beanos.backend.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("login", "user", new User());
    }

    @PostMapping(value = "/addUser")
    public @ResponseBody String addNewUser (@RequestParam String password
      , @RequestParam String email) {
    User beans = new User();
    beans.setEmail(email);
    beans.setPassword(password);
    userRepository.save(beans);
    return ("index");
    }
}
