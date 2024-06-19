package com.bus.booking_service.ExternalClasses;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@Data is a convenient shortcut annotation that bundles the features of @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor together
@Data
//It is used to generate a constructor with one parameter for every field in the class
@NoArgsConstructor
//It is Default constructor.generate a constructor with no parameters
@AllArgsConstructor
public class PaymentModel {
	
	//it indicating the member field below is the primary key of the current entity.
	@Id
	private int transactionId;
	private String bookingId;
	private String username;
	private double amount;
	private String transactionStatus;

}


