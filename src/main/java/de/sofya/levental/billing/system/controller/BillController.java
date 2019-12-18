package de.sofya.levental.billing.system.controller;

import de.sofya.levental.billing.system.domain.Bill;
import de.sofya.levental.billing.system.exception.BillIdMismatchException;
import de.sofya.levental.billing.system.exception.BillNotFoundException;
import de.sofya.levental.billing.system.repo.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bills")
public class BillController {
    @Autowired
    private BillRepository billRepository;

    @GetMapping
    public Iterable findAll() {
        return billRepository.findAll();
    }

    @GetMapping("/title/{billTitle}")
    public List findByTitle(@PathVariable String billTitle) {
        return billRepository.findByTitle(billTitle);
    }

    @GetMapping("/{id}")
    public Bill findOne(@PathVariable Long id) throws BillNotFoundException {
        return billRepository.findById(id)
                .orElseThrow(BillNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bill create(@RequestBody Bill bill) {
        return billRepository.save(bill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws BillNotFoundException {
        billRepository.findById(id)
                .orElseThrow(BillNotFoundException::new);
        billRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Bill updateBook(@RequestBody Bill bill, @PathVariable Long id) throws BillIdMismatchException, BillNotFoundException {
        if (bill.getId() != id) {
            throw new BillIdMismatchException();
        }
        billRepository.findById(id)
                .orElseThrow(BillNotFoundException::new);
        return billRepository.save(bill);
    }

}
