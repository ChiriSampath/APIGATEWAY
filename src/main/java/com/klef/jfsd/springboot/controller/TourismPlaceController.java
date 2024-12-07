package com.klef.jfsd.springboot.controller;



import com.klef.jfsd.springboot.touristhomestayapp.model.TourismPlace;
import com.klef.jfsd.springboot.touristhomestayapp.service.TourismPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tourism-places")
public class TourismPlaceController {

    @Autowired
    private TourismPlaceService tourismPlaceService;

    // List all tourism places
    @GetMapping
    public String listTourismPlaces(Model model) {
        List<TourismPlace> tourismPlaces = tourismPlaceService.getAllTourismPlaces();
        model.addAttribute("tourismPlaces", tourismPlaces);
        return "tourism-place-list"; // JSP page for listing tourism places
    }

    // Show form for adding a new tourism place
    @GetMapping("/add")
    public String showAddTourismPlaceForm(Model model) {
        model.addAttribute("tourismPlace", new TourismPlace());
        return "add-tourism-place"; // JSP page for adding a new tourism place
    }

    // Process form for adding a new tourism place
    @PostMapping("/add")
    public String addTourismPlace(@ModelAttribute TourismPlace tourismPlace) {
        tourismPlaceService.addTourismPlace(tourismPlace);
        return "redirect:/tourism-places";
    }

    // Show form for editing a tourism place
    @GetMapping("/edit/{id}")
    public String showEditTourismPlaceForm(@PathVariable("id") Long id, Model model) {
        TourismPlace tourismPlace = tourismPlaceService.getTourismPlaceById(id);
        model.addAttribute("tourismPlace", tourismPlace);
        return "edit-tourism-place"; // JSP page for editing a tourism place
    }

    // Process form for updating a tourism place
    @PostMapping("/edit/{id}")
    public String editTourismPlace(@PathVariable("id") Long id, @ModelAttribute TourismPlace tourismPlace) {
        tourismPlace.setId(id);
        tourismPlaceService.updateTourismPlace(tourismPlace);
        return "redirect:/tourism-places";
    }

    // Delete a tourism place
    @GetMapping("/delete/{id}")
    public String deleteTourismPlace(@PathVariable("id") Long id) {
        tourismPlaceService.deleteTourismPlace(id);
        return "redirect:/tourism-places";
    }
}
