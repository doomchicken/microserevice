package com.greg.microservice.web;

import com.greg.microservice.data.CustomerEntity;
import com.greg.microservice.data.CustomerRepo;
import com.greg.microsservice.shared.model.ApiResult;
import com.greg.microsservice.shared.model.CustomerCreateRequest;
import com.greg.microsservice.shared.model.CustomerModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerRepo customerRepo;

    @PostMapping
    public ApiResult createCustomer(CustomerCreateRequest request){
        var customer = new CustomerEntity();
        customer.setName(request.name());
        customerRepo.save(customer);
        return new ApiResult(customer.getId(), true ,"Customer created");
    }

    @GetMapping
    public List<CustomerModel> getCustomers(){
        var customers = StreamSupport.stream(customerRepo.findAll().spliterator(), true)
                .map(x-> new CustomerModel(x.getId(),x.getName(),x.getCreated()))
                .collect(Collectors.toList());

        return customers;
    }
}
