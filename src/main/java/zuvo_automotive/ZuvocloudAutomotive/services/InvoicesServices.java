package zuvo_automotive.ZuvocloudAutomotive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuvo_automotive.ZuvocloudAutomotive.dto.InvoicesDTO;
import zuvo_automotive.ZuvocloudAutomotive.entity.Invoices;
import zuvo_automotive.ZuvocloudAutomotive.repository.InvoicesRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoicesServices {
    @Autowired
    private InvoicesRepo invoicesRepo;

    public List<InvoicesDTO> getAll() {
        List<Invoices> invoices = invoicesRepo.findAll();
        List<InvoicesDTO> invoicesDTOS = new ArrayList<>();
        for (Invoices invoices1 : invoices) {
            InvoicesDTO invoicesDTO = new InvoicesDTO();
            invoicesDTO.setId(invoices1.getId());
            invoicesDTO.setInvoiceDate(invoices1.getInvoiceDate());
            invoicesDTO.setDiscount(invoices1.getDiscount());
            invoicesDTO.setTax(invoices1.getTax());
            invoicesDTO.setGeneratedAt(invoices1.getGeneratedAt());
            invoicesDTO.setJobCardId(invoices1.getJobCardId());
            invoicesDTO.setPaymentMethod(invoices1.getPaymentMethod());
            invoicesDTO.setPaymentStatus(invoices1.getPaymentStatus());
            invoicesDTO.setSubTotal(invoices1.getSubTotal());
            invoicesDTO.setTotalAmount(invoices1.getTotalAmount());
            invoicesDTOS.add(invoicesDTO);
        }
        return invoicesDTOS;

    }

    public Invoices findById(int id) {
        Invoices invoices = invoicesRepo.findById(id)
                .orElseThrow(()->new RuntimeException("invoices not found with id"+id));
        return invoices;
    }

    public Invoices createInvoices(InvoicesDTO invoicesDTO) {
        try{
            Invoices invoices = new Invoices();
            invoices.setId(invoicesDTO.getId());
            invoices.setDiscount(invoicesDTO.getDiscount());
            invoices.setInvoiceDate(invoicesDTO.getInvoiceDate());
            invoices.setTax(invoicesDTO.getTax());
            invoices.setGeneratedAt(invoicesDTO.getGeneratedAt());
            invoices.setPaymentMethod(invoicesDTO.getPaymentMethod());
            invoices.setPaymentStatus(invoicesDTO.getPaymentStatus());
            invoices.setSubTotal(invoicesDTO.getSubTotal());
            invoices.setTotalAmount(invoicesDTO.getTotalAmount());
            invoices.setJobCardId(invoices.getJobCardId());
            Invoices invoices1 =  invoicesRepo.save(invoices);
            return invoices1;

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Invoices updateInvoices(InvoicesDTO invoicesDTO) {
        try {
            Invoices invoices = new Invoices();
            invoices.setId(invoicesDTO.getId());
            invoices.setDiscount(invoicesDTO.getDiscount());
            invoices.setInvoiceDate(invoicesDTO.getInvoiceDate());
            invoices.setTax(invoicesDTO.getTax());
            invoices.setGeneratedAt(invoicesDTO.getGeneratedAt());
            invoices.setPaymentMethod(invoicesDTO.getPaymentMethod());
            invoices.setPaymentStatus(invoicesDTO.getPaymentStatus());
            invoices.setSubTotal(invoicesDTO.getSubTotal());
            invoices.setTotalAmount(invoicesDTO.getTotalAmount());
            invoices.setJobCardId(invoices.getJobCardId());
            Invoices invoices1 = invoicesRepo.save(invoices);
            return invoices1;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Invoices deleteInvoice(int id) {
        Invoices invoices = invoicesRepo.findById(id)
                .orElseThrow(()->new RuntimeException("invoices not found with id"+id));
        invoices.setDeleted(false);
        return invoicesRepo.save(invoices);
    }
}
