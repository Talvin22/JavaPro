package com.gmail.dzhaparov.homework39_1.dao;

import com.gmail.dzhaparov.homework39_1.dto.CustomerDtoRequest;
import com.gmail.dzhaparov.homework39_1.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao extends BaseDao<Customer, CustomerDtoRequest>{
    boolean create(CustomerDtoRequest request);
    Optional<List<Customer>> getAll();
    Optional<Customer> getById(Long id);
    boolean updateById(Long id, CustomerDtoRequest request);
    boolean deleteById(Long id);

    Optional<Customer> getLastEntity();
}
