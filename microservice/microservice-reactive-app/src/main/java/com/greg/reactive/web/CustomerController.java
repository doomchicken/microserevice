package com.greg.reactive.web;


import com.greg.microsservice.shared.model.ApiResult;
import com.greg.microsservice.shared.model.CustomerCreateRequest;
import com.greg.microsservice.shared.model.CustomerModel;
import com.greg.reactive.data.CustomerEntity;
import com.greg.reactive.data.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerRepo customerRepo;

    @PostMapping
    public Mono<ApiResult> createCustomer(CustomerCreateRequest request){
        var customer = new CustomerEntity();
        customer.setName(request.name());
        var saveMono = customerRepo.save(customer)
                .map(x-> new ApiResult(x.getId(), true , "Customer Saved"));
        return saveMono;
    }

    @GetMapping
    public Flux<CustomerModel> getCustomers(){
        var customerFlux = customerRepo.findAll()
                .map(x->new CustomerModel(x.getId(),x.getName(),x.getCreated()));

        return customerFlux;
    }
}
