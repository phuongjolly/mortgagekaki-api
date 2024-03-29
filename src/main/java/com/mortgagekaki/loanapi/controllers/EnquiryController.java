package com.mortgagekaki.loanapi.controllers;

import com.mortgagekaki.loanapi.models.LoanEnquiry;
import com.mortgagekaki.loanapi.services.EnquiryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/enquiry")
public class EnquiryController {

    private final EnquiryService enquiryService;

    /**
     * create an instance of Enquiry controller
     * @param enquiryService
     */
    public EnquiryController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }

    /**
     * start an enquiry = send emails to user
     * @param enquiry the enquery body
     * @return
     */
    @PostMapping
    public boolean enquiry(@RequestBody LoanEnquiry enquiry) {
        enquiryService.enquiry(enquiry);

        return true;
    }
}
