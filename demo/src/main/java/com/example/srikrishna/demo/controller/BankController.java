


// package com.example.srikrishna.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.srikrishna.demo.model.Bank;
// import com.example.srikrishna.demo.service.BankService;

// @RestController
// @RequestMapping("/bank")
// @CrossOrigin
// public class BankController {

//    @Autowired
//    private BankService bankService;

//    @PostMapping("/add")
//    public String add(@RequestBody Bank bank) {
//      bankService.saveBank(bank);
//      return "New bank is added";
//    }

//    @GetMapping("/getAll")
//    public List<Bank> getAllBanks() {
//       return bankService.getAllBanks();
//    }

//    @PutMapping("/update/{id}")
//    public String updateBank(@PathVariable int id, @RequestBody Bank bank) {
//      bank.setId(id);
//      bankService.saveBank(bank);
//      return "Bank with ID " + id + " is updated";
//    }                       
   
//    @DeleteMapping("/delete/{id}")
//    public String deleteBank(@PathVariable int id) {
//      bankService.deleteBank(id);
//      return "Bank with ID " + id + " is deleted";
//    }
// }


package com.example.srikrishna.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.example.srikrishna.demo.model.Bank;
import com.example.srikrishna.demo.service.BankService;

@RestController
@RequestMapping("/bank")
@CrossOrigin
public class BankController {

   @Autowired
   private BankService bankService;

   @PostMapping("/add")
   public String add(@RequestBody Bank bank) {
     bankService.saveBank(bank);
     return "New bank is added";
   }

   @GetMapping("/getAll")
   public Page<Bank> getAllBanks(
       @RequestParam(defaultValue = "0") int page,
       @RequestParam(defaultValue = "10") int size,
       @RequestParam(defaultValue = "id") String sortBy,
       @RequestParam(defaultValue = "asc") String sortOrder
   ) {
       Sort sort = sortOrder.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
       Pageable pageable = PageRequest.of(page, size, sort);
       return bankService.getAllBanks(pageable);
   }

   @PutMapping("/update/{id}")
   public String updateBank(@PathVariable int id, @RequestBody Bank bank) {
     bank.setId(id);
     bankService.saveBank(bank);
     return "Bank with ID " + id + " is updated";
   }                       
   
   @DeleteMapping("/delete/{id}")
   public String deleteBank(@PathVariable int id) {
     bankService.deleteBank(id);
     return "Bank with ID " + id + " is deleted";
   }
}
