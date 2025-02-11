package com.gmail.dzhaparov.homework39_1.service;

import com.gmail.dzhaparov.homework39_1.dto.CustomerDtoRequest;
import com.gmail.dzhaparov.homework39_1.entity.Customer;

import java.util.List;

public interface CustomerService extends BaseService<Customer, CustomerDtoRequest> {
    Customer create(CustomerDtoRequest request);
    List<Customer> readAll();
    Customer getById(Long id);
    Customer updateById(Long id, CustomerDtoRequest request);
    boolean deleteById(Long id);

}
