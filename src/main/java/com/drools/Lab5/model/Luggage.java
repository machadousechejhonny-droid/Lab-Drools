package com.drools.Lab5.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Luggage {

    @NotNull(message = "El peso del equipaje es obligatorio")
    @Min(value = 0, message = "El peso del equipaje no puede ser negativo")
    private Double weightKg;

    public Luggage() {}

    public Double getWeightKg() { return weightKg; }

    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }
}
