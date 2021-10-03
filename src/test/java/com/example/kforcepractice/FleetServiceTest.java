package com.example.kforcepractice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
public class FleetServiceTest {
    @InjectMocks
    private FleetService fleetService;

    @Test
    public void ShouldReturnValue() throws Exception{

    }
}
