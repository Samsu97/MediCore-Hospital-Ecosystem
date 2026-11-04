package com.basic.hms.service;

import com.basic.hms.entity.Bill;
import com.basic.hms.exception.ResourceNotFoundException;
import com.basic.hms.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    //Add or Create
    public Bill createBill (Bill bill){
        return billRepository.save(bill);
    }

    //Get all
    public List<Bill> getAllBills(){
        return billRepository.findAll();
    }

    //Get by id
    public Bill getBillById(Long id){
        return billRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bill not found with id: " + id));
    }


    //Update
    public Bill updateBill(Long id, Bill bill){
        Bill existingBill = getBillById(id);

        existingBill.setAmount(bill.getAmount());
        existingBill.setPatient(bill.getPatient());
        existingBill.setPaymentStatus(bill.getPaymentStatus());

        return billRepository.save(existingBill);
    }

    //Delete
    public void deleteBill(Long id){
        Bill existingBill = getBillById(id);
        billRepository.delete(existingBill);
    }




}
