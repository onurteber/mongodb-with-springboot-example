package com.spring.mongodb.springmongodb.config;

import com.spring.mongodb.springmongodb.model.Address;
import com.spring.mongodb.springmongodb.model.Hotel;
import com.spring.mongodb.springmongodb.model.Review;
import com.spring.mongodb.springmongodb.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void run(String... args) throws Exception {
        Hotel istanbul = new Hotel(
                "İstanbul",
                130,
                new Address("İstanbul","Turkey"),
                Arrays.asList(
                        new Review("Onur",9,true),
                        new Review("Uğur",7,false)
                )
        );
        Hotel antalya = new Hotel(
                "Antalya",
                130,
                new Address("Antalya","Turkey"),
                Arrays.asList(
                        new Review("Onur",8,true),
                        new Review("Uğur",8,true)
                )
        );
        this.hotelRepository.deleteAll();

        List<Hotel> hotels = Arrays.asList(istanbul,antalya);
        this.hotelRepository.saveAll(hotels);
    }
}
