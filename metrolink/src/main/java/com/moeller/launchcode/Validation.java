package com.moeller.launchcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nick on 9/19/2017.
 */
@Component
public class Validation {//code left over from pre-gui

    @Autowired
    Stops metroStops;

    public Validation() {

    }

//    public boolean isValid(int userInput) {//returns true if user input is within range
//        return userInput >= 0 && userInput < 36;
//    }
//
//    String getNextStationArrival(int user_Input) {
//        return "The next arrival at " + metroStops.getStationName(user_Input) + " is at " + metroStops.getNextArrival(user_Input);
//    }
//
//    public String validate(int user_Input) {
//        if (isValid(user_Input)) {
//            return (getNextStationArrival(user_Input));
//        } else {
//
//            return("Invalid input. Please make your METROLINK Station selection from 0-35.");
//
//        }
//
//    }

//    public void setMetroStops(Stops metroStops) {//for mock object
//        this.metroStops = metroStops;
//    }
//}
}