package com.zuvocloud.automotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zuvocloud.automotive.dto.InvoicesDTO;
import com.zuvocloud.automotive.entity.Invoices;
import com.zuvocloud.automotive.services.InvoicesServices;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoicesControler {
    @Autowired
    private InvoicesServices invoicesServices;
    @GetMapping
    public ResponseEntity<List<InvoicesDTO>> getAll(){
        List<InvoicesDTO>invoicesDTOS = invoicesServices.getAll();
        return new ResponseEntity<>(invoicesDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Invoices> findById(@PathVariable("id") int id){
        Invoices invoices = invoicesServices.findById(id);
        return new ResponseEntity<>(invoices,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Invoices> createInvoices(@RequestBody InvoicesDTO invoicesDTO){
        Invoices invoices = invoicesServices.createInvoices(invoicesDTO);
        return new ResponseEntity<>(invoices,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Invoices>updateInvoices(@RequestBody InvoicesDTO invoicesDTO){
        Invoices invoices = invoicesServices.updateInvoices(invoicesDTO);
        return new ResponseEntity<>(invoices,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Invoices>deleteInvoices(@PathVariable int id){
        Invoices invoices = invoicesServices.deleteInvoice(id);
        return new ResponseEntity<>(invoices,HttpStatus.OK);
    }
}
