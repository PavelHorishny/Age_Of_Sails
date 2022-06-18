package org.game;

import org.DAO.Vessel;
import org.DAO.VesselType;

public class Main {
    public static void main(String[] args) {

        Vessel vessel = new Vessel(VesselType.FRIGATE);
        System.out.println(vessel.isCanFire());
        System.out.println(vessel.getHitPoint());
    }
}