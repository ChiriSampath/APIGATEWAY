package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.dao.HomestayDAO;
import com.klef.jfsd.springboot.model.Homestay;

@Service
public class HomestayService {
    private HomestayDAO homestayDAO = new HomestayDAO();

    public List<Homestay> getAllHomestays() {
        return homestayDAO.getAllHomestays();
    }

    public void addHomestay(Homestay homestay) {
        homestayDAO.addHomestay(homestay);
    }

    // Additional CRUD methods
}
