package com.adu21.ddd.quote;

import com.adu21.ddd.quote.command.EnquiryCarPolicyCommand;
import com.adu21.ddd.quote.command.EnquiryHomePolicyCommand;
import com.adu21.ddd.quote.domain.model.CarPolicyQuotation;
import com.adu21.ddd.quote.domain.model.HomePolicyQuotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quote")
public class QuoteController {

    @Autowired
    private QuoteApplicationService quoteApplicationService;

    @PostMapping(value = "/home")
    @ResponseStatus(HttpStatus.CREATED)
    public HomePolicyQuotation enquiryHomePolicy(@RequestBody EnquiryHomePolicyCommand enquiryHomePolicyCommand) {
        return quoteApplicationService.calculateQuote(enquiryHomePolicyCommand);
    }

    @PostMapping(value = "/car")
    @ResponseStatus(HttpStatus.CREATED)
    public CarPolicyQuotation enquiryHomePolicy(@RequestBody EnquiryCarPolicyCommand enquiryCarPolicyCommand) {
        return quoteApplicationService.calculateQuote(enquiryCarPolicyCommand);
    }
}
