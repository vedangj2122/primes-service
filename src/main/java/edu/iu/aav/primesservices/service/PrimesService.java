package edu.iu.aav.primesservices.service;
import org.springframework.stereotype.Service;

@Service
public class PrimesService implements IPrimesService {

    @Override
    public boolean isPrime(long n) {
        if (n == 2) {
            return true;
        }
        for (long i = 2L; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}