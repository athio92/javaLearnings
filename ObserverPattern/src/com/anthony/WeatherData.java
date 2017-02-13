package com.anthony;

import java.util.Observable;

/**
 * Created by eclipze on 2017/02/06.
 */
public class WeatherData extends Observable {
    private double temperature;
    private double pressure;
    private double humidity;


    public WeatherData() {
    }

    public void setMeasurements(double t, double h, double p){
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
        measurementsChanged();
    }

    public void measurementsChanged() {
        setChanged(); //indicate the state has changed before calling notifyObservers().
        notifyObservers();
    }


    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }


}
