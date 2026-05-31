package com.drools.Lab5.service;

import com.drools.Lab5.model.AirlineResponse;
import com.drools.Lab5.model.BookingRequest;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    @Autowired
    private KieContainer kieContainer;

    public AirlineResponse evaluateBooking(BookingRequest request) {
        AirlineResponse response = new AirlineResponse();
        KieSession kieSession = kieContainer.newKieSession();
        try {
            kieSession.insert(request);
            kieSession.insert(response);
            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }
        if (response.getMessage() == null || response.getMessage().isEmpty()) {
            response.addMessage("No se activaron reglas especiales para esta reserva.");
        }
        return response;
    }
}
