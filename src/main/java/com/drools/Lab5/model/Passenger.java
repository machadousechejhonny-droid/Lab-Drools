package com.drools.Lab5.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Passenger {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String name;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    private Integer age;

    @NotBlank(message = "La membresía es obligatoria")
    private String membershipStatus; // Basic, Gold, Platinum

    private boolean travelingWithChildren;

    @NotBlank(message = "La preferencia de asiento es obligatoria")
    private String seatPreference; // Any, Window, Aisle, Middle

    public Passenger() {}

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public String getMembershipStatus() { return membershipStatus; }

    public void setMembershipStatus(String membershipStatus) { this.membershipStatus = membershipStatus; }

    public boolean isTravelingWithChildren() { return travelingWithChildren; }

    public void setTravelingWithChildren(boolean travelingWithChildren) {
        this.travelingWithChildren = travelingWithChildren;
    }

    public String getSeatPreference() { return seatPreference; }

    public void setSeatPreference(String seatPreference) { this.seatPreference = seatPreference; }
}
