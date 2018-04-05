package com.moeller.launchcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Nick on 9/21/2017.
 */


@Component
public class Stops {

    @Autowired
    public List<Station> routeStops;

    @Autowired
    private SqliteJDBCDao arrival;
//     String arrivalTime;


    public void Stops() {

    }


        public List<String> outputStations() {//list stations
            List<String> stations = new ArrayList<String>();
            List<Station> routeStops = arrival.getStopsAllStops();
            for (int i = 0; i < routeStops.size(); i++) {
                int y = i;
               stations.add(y + " " + routeStops.get(i).getStationName() + "  ");

                }
            return stations;
        }


    public String getStationName(int user_Input) {// retrieve station name using user input from stored list
        List<Station> routeStops = arrival.getStopsAllStops();
String stationName = routeStops.get(user_Input).getStationName();
        //return routeStops.get(user_Input).getStationName();
return stationName;
    }

    public String getNextArrival(int user_input) {
        List<Station> routeStops = arrival.getStopsAllStops();
        Station station = routeStops.get(user_input);
        List<String> times = arrival.getArrivals(station);
        String arrivalTime = times.get(0);
String arrival_Time = convertTime(arrivalTime);
        return arrival_Time;
    }


    public String convertTime(String arrivalTime) {
        //input time pattern
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        //Date/time pattern of desired output date
        DateFormat outputformat = new SimpleDateFormat("hh:mm:ss aa");
        Date date;
        String output;
        try {
            //Conversion of input String to date
            date = df.parse(arrivalTime);
            //old date format to new date format
            output = outputformat.format(date);
            //convert output back to arrivalTime
            arrivalTime = output;

        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return arrivalTime;
    }

}
