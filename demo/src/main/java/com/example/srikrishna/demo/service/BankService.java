



// package com.example.srikrishna.demo.service;

// import java.util.List;

// import com.example.srikrishna.demo.model.Bank;

// public interface BankService {
//    public Bank saveBank(Bank bank);
//    public List<Bank> getAllBanks();
//    public void deleteBank(int id);
//    public Bank getBankById(int id);
// }

package com.example.srikrishna.demo.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.srikrishna.demo.model.Bank;

public interface BankService {
   public Bank saveBank(Bank bank);
   public Page<Bank> getAllBanks(Pageable pageable);
   public void deleteBank(int id);
   public Bank getBankById(int id);
}

