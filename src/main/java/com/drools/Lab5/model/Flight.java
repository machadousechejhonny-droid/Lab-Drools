package com.drools.Lab5.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Flight {

    @NotNull(message = "El retraso del vuelo es obligatorio")
    @Min(value = 0, message = "El retraso no puede ser negativo")
    private Integer delayMinutes;

    @NotNull(message = "La duración del vuelo es obligatoria")
    @Min(value = 0, message = "La duración no puede ser negativa")
    private Double durationHours;

    public Flight() {}

    public Integer getDelayMinutes() { return delayMinutes; }

    public void setDelayMinutes(Integer delayMinutes) { this.delayMinutes = delayMinutes; }

    public Double getDurationHours() { return durationHours; }

    public void setDurationHours(Double durationHours) { this.durationHours = durationHours; }
}
