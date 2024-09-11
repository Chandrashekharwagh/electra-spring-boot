package com.electra.repository;

import com.electra.domain.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository implements PaymentEntryRepository<Payment>{
    private static final Logger logger = LoggerFactory.getLogger(PaymentRepository.class);
    private final List<Payment> paymentList = new ArrayList<>();
    private int index = -1;

    public String store(Payment payment) {
        logger.info("/inside the PaymentRepository.store()");
        payment.setId(++index);
        paymentList.add(index, payment);
        return payment.toString();
    }

    @Override
    public String delete(int id) {
        logger.info("/inside the PaymentRepository.delete()");
        paymentList.remove(id);
        return "payment removed";
    }

    @Override
    public List<Payment> retrieve() {
        logger.info("/inside the PaymentRepository.retrieve()");
        return paymentList;
    }

    @Override
    public String search(int index) {
        logger.info("/inside the PaymentRepository.search()");
        return this.paymentList.get(index).toString();
    }

    @Override
    public String update(Payment payment) {
        logger.info("/inside the PaymentRepository.update()");
        // Check if the payment I'd be valid (greater than 0)
        if (payment.getId() > 0) {
            payment.setId(payment.getId());
        }
        if (payment.getCustomerId() > 0){
            payment.setCustomerId(payment.getCustomerId());
        }
        return payment.toString();
    }
}
