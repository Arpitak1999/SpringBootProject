package com.webproject.webapplication.WebApplication.Login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
//ths file not required and login.jsp is not required
//    private AuthenticateService authenticateService ;
//
//    public WelcomeController(AuthenticateService authenticateService) {
//        this.authenticateService = authenticateService;
//    }

    @RequestMapping(value="/" , method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model){
        model.put("name", "arpita");
        return "welcome";
    }
//
//    private String getLoggedinUsername(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//    }
// video 67 and 68
//    @RequestMapping(value="login" , method = RequestMethod.POST)
//    public String goWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){
//
//        if(authenticateService.authenticate(name,password)) {
//            model.put("name", name);
//            model.put("password", password);
//            return "welcome";
//        }
//        model.put("errorMessage","Invalid login");
//        return "login";
//    }
}
