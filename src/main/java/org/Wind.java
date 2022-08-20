package org;

public enum Wind {
    BREEZE("Breeze"),CALM("Calm"),STORM("Storm");
    private String value;
    Wind(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }

    public static Wind[] windForce = new Wind[]{
            BREEZE,CALM,STORM
    };
}
