package com.electra.repository;

import java.util.List;

public interface PaymentEntryRepository <Payment>{
    public String store(Payment payment);

    public List<Payment> retrieve();

    public String search(int id);

    public String delete(int id);

    public String update(Payment payment);
}
