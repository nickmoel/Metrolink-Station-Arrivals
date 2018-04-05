package com.moeller.launchcode;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Nick on 9/14/2017.
 */

//Data Transfer Object (DTO) class is a java-bean like artifact that holds the data that you want to share
@Component
@Entity
@Table(name = "stops")
public class Station {//this class corresponds to the database table stops
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stop_id", unique = true, nullable = false)
    public Integer id;

    @Column(name = "stop_name", unique = true, nullable = false)
    public String Name;

    public Station() {
    }


    String getStationName() {
        return Name;
    }

    Integer getId() {
        return id;
    }


}