package com.bus.booking_service.ExternalClasses;

import org.springframework.data.annotation.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@Data is a convenient shortcut annotation that bundles the features of @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor together
@Data
//It is used to generate a constructor with one parameter for every field in the class
@AllArgsConstructor
//It is Default constructor.generate a constructor with no parameters
@NoArgsConstructor
public class BusModel {
	//it indicating the member field below is the primary key of the current entity.
	@Id
    private String busNo;

    private String source;

    private String destination;

 
    private int fare;

    private int seats;

    private String dropTime;
    
    private String boardingTime;
    
}
