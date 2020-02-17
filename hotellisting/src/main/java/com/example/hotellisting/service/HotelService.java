package com.example.hotellisting.service;

import com.example.hotellisting.codetype.RoomType;
import com.example.hotellisting.model.Hotel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface HotelService {

    public Hotel create(String name, String hostName, String neighbourhoodGroup, String neighbourhood, Double latitude, Double longitude, RoomType roomType, Long price);

    public Hotel save(Hotel hotel);

    public  void populateDumpData(MultipartFile file);

    public List<Hotel> getByName(String name);

    public List<Hotel> getAll();

    public void populateDataWithCSVFile(MultipartFile file);
}
