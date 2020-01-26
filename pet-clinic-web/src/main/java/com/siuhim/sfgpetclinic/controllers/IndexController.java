package com.siuhim.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/"})
    public String index() {
        return "index";
    }

    @RequestMapping("/vets.html")
    public String vetsRedirect() {
        return "redirect:/vets";
    }

    @RequestMapping("/oups")
    public String oupsHandler() {
        return "notimplemented";
    }
}
