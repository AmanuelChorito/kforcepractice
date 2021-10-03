package com.example.kforcepractice;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class FleetService {


// Customers are waiting for their product to arrive to them –
// design an end point given that the truck driver takes 12 hours each day
// and how would you calculate that time to give the customer
// an estimation of when the product will be delivered.
// It was a two way convo – what kind of end point I should develop,
// what the restful api should look like ect and what the response will be.
// Designing an API that provides travel time for products.
    public FleetDTO travelTime(int driversNumber,double distance,double averageSpeed,int workingHours){

        double timeNeeded= distance/averageSpeed;
        int workingHour=Math.min(driversNumber*workingHours,24);
        int restHour= (workingHour==24)?0:24-workingHour;
        int travelTime=calcTime(timeNeeded,workingHour,restHour);
        return new FleetDTO(driversNumber,distance,averageSpeed,workingHours,travelTime);

    }
    public Integer travelTime(FleetDTO fleetDTO){

        double timeNeeded= fleetDTO.getDistance()/fleetDTO.getAverageSpeed();
        int workingHour=Math.min(fleetDTO.getDrivers()*fleetDTO.getWorkingHours(),24);
        int restHour= (workingHour==24)?0:24-workingHour;
        return calcTime(timeNeeded,workingHour,restHour);
    }



    public Integer calcTime(double timeNeeded,int workingHour,int restHour){
        int travelTime=0;
        while (timeNeeded>=0){
            if(timeNeeded-workingHour>0){
                timeNeeded=timeNeeded-workingHour;
                travelTime+=workingHour+restHour;
            }
            else break;
        }
        travelTime+=timeNeeded;

        return Math.round(travelTime);
    }



}
