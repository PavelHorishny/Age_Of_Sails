package org;

public enum CardinalPoint {
    NORTH("N"), SOUTH("S"), WEST("W"), EAST("E"), NORTH_WEST("NW"), NORTH_EAST("NE"),SOUTH_WEST("SW"), SOUTH_EAST("SE");
    private String value;
    CardinalPoint(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
    public static CardinalPoint[] cardinalPoints = new CardinalPoint[]{
            NORTH,SOUTH,WEST,EAST,NORTH_WEST,NORTH_EAST,SOUTH_WEST,SOUTH_EAST
    };
}
