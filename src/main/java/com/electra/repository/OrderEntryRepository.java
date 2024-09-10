package com.electra.repository;

import java.util.List;

public interface OrderEntryRepository <Order>{
    public String store(Order order);

    public List<Order> retrieve();

    public String search(int id);

    public String delete(int id);

    public String update(Order order);
}
