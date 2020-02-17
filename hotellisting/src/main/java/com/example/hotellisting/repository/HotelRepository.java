package com.example.hotellisting.repository;

import com.example.hotellisting.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Serializable> {

    public Hotel findByHotelId(Long id);

    public List<Hotel> findByNameContaining(String name);
}
