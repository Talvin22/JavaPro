package com.gmail.dzhaparov.homework39_1.dto;

import com.gmail.dzhaparov.homework39_1.entity.Customer;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public record CustomerDtoListResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        List<Customer> userList) {

    public static final String SUCCESS_MESSAGE = "Customer list has been fetched successfully.";
    public static final String FAILURE_MESSAGE = "Customer list has not been found!";

    public static CustomerDtoListResponse of(boolean isCustomerListEmpty, List<Customer> customerList) {
        if (isCustomerListEmpty)
            return new CustomerDtoListResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    false, SUCCESS_MESSAGE, Collections.emptyList());
        else
            return new CustomerDtoListResponse(
                    HttpStatus.NO_CONTENT.value(),
                    HttpStatus.NO_CONTENT.getReasonPhrase(),
                    true, FAILURE_MESSAGE, customerList);
    }
}