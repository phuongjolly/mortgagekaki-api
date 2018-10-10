package com.mortgagekaki.loanapi.services;

import com.mortgagekaki.loanapi.models.LoanEnquiry;
import com.mortgagekaki.loanapi.models.PackageType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EnquiryService {
    private final EmailService emailService;
    private final String subject;

    public EnquiryService(EmailService emailService,
                          @Value("${email.subject}") String subject) {
        this.emailService = emailService;
        this.subject = subject;
    }

    /**
     * start an enquiry
     * @param enquiry
     */
    public void enquiry(LoanEnquiry enquiry) {
        StringBuilder text = new StringBuilder();

        text.append(String.format("Hi %s\n", enquiry.getName()));
        text.append("Thank you for your Interest in the below loan package:\n\n");
        text.append("Enquire Details are :\n\n");

        text.append(String.format("Enquire Email: %s\n", enquiry.getEmail()));
        text.append(String.format("Enquire Mobile: %s\n", enquiry.getMobile()));
        text.append(String.format("Type: %s\n", enquiry.getType()));
        text.append(String.format("Property Type: %s\n", enquiry.getPropertyType()));

        if (enquiry.getType() == PackageType.NEW) {
            text.append(String.format("Estimated/Actual Purchase Price: %.2f\n", enquiry.getPurchasePrice()));
            text.append(String.format("Tenure: %d\n", enquiry.getDuration()));
        } else {
            text.append(String.format("Current Bank: %s\n", enquiry.getCurrentBank()));
            text.append(String.format("Estimated/Actual Purchase Price: %.2f\n", enquiry.getPurchasePrice()));

            text.append(String.format("1'st Year Interest Rate: %.2f\n", enquiry.getInterests().get(0)));
            text.append(String.format("2'nd Year Interest Rate: %.2f\n", enquiry.getInterests().get(1)));
            text.append(String.format("3'rd Year Interest Rate: %.2f\n", enquiry.getInterests().get(2)));
            text.append(String.format("Tenure: %d\n", enquiry.getDuration()));
            text.append(String.format("Lock In: %s\n", enquiry.getLockIn()));
        }

        text.append(String.format("Loan Type: %s\n", enquiry.getLoanType()));
        text.append(String.format("Package Name: %s\n\n", enquiry.getPackageName()));

        text.append("Thanks and Regards,\n\n");
        text.append("MortagageKaki.com\n");

        emailService.sendEmail(enquiry.getEmail(), subject, text.toString());
    }
}
