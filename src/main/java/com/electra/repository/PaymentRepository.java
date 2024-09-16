package com.electra.repository;

import com.electra.domain.Customer;
import com.electra.domain.Order;
import com.electra.domain.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository implements PaymentEntryRepository<Payment> {
    private static final Logger logger = LoggerFactory.getLogger(PaymentRepository.class);
    private final List<Payment> paymentList = new ArrayList<>();
    private int index = 0;

    @Override
    public String store(Payment payment) {
        logger.info("Inside PaymentRepository.store()");
        payment.setId(++index);
        paymentList.add(payment);

        Customer customer = payment.getCustomer();
        Order order = payment.getOrder();

        logger.info("Stored Payment with ID " + payment.getId() +
                " for Customer with ID " + (customer != null ? customer.getId() : "None") +
                " and Order with ID " + (order != null ? order.getId() : "None"));

        return payment.toString();
    }

    @Override
    public String delete(int id) {
        logger.info("Inside PaymentRepository.delete()");
        Payment paymentToRemove = null;

        for (Payment payment : paymentList) {
            if (payment.getId() == id) {
                paymentToRemove = payment;
                break;
            }
        }

        if (paymentToRemove == null) {
            logger.error("Payment with ID " + id + " not found.");
            return "Payment not found";
        }

        paymentList.remove(paymentToRemove);
        logger.info("Payment with ID " + id + " removed.");
        return "Payment removed";
    }

    @Override
    public List<Payment> retrieve() {
        logger.info("Retrieving all payments from PaymentRepository.");
        return new ArrayList<>(paymentList);
    }

    @Override
    public String search(int index) {
        logger.info("Inside PaymentRepository.search()");
        return paymentList.get(index).toString();
    }

    @Override
    public String update(Payment payment) {
        logger.info("Inside PaymentRepository.update()");

        Payment existingPayment = null;
        for (Payment p : paymentList) {
            if (p.getId() == payment.getId()) {
                existingPayment = p;
                break;
            }
        }

        if (existingPayment == null) {
            logger.error("Payment with ID " + payment.getId() + " not found.");
            return "Payment not found. Update failed.";
        }

        existingPayment.setAmount(payment.getAmount());
        existingPayment.setPaymentDate(payment.getPaymentDate());
        existingPayment.setCustomer(payment.getCustomer());
        existingPayment.setOrder(payment.getOrder());

        logger.info("Payment updated successfully with ID " + payment.getId());
        return existingPayment.toString();
    }
}
