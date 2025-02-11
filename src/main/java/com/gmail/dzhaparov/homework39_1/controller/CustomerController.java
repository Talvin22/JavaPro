package com.gmail.dzhaparov.homework39_1.controller;

import com.gmail.dzhaparov.homework39_1.dto.*;
import com.gmail.dzhaparov.homework39_1.entity.Customer;
import com.gmail.dzhaparov.homework39_1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDtoCreateResponse> createCustomer(@RequestBody CustomerDtoRequest customerDtoRequest) {
        Customer customer = customerService.create(customerDtoRequest);

        return (customer != null) ?
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoCreateResponse.of(true, customer))
                :
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoCreateResponse.of(false, null));

    }

    @GetMapping
    public ResponseEntity<CustomerDtoListResponse> fetchAllCustomers() {
        List<Customer> customers = customerService.readAll();

        return (!customers.isEmpty()) ?
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoListResponse.of(true, customers))
                :
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoListResponse.of(false, Collections.emptyList()));


    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDtoByIdResponse> fetchCustomerById(@PathVariable("id") Long id) {
        Customer customer = customerService.getById(id);

        return (customer != null) ?
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoByIdResponse.of(id, true, customer))
                :
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoByIdResponse.of(id, false, null));

    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDtoUpdateResponse> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDtoRequest customerDtoRequest){
        Customer customer = customerService.updateById(id, customerDtoRequest);

        return (customer != null) ?
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoUpdateResponse.of(id, true, customer))
                :
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoUpdateResponse.of(id, false, null));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDtoDeleteResponse> deleteCustomer(@PathVariable("id") Long id) {
        if (customerService.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CustomerDtoDeleteResponse.of(id, true));
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CustomerDtoDeleteResponse.of(id, false));
        }
    }
}
