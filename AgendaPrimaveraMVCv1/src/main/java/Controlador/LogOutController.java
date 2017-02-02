package Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout.do")
public class LogOutController {

    @RequestMapping(method = RequestMethod.GET)
    public String destroySession(HttpSession session){
        if(session!=null) session.invalidate();
        return "index";
    }
}
