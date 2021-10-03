package com.example.kforcepractice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class FleetControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Mock
    private FleetService fleetService;
    @InjectMocks
    private FleetController fleetController;
    @Test
    public void ShouldReturnResult() throws Exception {

        FleetDTO fleetDTO2 = FleetDTO.builder().drivers(3).distance(3000).averageSpeed(65).workingHours(12).build();
        given(fleetService.travelTime(fleetDTO2)).willReturn(46);

        ResponseEntity<Map<String,Integer>>responseEntity =fleetController.getTimRequired(fleetDTO2);
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(200);
        assertThat(responseEntity.getBody().get("TimeSpent")).isEqualTo(46);


       // verify(fleetService, times(1)).travelTime(fleetDTO);

        //        mockMvc.perform(post("/fleets").content(objectMapper.writeValueAsString(fleetDTO)).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isMap())
//                .andExpect(jsonPath("TimeSpent").value(46));
    }

    @Test
    public void shouldReturnParamValue() throws Exception {
        double distance = 3000;
        int drivers = 3;
        double averageSpeed = 65;
        int workingHours = 12;
        FleetDTO fleetDTO = new FleetDTO(drivers, distance, averageSpeed, workingHours,46);

        when(fleetService.travelTime(drivers,distance,averageSpeed,workingHours)).thenReturn(fleetDTO);

        ResponseEntity<FleetDTO> fleetDTO1=fleetController.getTimeByrequestparam(distance,drivers,averageSpeed,workingHours);

        assertThat(fleetDTO1.getBody().getTravelTime()).isEqualTo(46);
        assertThat(fleetDTO1.getStatusCodeValue()).isEqualTo(200);


//        MvcResult result = mockMvc.perform(get("/fleets")
//                .param("distance", String.valueOf(distance))
//                .param("drivers", String.valueOf(drivers))
//                .param("averageSpeed", String.valueOf(drivers))
//                .param("workingHours", String.valueOf(drivers))
//        ).andExpect(status().isOk()).andReturn();

    }

    @Test
    public void shouldthrowExceptionwhenNull() throws Exception {

//     ResponseEntity<Map<String,Integer>>responseEntity   =fleetController.getTimRequired(null);
//     // assertThat(responseEntity.getStatusCode().is4xxClientError()).isTrue();

        mockMvc.perform(post("/fleets").
                        content(objectMapper.writeValueAsString(null)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }
}
