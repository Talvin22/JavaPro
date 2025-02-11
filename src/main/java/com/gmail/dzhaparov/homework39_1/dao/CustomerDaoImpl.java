package com.gmail.dzhaparov.homework39_1.dao;

import com.gmail.dzhaparov.homework39_1.dto.CustomerDtoRequest;
import com.gmail.dzhaparov.homework39_1.entity.Customer;
import com.gmail.dzhaparov.homework39_1.entity.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository("userDaoImpl")
public class CustomerDaoImpl implements CustomerDao {

    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public boolean create(CustomerDtoRequest request) {
        String sql = "INSERT INTO customers (full_name, email, social_security_number) VALUES (:fullName, :email, :socialSecurityNumber)";

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("fullName", request.fullName())
                .addValue("email", request.email())
                .addValue("socialSecurityNumber", request.socialSecurityNumber());

        return jdbcTemplate.update(sql, params) > 0;


    }

    @Override
    public Optional<List<Customer>> getAll() {
        String sql = "SELECT * FROM customers";
        Optional<List<Customer>> customers;

        try {
            customers = Optional.of(jdbcTemplate.query(sql, new CustomerMapper()));
        } catch (Exception e) {
            customers = Optional.empty();
        }
        return customers;

    }

    @Override
    public Optional<Customer> getById(Long id) {
        String sql = "SELECT * FROM customers WHERE id = :id";

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        jdbcTemplate.queryForObject(sql, params, new CustomerMapper());
        Optional<Customer> customer;

        try {
            customer = Optional.of(jdbcTemplate.queryForObject(sql, params, new CustomerMapper()));
        } catch (Exception e) {
            customer = Optional.empty();
        }
        return customer;
    }

    @Override
    public boolean updateById(Long id, CustomerDtoRequest request) {
        String sql = "UPDATE customers SET full_name = :fullName, email = :email, social_security_number = :socialSecurityNumber WHERE id = :id";

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("fullName", request.fullName())
                .addValue("email", request.email())
                .addValue("socialSecurityNumber", request.socialSecurityNumber())
                .addValue("id", id);

        return jdbcTemplate.update(sql, params) > 0;
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM customers WHERE id = :id";

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        return jdbcTemplate.update(sql, params) > 0;
    }

    @Override
    public Optional<Customer> getLastEntity() {
        String sql = "SELECT * FROM customers ORDER BY id DESC LIMIT 1";

        SqlParameterSource params = new MapSqlParameterSource();
        Optional<Customer> customer;

        try {
            customer = Optional.of(jdbcTemplate.queryForObject(sql, params, new CustomerMapper()));
        } catch (Exception e) {
            customer = Optional.empty();
        }
        return customer;

    }
}
