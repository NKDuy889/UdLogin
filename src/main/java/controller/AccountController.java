package controller;

import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.account.AccountService;
import service.account.IAccountService;

@Controller
@RequestMapping("/logins")
public class AccountController {

    private IAccountService userService = new AccountService();
    @GetMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home", "login", new Login());
        return modelAndView;
    }
    @PostMapping("")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        User user = userService.checkLogin(login);
        if (user == null) {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("view");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
