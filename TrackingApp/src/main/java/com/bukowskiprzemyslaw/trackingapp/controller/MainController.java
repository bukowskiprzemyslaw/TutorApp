package com.bukowskiprzemyslaw.trackingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/tracking")
    public String tracking() {
        return "trackingindex";

    }
}
