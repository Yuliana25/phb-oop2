package lab.phb.mhswebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // lupa disini
public class AppController {
    
    @RequestMapping("/index")
    public void home() {}
    
}
