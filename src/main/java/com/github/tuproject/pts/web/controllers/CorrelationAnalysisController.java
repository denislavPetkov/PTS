package com.github.tuproject.pts.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/correlationAnalysis")
public class CorrelationAnalysisController extends BaseController{

    @GetMapping
    public ModelAndView mainPage(Model model){
        return super.view("correlationAnalysis");
    }

}
