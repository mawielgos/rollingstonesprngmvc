package com.rollingstone.orderprocessing.web.validators;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rollingstone.orderprocessing.model.Customer;

@Component
public class CustomerValidator implements Validator {

    public boolean supports(Class clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerName",
                "required.customerName", "Customer Name is required.");
        ValidationUtils.rejectIfEmpty(errors, "memberSince",
                "required.memberSince", "Member since Date is required.");
        ValidationUtils.rejectIfEmpty(errors, "customerAddress.houseNumber",
                "required.address.houseNumber", "House number is required.");
        ValidationUtils.rejectIfEmpty(errors, "customerAddress.street",
                "required.address.street", "Street name is required.");
        ValidationUtils.rejectIfEmpty(errors, "customerAddress.city",
                "required.address.city", "City  is required.");
        ValidationUtils.rejectIfEmpty(errors, "customerAddress.state",
                "required.address.state", "State is required.");
        ValidationUtils.rejectIfEmpty(errors, "customerAddress.country",
                "required.address.country", "Country is required.");
        ValidationUtils.rejectIfEmpty(errors, "defaultCard.cardNumber",
                "required.defaultCard.cardNumber", "Credit Card number is required.");
        ValidationUtils.rejectIfEmpty(errors, "defaultCard.securityCode",
                "required.defaultCard.securityCode", "CC security code  is required.");
        ValidationUtils.rejectIfEmpty(errors, "defaultCard.expDate",
                "required.defaultCard.expDate", "CC expDate  is required.");
        ValidationUtils.rejectIfEmpty(errors, "defaultCard.cardType",
                "required.defaultCard.cardType", "CC cardType   is required.");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "player.name",
                "required.playerName", "Player name is required.houseNumber");
        ValidationUtils.rejectIfEmpty(errors, "sportType",
                "required.sportType", "Sport type is required.");

        Customer customer = (Customer) target;
        Date date = customer.getMemberSince();
     
     
    }
}
