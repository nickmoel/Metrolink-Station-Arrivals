package com.moeller.launchcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nick on 9/19/2017.
 */
@Component
public class Validation {

    @Autowired
    Stops metroStops;
    public Validation() {

    }

    public boolean isValid(int userInput) {//returns true if user input is within range
        return userInput >= 0 && userInput < 36;
    }

    String getNextStationArrival(int user_Input) {

        String stationName= metroStops.getStationName(user_Input);
        String nextArrival = metroStops.getNextArrival(user_Input);
        String nextStationArrival = " The next arrival at " + stationName + " is at " + nextArrival;
        return nextStationArrival;
        //return "Next arrival at " + metroStops.getStationName(user_Input) + " is at " + metroStops.getNextArrival(user_Input);
    }

    public String validate(int user_Input) {
        if (isValid(user_Input)) {
           String nextStation = getNextStationArrival(user_Input);
            return nextStation;

        } else {
            String invalid = ("Invalid input. Please make your METROLINK Station selection from 0-35.");
           // return("Invalid input. Please make your METROLINK Station selection from 0-35.");
return invalid;
        }

    }

    public void setMetroStops(Stops metroStops) {//for mock object
        this.metroStops = metroStops;
    }
}