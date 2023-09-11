package ra.session7_session_cookie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("home")
@SessionAttributes("username")
public class SessionController {
    @ModelAttribute("username")
    private String setUser(){
        return "hunghx";
    }
    @GetMapping
    public String home(Model model){
        model.addAttribute("username","namtx");
        return "home";
    }
    @GetMapping("/views")
    public String views(@ModelAttribute("username") String username){
        System.out.println(username);
        return "view";
    }
}
