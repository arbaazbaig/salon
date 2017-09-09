package com.salon.salon.expenses.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends CrudRepository<Expenses, Long> {

}
