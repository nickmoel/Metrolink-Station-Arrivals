import com.moeller.launchcode.Stops;
import com.moeller.launchcode.Validation;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class StationTest {

    /*
************com.moeller.launchcode.Station List**************
0 5TH & MISSOURI METROLINK STATION
1 8TH AND PINE METROLINK STATION  2 BELLEVILLE METROLINK STATION  3 BRENTWOOD METROLINK STATION
4 CENTRAL WEST END METROLINK STATION  5 CIVIC CENTER METROLINK STATION  6 CLAYTON METROLINK STATION
7 COLLEGE METROLINK STATION  8 CONVENTION CENTER METROLINK STATION  9 DELMAR METROLINK STATION
10 EAST RIVERFRONT METROLINK STATION  11 EMERSON PARK METROLINK STATION  12 FAIRVIEW HEIGHTS METROLINK STATION
13 FOREST PARK METROLINK STATION  14 FORSYTH METROLINK STATION  15 GRAND METROLINK STATION
16 JJK CENTER METROLINK STATION  17 LACLEDES LANDING METROLINK STATION  18 LAMBERT EAST TRML METROLINK STATION
19 LAMBERT MAIN TRML METROLINK STATION  20 MAPLEWOOD METROLINK STATION  21 MEMORIAL HOSPITAL METROLINK STATION
22 NORTH HANLEY METROLINK STATION  23 RICHMOND HEIGHTS METROLINK STATION  24 ROCK ROAD METROLINK STATION
25 SHILOH-SCOTT METROLINK STATION  26 SHREWSBURY METROLINK STATION  27 SKINKER METROLINK STATION
28 STADIUM METROLINK STATION  29 SUNNEN METROLINK STATION  30 SWANSEA METROLINK STATION
31 UMSL NORTH METROLINK STATION  32 UMSL SOUTH METROLINK STATION  33 UNION STA METROLINK STATION
34 WASHINGTON PARK METROLINK STATION  35 WELLSTON METROLINK STATION
*/


    @Test
    public void stationZero5thAndMissouri() {
        int stationZero = 0;

        Stops stops = mock(Stops.class);
        when(stops.getStationName(stationZero)).thenReturn("5th and Missouri");
        when(stops.getNextArrival(stationZero)).thenReturn("8:30:00 AM");

        Validation validation = new Validation();
        validation.setMetroStops(stops);

        validation.validate(stationZero);


        verify(stops, times(1)).getStationName(stationZero);
        verify(stops, times(1)).getNextArrival(stationZero);
        verifyNoMoreInteractions(stops);
    }


    @Test
    public void stationTwentyFourRockRoadMetrolinkStation() {
        int stationTwentyFour = 24;

        Stops stops = mock(Stops.class);
        when(stops.getStationName(stationTwentyFour)).thenReturn("ROCK ROAD METROLINK STATION");
        when(stops.getNextArrival(stationTwentyFour)).thenReturn("11:42:00 AM");

        Validation validation = new Validation();
        validation.setMetroStops(stops);

        validation.validate(stationTwentyFour);


        verify(stops, times(1)).getStationName(stationTwentyFour);
        verify(stops, times(1)).getNextArrival(stationTwentyFour);
        verifyNoMoreInteractions(stops);
    }


    @Test
    public void stationThirtyFourWashingtonParkMetrolinkStation() {
        int stationThirtyFour = 34;

        Stops stops = mock(Stops.class);
        when(stops.getStationName(stationThirtyFour)).thenReturn("WASHINGTON PARK METROLINK STATION");
        when(stops.getNextArrival(stationThirtyFour)).thenReturn("12:02:00 PM");

        Validation validation = new Validation();
        validation.setMetroStops(stops);

        validation.validate(stationThirtyFour);


        verify(stops, times(1)).getStationName(stationThirtyFour);
        verify(stops, times(1)).getNextArrival(stationThirtyFour);
        verifyNoMoreInteractions(stops);
    }


    @Test
    public void isValid() {
        Validation validation = new Validation();

        assertThat(validation.isValid(-9999), is(false));
        assertThat(validation.isValid(-1), is(false));
        assertThat(validation.isValid(36), is(false));
        assertThat(validation.isValid(9999), is(false));

        assertThat(validation.isValid(0), is(true));
        assertThat(validation.isValid(1), is(true));
        assertThat(validation.isValid(20), is(true));
        assertThat(validation.isValid(35), is(true));
    }
}
