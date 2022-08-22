package org.DAO;

public class Vessel {
    private String type;
    //location data
    private int x;
    private int y;

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

    public Vessel(VesselType vesselType, int x, int y){
        this.x=x;
        this.y=y;
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

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
