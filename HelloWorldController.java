package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HelloWorldController {


    @GetMapping("factorial/{x}")
    public int getFactorial(@PathVariable("x") int x) {
        if (x < 0) {
            return -1;}

        if (x == 0 || x == 1) {
            return 1;}

        int factorial = 1;

        for (int i = 2; i <= x; i++) {
            factorial *= i;
        }

        return factorial;
    }

    @GetMapping("calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b) {
        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        double quotient = (double) a / b;
        return "{" +
                "sum: " + sum + "," +
                "difference: " + difference + "," +
                "product " + product + "," +
                "quotient " + quotient + "," +
                "}";
    }

    @GetMapping("prime-numbers")
    public ArrayList<Integer> getPrimeN(
            @RequestParam(name = "from", required = false, defaultValue = "2") int from,
            @RequestParam(name = "to", required = false) Integer to) {
        ArrayList<Integer> primeN = new ArrayList<>();

         if (from < 2) {
             from = 2;}

        if (to == null) {
            to = from + 100;}

        for (int n = from; n <= to; n++) {
            if (isPrime(n)) {
                primeN.add(n);}
        }

        return primeN;
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;}

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;}
        }

        return true;}
}


