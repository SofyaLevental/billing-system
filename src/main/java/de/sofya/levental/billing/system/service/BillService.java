package de.sofya.levental.billing.system.service;

import de.sofya.levental.billing.system.domain.Bill;
import de.sofya.levental.billing.system.repo.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class BillService {
    private BillRepository repository;

    @Autowired
    public BillService(BillRepository repository){
        this.repository = repository;
    }

}
