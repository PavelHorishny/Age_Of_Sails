package org;

import org.DAO.Vessel;
import org.DAO.VesselType;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fleet {
    static Vessel vessel1 = new Vessel(VesselType.BRIG,0,0);
    static Vessel vessel2 = new Vessel(VesselType.THREE_DECKER_SHIP_OF_LINE, 0, 50);
    static Vessel vessel3 = new Vessel(VesselType.CORVETTE, 0, 100);
    static Rectangle r1 = new Rectangle(vessel1.getX(), vessel1.getY(), 25,25);
    static Rectangle r2 = new Rectangle(vessel2.getX(), vessel2.getY(), 25,25);
    static Rectangle r3 = new Rectangle(vessel3.getX(), vessel3.getY(), 25,25);
    static Map <Vessel,Rectangle> fleet = new HashMap<>();
    static List <Vessel> fleet1 = new ArrayList<>();
    public static Map< Vessel, Rectangle> getFleet(){
        fleet.put(vessel1,r1);
        fleet.put(vessel2,r2);
        fleet.put(vessel3,r3);
        return fleet;
    }

    public static List <Vessel> getFleet1 (){
        fleet1.add(vessel1);
        fleet1.add(vessel2);
        fleet1.add(vessel3);
        return fleet1;
    }

}
