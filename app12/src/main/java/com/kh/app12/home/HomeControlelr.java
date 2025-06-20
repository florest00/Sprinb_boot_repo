package com.kh.app12.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlelr {

    @GetMapping("/home")
    public void home() {}

}
