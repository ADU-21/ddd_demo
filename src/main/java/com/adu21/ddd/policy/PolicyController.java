package com.adu21.ddd.policy;

import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policy")
public class PolicyController {

    @Autowired
    private PolicyApplicationService policyApplicationService;

    @PutMapping(value = "/home")
    @ResponseStatus(HttpStatus.CREATED)
    public String createHomePolicy(@RequestBody CreateHomePolicyCommand createHomePolicyCommand) {
        return policyApplicationService.create(createHomePolicyCommand);
    }

    @PutMapping(value = "/car")
    @ResponseStatus(HttpStatus.CREATED)
    public String createCarPolicy(@RequestBody CreateCarPolicyCommand createCarPolicyCommand) {
        return policyApplicationService.create(createCarPolicyCommand);
    }
}
