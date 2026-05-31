package com.drools.Lab5.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class BookingRequest {

    @NotNull(message = "El pasajero es obligatorio")
    @Valid
    private Passenger passenger;

    @NotNull(message = "Los datos del vuelo son obligatorios")
    @Valid
    private Flight flight;

    @NotNull(message = "Los datos del equipaje son obligatorios")
    @Valid
    private Luggage luggage;

    private boolean emergencyExitSeatAvailable;

    public BookingRequest() {}

    public Passenger getPassenger() { return passenger; }

    public void setPassenger(Passenger passenger) { this.passenger = passenger; }

    public Flight getFlight() { return flight; }

    public void setFlight(Flight flight) { this.flight = flight; }

    public Luggage getLuggage() { return luggage; }

    public void setLuggage(Luggage luggage) { this.luggage = luggage; }

    public boolean isEmergencyExitSeatAvailable() { return emergencyExitSeatAvailable; }

    public void setEmergencyExitSeatAvailable(boolean emergencyExitSeatAvailable) {
        this.emergencyExitSeatAvailable = emergencyExitSeatAvailable;
    }
}
