package com.example.LoanAccount;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public Loan getLoan(@PathVariable String number) {

        return new Loan(
                number,
                "car",
                400000,
                3258,
                18
        );
    }
}