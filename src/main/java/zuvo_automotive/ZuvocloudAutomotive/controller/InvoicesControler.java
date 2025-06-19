package zuvo_automotive.ZuvocloudAutomotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zuvo_automotive.ZuvocloudAutomotive.dto.InvoicesDTO;
import zuvo_automotive.ZuvocloudAutomotive.entity.Invoices;
import zuvo_automotive.ZuvocloudAutomotive.services.InvoicesServices;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoicesControler {
    @Autowired
    private InvoicesServices invoicesServices;
    @GetMapping("/invoices")
    public ResponseEntity<List<InvoicesDTO>> getAll(){
        List<InvoicesDTO>invoicesDTOS = invoicesServices.getAll();
        return new ResponseEntity<>(invoicesDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Invoices> findById(@PathVariable("id") int id){
        Invoices invoices = invoicesServices.findById(id);
        return new ResponseEntity<>(invoices,HttpStatus.OK);
    }
    @PostMapping("/createInvoices")
    public ResponseEntity<Invoices> createInvoices(@RequestBody InvoicesDTO invoicesDTO){
        Invoices invoices = invoicesServices.createInvoices(invoicesDTO);
        return new ResponseEntity<>(invoices,HttpStatus.OK);
    }
    @PutMapping("/updateInvoices")
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
