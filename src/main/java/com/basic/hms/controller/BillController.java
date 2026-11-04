package com.basic.hms.controller;

import com.basic.hms.entity.Bill;
import com.basic.hms.service.BillService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    //Create
    @PostMapping
    public ResponseEntity<Bill> createBill(@Valid @RequestBody Bill bill){
        return new ResponseEntity<>(billService.createBill(bill), HttpStatus.CREATED);
    }

    //Get all
    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills(){
        return new ResponseEntity<>(billService.getAllBills(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id){
        return new ResponseEntity<>(billService.getBillById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long id, @Valid @RequestBody Bill bill){
        return new ResponseEntity<>(billService.updateBill(id, bill), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long id){
        billService.deleteBill(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
