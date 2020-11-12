package com.booksell;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;

/**
 * @author Mu Tian Wang
 */

@Controller
public class MainController {
    @GetMapping("/accueil")
    public String accueil(){
        return ("accueil");
    }
}
