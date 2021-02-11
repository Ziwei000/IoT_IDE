package com.group5.ide_vss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group5.ide_vss.utils.UtilPi;

@Controller
public class WholeController {

    @RequestMapping("hello")
    public String mainPage() {
    //	UtilPi.getTweetsFromPi();
        return "MobileComputingProject.html";
    }
}
