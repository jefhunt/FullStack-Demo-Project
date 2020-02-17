package com.example.hotellisting.websecurity;

import com.example.hotellisting.model.Hotel;
import com.example.hotellisting.repository.HotelRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("hotel")
@CrossOrigin(origins = "http://localhost:3000")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    Collection<Hotel> hotels(){
        return (Collection<Hotel>) hotelRepository.findAll();
    }


}
