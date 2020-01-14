package com.ristorantemonopoli.backend.controller;

import com.ristorantemonopoli.backend.authentication.service.VisitorService;
import com.ristorantemonopoli.backend.dto.VisitorsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorController {

    @Autowired
    private VisitorService service;

    @RequestMapping(value = "/visitors", method = RequestMethod.GET)
    public VisitorsDTO login() {

        return new VisitorsDTO(service.countVisitors());
    }
}
