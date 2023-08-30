package ra.md5th1.service;

import org.springframework.stereotype.Service;
import ra.md5th1.model.Customer;

import java.util.List;



public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    void deleteById(Long id);
    void save(Customer customer);
}
