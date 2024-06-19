package com.bus.booking_service.contoller.test;



import com.bus.booking_service.ExternalClasses.BusBookingVo;
import com.bus.booking_service.controller.BookingController;
import com.bus.booking_service.model.BookingModel;
import com.bus.booking_service.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookingController.class)
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookingService bookingService;

    @InjectMocks
    private BookingController bookingController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBookTicket() throws Exception {
        BookingModel booking = new BookingModel("123", "user1", "bus1", "1234567890", "user@example.com", 2, 500);
        when(bookingService.bookTicket(any(BookingModel.class))).thenReturn(booking);

        mockMvc.perform(post("/booking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(booking)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(booking)));
    }

    @Test
    public void testCancelTicket() throws Exception {
        String ticketNo = "123";
        when(bookingService.cancelTicket(anyString())).thenReturn("Ticket cancelled");

        mockMvc.perform(delete("/deleteTicket/{ticketNo}", ticketNo))
                .andExpect(status().isOk())
                .andExpect(content().string("Ticket cancelled"));
    }

    @Test
    public void testViewAllBookings() throws Exception {
        List<BookingModel> bookings = new ArrayList<>();
        bookings.add(new BookingModel("123", "user1", "bus1", "1234567890", "user@example.com", 2, 500));
        when(bookingService.getAllBookings()).thenReturn(bookings);

        mockMvc.perform(get("/ViewAllBookings"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(bookings)));
    }

    @Test
    public void testViewByticketNo() throws Exception {
        String ticketNo = "123";
        BookingModel booking = new BookingModel(ticketNo, "user1", "bus1", "1234567890", "user@example.com", 2, 500);
        when(bookingService.getBookingByticketNo(anyString())).thenReturn(booking);

        mockMvc.perform(get("/ViewTicketByTicketNo/{ticketNo}", ticketNo))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(booking)));
    }

    @Test
    public void testViewByUserName() throws Exception {
        String username = "user1";
        List<BookingModel> bookings = new ArrayList<>();
        bookings.add(new BookingModel("123", username, "bus1", "1234567890", "user@example.com", 2, 500));
        when(bookingService.getBookingByUsername(anyString())).thenReturn(bookings);

        mockMvc.perform(get("/viewByUserName/{username}", username))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(bookings)));
    }

    @Test
    public void testGetBookingTicketByItsBusAndTotalCost() throws Exception {
        String ticketNo = "123";
        BusBookingVo busBookingVo = new BusBookingVo(); // Assuming BusBookingVo is another model class
        when(bookingService.getTicketDetailsWithBusDetails(anyString())).thenReturn(busBookingVo);

        mockMvc.perform(get("/ViewBookingTicketByItsBusAndTotalCost/{ticketNo}", ticketNo))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(busBookingVo)));
    }
}

