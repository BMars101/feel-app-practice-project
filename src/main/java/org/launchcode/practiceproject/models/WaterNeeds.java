package org.launchcode.practiceproject.models;

public class WaterNeeds {

    private double weight;
    private double dailyActivityTime;
    private boolean isSick;

    public WaterNeeds(double weight, double dailyActivityTime) {
        this.weight = weight;
        this.dailyActivityTime = dailyActivityTime;

    }

    public WaterNeeds() {

    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDailyActivityTime() {
        return dailyActivityTime;
    }

    public void setDailyActivityTime(double dailyActivityTime) {
        this.dailyActivityTime = dailyActivityTime;
    }

    public boolean getIsSick() {
        return isSick;
    }

    public void setSick(boolean isSick) {
        this.isSick = isSick;
    }


    public String getWaterNeeds(){
        double waterNeeds = this.weight * .5;
        if(isSick){
            return "Your recommonded daily water intake is " + waterNeeds + "oz. Sorry you're sick! Make sure you drink at least the minimum of your recommended daily intake of water.";
        }
        double waterNeedsWithExercise = ((this.dailyActivityTime/30)*12) + waterNeeds;
        return "Your recommended daily water intake is " + waterNeedsWithExercise + "oz";

    }

}
