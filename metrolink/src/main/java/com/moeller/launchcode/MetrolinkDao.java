package com.moeller.launchcode;

import java.util.List;

/**
 * Created by Nick on 9/8/2017.
 */
public interface MetrolinkDao {
    List<Station> getStopsAllStops();

    List<String> getArrivals(Station station);




}