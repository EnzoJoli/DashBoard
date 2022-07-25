package com.beanos.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import java.util.Map;

import org.springframework.stereotype.Controller;



@CrossOrigin
@Controller
public class HomeController {
    Map<String, List<Services>> widget = new HashMap<String, List<Services>>();


    @GetMapping("/")
    public String home(@ModelAttribute Weather weather, Model model){

        List<Services> a = new ArrayList<Services>();

        widget.put("weather", a);
        widget.get("weather").add(weather);
        widget.get("weather").add(weather);
        System.out.println(widget.get("weather").get(0).getCity());
        //model.addAttribute("weather", weather);
        model.addAttribute("widget", widget);
        
    return ("index");
 }
}
