package com.drools.Lab5.controller;

import com.drools.Lab5.ai.AIExplanationService;
import com.drools.Lab5.model.AirlineResponse;
import com.drools.Lab5.model.BookingRequest;
import com.drools.Lab5.model.Flight;
import com.drools.Lab5.model.Luggage;
import com.drools.Lab5.model.Passenger;
import com.drools.Lab5.service.AirlineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AIExplanationService aiService;

    @PostMapping("/api/evaluate")
    @ResponseBody
    public AirlineResponse evaluateBookingApi(
            @Valid @RequestBody BookingRequest request,
            BindingResult result) {

        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                    .orElse("Errores de validación");

            AirlineResponse response = new AirlineResponse();
            response.addMessage("Error de validación: " + errorMessage);
            return response;
        }

        return airlineService.evaluateBooking(request);
    }

    @PostMapping("/evaluateBooking")
    @ResponseBody
    public Object evaluate(@RequestBody BookingRequest request) {
        AirlineResponse decision = airlineService.evaluateBooking(request);
        String explanation = aiService.explain(decision.getMessage());

        return new Object() {
            public final AirlineResponse result = decision;
            public final String aiExplanation = explanation;
        };
    }

    @GetMapping("/form")
    public String showBookingForm(Model model) {
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setPassenger(new Passenger());
        bookingRequest.setFlight(new Flight());
        bookingRequest.setLuggage(new Luggage());
        bookingRequest.setEmergencyExitSeatAvailable(true);

        model.addAttribute("bookingRequest", bookingRequest);
        return "credit_form";
    }

    @PostMapping("/evaluate")
    public String evaluateBookingWeb(
            @Valid BookingRequest bookingRequest,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "credit_form";
        }

        AirlineResponse airlineResponse = airlineService.evaluateBooking(bookingRequest);
        model.addAttribute("airlineResponse", airlineResponse);
        return "credit_result";
    }
}
