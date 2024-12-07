package com.klef.jfsd.springboot.service;

package com.klef.jfsd.springboot.touristhomestayapp.service;

import com.klef.jfsd.springboot.controller.TourismPlaceController;
import com.klef.jfsd.springboot.touristhomestayapp.dao.TourismPlaceDAO;
import com.klef.jfsd.springboot.touristhomestayapp.model.TourismPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourismPlaceService {

    @Autowired
    private TourismPlaceDAO tourismPlaceDAO;

    // Retrieve all tourism places
    public List<TourismPlace> getAllTourismPlaces() {
        return TourismPlaceController.findAll();
    }

    // Retrieve a specific tourism place by ID
    public TourismPlace getTourismPlaceById(Long id) {
        return tourismPlaceDAO.findById(id);
    }

    // Add a new tourism place
    public void addTourismPlace(TourismPlace tourismPlace) {
        tourismPlaceDAO.save(tourismPlace);
    }

    // Update an existing tourism place
    public void updateTourismPlace(TourismPlace tourismPlace) {
        tourismPlaceDAO.update(tourismPlace);
    }

    // Delete a tourism place by ID
    public void deleteTourismPlace(Long id) {
        tourismPlaceDAO.delete(id);
    }
}
