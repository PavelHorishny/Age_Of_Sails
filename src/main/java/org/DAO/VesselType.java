package org.DAO;

public enum VesselType {
    THREE_DECKER_SHIP_OF_LINE("Big battle ship",5,0,3,3,6,7),
    TWO_DECKER_SHIP_OF_LINE("Small battle ship",5,0,3,2,5,5),
    FRIGATE("Frigate",6,0,2,1,5,4),
    TENDER("Tender",6,1,2,1,1,2),
    BRIG("Brig",5,1,2,1,3,3),
    GALLEON("Galleon",4,0,3,2,3,3),
    STEAM_FRIGATE("Steam frigate",6,4,1,1,3,4),
    BATTERY("Naval battery",4,2,2,3,6,5),
    GALLEY("Galley",5,3,1,1,3,3),
    CORVETTE("Steam corvette",6,4,1,1,3,3),
    MONITOR("Monitor",3,2,3,1,3,3),
    STEAMSHIP("Steamship",5,2,2,1,3,3);
    private String type;
    private int breeze_move_points;
    private int calm_move_points;
    private int storm_move_points;
    private int shots;
    private int fire_range;
    private int hit_points;
    VesselType(String type, int breeze_move_points, int calm_move_points, int storm_move_points,
               int shots, int fire_range, int hit_points) {
        this.type = type;
        this.breeze_move_points = breeze_move_points;
        this.calm_move_points = calm_move_points;
        this.storm_move_points = storm_move_points;
        this.shots = shots;
        this.fire_range = fire_range;
        this.hit_points = hit_points;
    }

    public String getType(){
        return type;
    }

    public int getBreeze_move_points() {
        return breeze_move_points;
    }

    public int getCalm_move_points() {
        return calm_move_points;
    }

    public int getStorm_move_points() {
        return storm_move_points;
    }

    public int getShots() {
        return shots;
    }

    public int getFire_range() {
        return fire_range;
    }

    public int getHit_points() {
        return hit_points;
    }
}
