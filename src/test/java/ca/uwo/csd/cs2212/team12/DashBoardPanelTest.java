package ca.uwo.csd.cs2212.team12;
import java.util.Date;

import static org.junit.Assert.*;

public class DashBoardPanelTest {

    private DashBoardPanel pan;

    @org.junit.Before
    public void setUp() throws Exception {
        pan = new DashBoardPanel();
    }

    @org.junit.Test
    public void testSubtractDay() throws Exception {
        Date day = new Date(172800000); // the number of milliseconds in two days
        day = pan.subtractDay(day);
        assertEquals(day,new Date(86400000)); // the number of milliseconds in one day
    }

    @org.junit.Test
    public void testAddDay() throws Exception {
        Date day = new Date(86400000);
        day = pan.addDay(day);
        assertEquals(day,new Date(172800000));
    }

}