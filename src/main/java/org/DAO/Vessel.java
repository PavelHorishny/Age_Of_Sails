package org.DAO;

public class Vessel {
    private String type;
    //movement data
    private int breeze;
    private int calm;
    private int storm;
    //firing data
    private int shots;
    private int range;
    private int hitPoint;
    //abilities
    private boolean canFire;
    private boolean canMove;

    public Vessel(VesselType vesselType){
        type= vesselType.getType();
        breeze= vesselType.getBreeze_move_points();
        calm= vesselType.getCalm_move_points();
        storm= vesselType.getStorm_move_points();
        shots= vesselType.getShots();
        range= vesselType.getFire_range();
        hitPoint=vesselType.getHit_points();
        canFire=true;
        canMove=true;
    }

    public String getType() {
        return type;
    }

    public int getBreeze() {
        return breeze;
    }

    public int getCalm() {
        return calm;
    }

    public int getStorm() {
        return storm;
    }

    public int getShots() {
        return shots;
    }

    public int getRange() {
        return range;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public boolean isCanFire() {
        return canFire;
    }

    public boolean isCanMove() {
        return canMove;
    }
}
