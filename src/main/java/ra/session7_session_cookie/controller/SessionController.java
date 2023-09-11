package ra.session7_session_cookie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/home")

public class SessionController {
    @GetMapping
    public String home(HttpSession session, HttpServletResponse response){
        Cookie cookie = new Cookie("username","hunghx123");
        cookie.setMaxAge(24*60*60); // tính theo s
        response.addCookie(cookie);
//        session.setAttribute("username","namtx");
        return "home";
    }

    @GetMapping("/set")
    public String set(){

        return "hello";
    }
    @GetMapping("/views")
    public String views(@CookieValue("username") String username){
        System.out.println(username);
        return "view";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies
        ) {
            if (c.getName().equals("username")) {
                c.setMaxAge(0);
                c.setValue("hung");
                response.addCookie(c);
            }
        }
        return "home";
    }
}
