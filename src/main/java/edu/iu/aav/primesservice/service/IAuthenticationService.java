package edu.iu.aav.primesservice.service;

import java.io.IOException;

import edu.iu.aav.primesservice.model.Customer;

public interface IAuthenticationService {

    Customer register(Customer customer) throws IOException;

    boolean login(String username, String password) throws IOException;

}