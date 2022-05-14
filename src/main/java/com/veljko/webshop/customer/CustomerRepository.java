package com.veljko.webshop.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("from Customer as c where c.spent = (select max(cu.spent) from Customer cu)")
    Customer findCustomerWithMostMoneySpent();

    @Query("from Customer as c where c.purchases = (select max(cu.purchases) from Customer cu)")
    Customer findCustomerWithMostPurchases();

}
