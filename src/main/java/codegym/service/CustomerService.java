package codegym.service;

import codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerService {
    private static HashMap customers;
    public int key=1;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customers.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customers.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customers.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customers.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }
    public ArrayList<Customer> fillAll(){
        return new ArrayList<> (customers.values());
    }
    public void save(Customer customer){
        customers.put(customer.getId(), customer);
    }

    public Customer findById(int id){
        return (Customer) customers.get(id);
    }

    public  void update(int id, Customer customer){
        customers.put(id, customer);

    }

    public void remove(int id){
        customers.remove(id);
    }

}