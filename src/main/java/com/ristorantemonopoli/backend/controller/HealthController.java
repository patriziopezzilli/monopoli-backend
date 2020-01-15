package com.ristorantemonopoli.backend.controller;

import com.ristorantemonopoli.backend.authentication.service.VisitorService;
import com.ristorantemonopoli.backend.dto.VisitorsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {

        return "OK";
    }
}
