package com.postech.mscustomers.gateway;

import com.postech.mscustomers.entity.Customer;
import com.postech.mscustomers.interfaces.ICustomerGateway;
import com.postech.mscustomers.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerGateway implements ICustomerGateway {
    private final CustomerRepository customerRepository;

    public CustomerGateway(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(String strId) {
        try {
            customerRepository.deleteById(Integer.valueOf(strId));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Customer findCustomer(String strId) {
        try {
            return customerRepository.findById(Integer.valueOf(strId)).orElseThrow();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }
}
