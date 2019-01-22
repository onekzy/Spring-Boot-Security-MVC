package WSREST.WSREST.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = {"/registration"})
public class IndexController {

    @GetMapping
    public String regPage(Model model) {
        return "registration";
    }
}
