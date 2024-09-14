package com.electra.controller;

import com.electra.domain.Payment;
import com.electra.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    //@RequestMapping(path = "/payment", method = RequestMethod.GET)
    @GetMapping("/payment")
    public List<Payment> retrievePayments() {
        return paymentService.retrievePayments();
    }

    @GetMapping("/payment/{paymentId}")
    public String retrievePaymentForPaymentId(@PathVariable int paymentId) {
        return paymentService.search(paymentId);
    }

    @DeleteMapping("/payment/{paymentId}")
    public String deletePaymentForPaymentId(@PathVariable int paymentId) {
        return paymentService.deletePayment(paymentId);
    }

    @PostMapping("/payment")
    public String addPayment(@RequestBody Payment payment) {
        return paymentService.storePayment(payment);
    }

    @PutMapping("/payment/{paymentId}")
    public String updatePaymentForPaymentId(@PathVariable int paymentId, @RequestBody Payment payment) {
        return paymentService.updatePayment(paymentId, payment);
    }
}
