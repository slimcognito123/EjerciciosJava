package Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/STA.do")
public class sendToAddController {

    @RequestMapping(method = RequestMethod.POST)
    public String sendToAdd(HttpSession session){
        if (session!=null){
            return "paginaAnadir";
        }else{
            return "index";
        }
    }
}
