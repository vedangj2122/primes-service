package edu.iu.aav.primesservice.repository;

import java.io.IOException;

import edu.iu.aav.primesservice.model.Customer;

public interface IAuthenticationRepository {

    boolean save(Customer customer) throws IOException;

    Customer findByUsername(String username) throws IOException;
}