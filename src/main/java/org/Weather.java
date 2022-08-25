package org;

import java.util.Random;

public class Weather {
    private Wind [] windForce = Wind.windForce;
    private CardinalPoint [] cardinalPoints = CardinalPoint.cardinalPoints;

    private Random random;
    private String force;
    private String direction;



    public Weather (){
        random = new Random();
        force = windForce[random.nextInt(windForce.length)].getValue();
        direction = cardinalPoints[random.nextInt(cardinalPoints.length)].getValue();
    }

    public Weather (String wind, String direction){
        force = Wind.BREEZE.getValue();
        this.direction = CardinalPoint.EAST.getValue();
    }
    public String getForce(){
        return force;
    }
    public String getDirection(){
        return direction;
    }
    public void setForce(String force) {
        this.force = force;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
