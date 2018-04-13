package com.adu21.ddd.policy;

import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.quote.command.EnquiryHomePolicyCommand;
import com.adu21.ddd.quote.domain.model.Quotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policy")
public class PolicyController {

    @Autowired
    private PolicyApplicationService policyApplicationService;

    @PostMapping(value = "/home/inquiry")
    @ResponseStatus(HttpStatus.OK)
    public Quotation inquiry(@RequestBody EnquiryHomePolicyCommand enquiryHomePolicyCommand) {
        return policyApplicationService.inquiry(enquiryHomePolicyCommand);
    }

    @PostMapping(value = "/home")
    @ResponseStatus(HttpStatus.CREATED)
    public void createHomePolicy(@RequestBody CreateHomePolicyCommand createHomePolicyCommand) {
        policyApplicationService.apply(createHomePolicyCommand);
    }

    @PostMapping(value = "/car")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCarPolicy(@RequestBody CreateCarPolicyCommand createCarPolicyCommand) {
        policyApplicationService.apply(createCarPolicyCommand);
    }
}
