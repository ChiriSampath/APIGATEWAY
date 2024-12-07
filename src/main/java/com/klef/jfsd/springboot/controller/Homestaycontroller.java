package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.klef.jfsd.springboot.model.Homestay;
import com.klef.jfsd.springboot.service.HomestayService;

@Controller
@RequestMapping("/homestays")
public class Homestaycontroller {

    @Autowired
    private HomestayService homestayService;

    @GetMapping
    public String listHomestays(Model model) {
        model.addAttribute("homestays", homestayService.getAllHomestays());
        return "homestay-list"; // JSP view name
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("homestay", new Homestay());
        return "add-homestay";
    }

    @PostMapping("/add")
    public String addHomestay(@ModelAttribute Homestay homestay) {
        homestayService.addHomestay(homestay);
        return "redirect:/homestays";
    }

    // Additional CRUD endpoints for edit and delete
}
