package service;

import model.Customer;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerService {
    List<Customer> customerList;

    public CustomerService() {
        this.customerList = new ArrayList<>();
    }

    public Customer createCustomer(String id){
        Customer customer = new Customer(id);
        customerList.add(customer);
        return customer;
    }


    public Customer getCustomerInfo(String id) {
        return customerList.stream().filter(i -> i.getId().equals(id)).findAny().orElse(null);
    }


}
