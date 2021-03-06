package com.example.customer.controller;
import com.example.customer.model.Customer;
import com.example.customer.model.CustomerDTO;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

        @Autowired
        private CustomerService customerService;

        @PostMapping(value="addCustomer", produces = "application/json")
         public Customer add(@RequestBody CustomerDTO customer){
            return this.customerService.add(customer);
        }


        @GetMapping(value = "getAllCustomers", produces = "application/json")
        public List<CustomerDTO> getAll() {
            List<CustomerDTO> all = customerService.getAllCustomers();
            return all;
        }

        @GetMapping(value = "getCustomerByEmail/{email}", produces = "application/json")
        public List<CustomerDTO> getCustomerByEmail(@PathVariable("email") String email) {
            System.out.println("Entered Controller");
            return this.customerService.getCustomerByEmail(email);
        }
}
