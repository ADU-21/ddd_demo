package com.adu21.ddd.controller.rest;

import com.adu21.ddd.command.CreateHomePolicyCommand;
import com.adu21.ddd.model.HomePolicy;
import com.adu21.ddd.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping(value = "/homepolicy")
    @ResponseStatus(HttpStatus.CREATED)
    public void createHomePolicy(@RequestBody CreateHomePolicyCommand createHomePolicyCommand) {
        policyService.apply(createHomePolicyCommand);
    }
}
