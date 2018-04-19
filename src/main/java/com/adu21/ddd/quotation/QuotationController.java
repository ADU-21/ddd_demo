package com.adu21.ddd.quotation;

import com.adu21.ddd.quotation.command.EnquiryCarPolicyCommand;
import com.adu21.ddd.quotation.command.EnquiryHomePolicyCommand;
import com.adu21.ddd.quotation.domain.model.CarPolicyQuotation;
import com.adu21.ddd.quotation.domain.model.HomePolicyQuotation;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/quote")
public class QuotationController {

    @Autowired
    private QuotationApplicationService quotationApplicationService;

    @PostMapping(value = "/home")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "POST", notes = "Enquiry home policy")
    public HomePolicyQuotation enquiryHomePolicy(@RequestBody @Valid EnquiryHomePolicyCommand command) {
        return quotationApplicationService.calculateQuote(command);
    }

    @PostMapping(value = "/car")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "POST", notes = "Enquiry car policy")
    public CarPolicyQuotation enquiryHomePolicy(@RequestBody @Valid EnquiryCarPolicyCommand command) {
        return quotationApplicationService.calculateQuote(command);
    }
}
