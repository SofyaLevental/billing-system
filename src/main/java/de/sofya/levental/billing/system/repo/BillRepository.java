package de.sofya.levental.billing.system.repo;

import de.sofya.levental.billing.system.domain.Bill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillRepository extends CrudRepository<Bill, Long> {
    List<Bill> findByTitle(String title);
}
