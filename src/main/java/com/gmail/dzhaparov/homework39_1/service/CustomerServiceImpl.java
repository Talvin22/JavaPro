package com.gmail.dzhaparov.homework39_1.service;

import com.gmail.dzhaparov.homework39_1.dao.CustomerDao;
import com.gmail.dzhaparov.homework39_1.dto.CustomerDtoRequest;
import com.gmail.dzhaparov.homework39_1.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service("userServiceImpl")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public Customer create(CustomerDtoRequest request) {
        customerDao.create(request);
        return customerDao.getLastEntity().orElse(null);
    }

    @Override
    public List<Customer> readAll() {
        return customerDao.getAll().orElse(Collections.emptyList());
    }

    @Override
    public Customer getById(Long id) {
        return customerDao.getById(id).orElse(null);
    }

    @Override
    public Customer updateById(Long id, CustomerDtoRequest request) {
        if (id == null) {
            throw new IllegalArgumentException("id can't be null");
        }

        if (customerDao.getById(id).isPresent()) {
            customerDao.updateById(id, request);
        }
        return customerDao.getById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (customerDao.getById(id).isPresent()) {
            return customerDao.deleteById(id);

        }
        return false;
    }
}
