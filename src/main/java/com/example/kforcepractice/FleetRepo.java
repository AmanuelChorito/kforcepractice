package com.example.kforcepractice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface FleetRepo extends JpaRepository<FleetDTO,Long> {
    //@Query("select ")
    Optional<List<FleetDTO>> findFleetDTOByIdAndAndDrivers(long id, int drivers);
}
