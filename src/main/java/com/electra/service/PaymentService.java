package com.electra.service;

import com.electra.domain.Payment;
import com.electra.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentRepository repo;

    public List<Payment> retrievePayments() {
        logger.info("Inside PaymentService.retrievePayments()");
        return repo.retrieve();
    }

    public String storePayment(Payment payment) {
        logger.info("Inside PaymentService.storePayment()");
        return repo.store(payment);
    }

    public String deletePayment(int id) {
        logger.info("Inside PaymentService.deletePayment()");
        return repo.delete(id);
    }

    public String search(int id) {
        logger.info("Inside PaymentService.search()");
        return repo.search(id);
    }

    public String updatePayment(int id, Payment payment) {
        logger.info("Inside PaymentService.updatePayment()");
        payment.setId(id);
        return repo.update(payment);
    }
}
