package com.example.kforcepractice;

import com.sun.source.tree.ReturnTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FleetController {
    @Autowired
    FleetService fleetService;
    @PostMapping("/fleets")
    public ResponseEntity<Map<String,Integer>>getTimRequired(@RequestBody FleetDTO fleetDTO){
        Map<String,Integer> map= new HashMap<>();
        if (fleetDTO==null){
            throw new WrongFormatException();
        }
            Integer val= fleetService.travelTime(fleetDTO);
            map.put("TimeSpent",val);
            return new ResponseEntity<>(map, HttpStatus.OK);

    }

    @GetMapping("/fleets")
    public ResponseEntity<FleetDTO>getTimeByrequestparam(
            @RequestParam(required = false) double distance ,
            @RequestParam(required = false,name = "drivers") int driversNumber,
            @RequestParam(required = false) double averageSpeed ,
            @RequestParam(required = false) int workingHours){
        FleetDTO fleetDTO = fleetService.travelTime(driversNumber,distance,averageSpeed,workingHours);
        return new ResponseEntity<>(fleetDTO,HttpStatus.OK);
    }

    @GetMapping("/fleetsmap")
    public ResponseEntity<Map<String,Integer>>getTimeByrequest(
            @RequestParam(required = false) double distance ,
            @RequestParam(required = false,name = "drivers") int driversNumber,
            @RequestParam(required = false) double averageSpeed ,
            @RequestParam(required = false, defaultValue = "12") int workingHours){
        FleetDTO fleetDTO= new FleetDTO(driversNumber,distance,averageSpeed,workingHours);
        Map<String,Integer> map= new HashMap<>();
        Integer val= fleetService.travelTime(fleetDTO);
        map.put("TimeSpent",val);
        return new ResponseEntity<>(map, HttpStatus.OK);


    }
}
