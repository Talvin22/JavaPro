package com.gmail.dzhaparov.homework39_1.dto;

import com.gmail.dzhaparov.homework39_1.entity.Customer;
import org.springframework.http.HttpStatus;

public record CustomerDtoByIdResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        Customer user) {

    public static final String SUCCESS_MESSAGE = "Customer with id %s has been fetched successfully.";
    public static final String FAILURE_MESSAGE = "Customer with id %s has not been found!";

    public static CustomerDtoByIdResponse of(Long id, boolean isUserFound, Customer customer) {
        if (isUserFound)
            return new CustomerDtoByIdResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true, SUCCESS_MESSAGE.formatted(id), customer);
        else
            return new CustomerDtoByIdResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    false, FAILURE_MESSAGE.formatted(id), null);
    }
}