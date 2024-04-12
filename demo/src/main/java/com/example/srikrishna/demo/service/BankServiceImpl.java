

// import com.example.srikrishna.demo.model.Bank;
// import com.example.srikrishna.demo.repository.BankRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class BankServiceImpl implements BankService {

//     private final BankRepository bankRepository;

//     @Autowired
//     public BankServiceImpl(BankRepository bankRepository) {
//         this.bankRepository = bankRepository;
//     }

//     @Override
//     public Bank saveBank(Bank bank) {
//         return bankRepository.save(bank);
//     }

//     @Override
//     public List<Bank> getAllBanks() {
//         return bankRepository.findAll();
//     }

//     @Override
//     public void deleteBank(int id) {
//         bankRepository.deleteById(id);
//     }

//     @Override
//     public Bank getBankById(int id) {
//         Optional<Bank> optionalBank = bankRepository.findById(id);
//         return optionalBank.orElse(null);
//     }
// }


// package com.example.srikrishna.demo.service;

// import com.example.srikrishna.demo.model.Bank;
// import com.example.srikrishna.demo.repository.BankRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class BankServiceImpl implements BankService {

//     private final BankRepository bankRepository;

//     @Autowired
//     public BankServiceImpl(BankRepository bankRepository) {
//         this.bankRepository = bankRepository;
//     }

//     @Override
//     public Bank saveBank(Bank bank) {
//         return bankRepository.save(bank);
//     }

//     @Override
//     public List<Bank> getAllBanks() {
//         return bankRepository.findAll();
//     }

//     @Override
//     public void deleteBank(int id) {
//         bankRepository.deleteById(id);
//     }

//     @Override
//     public Bank getBankById(int id) {
//         Optional<Bank> optionalBank = bankRepository.findById(id);
//         return optionalBank.orElse(null);
//     }
// }

package com.example.srikrishna.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.srikrishna.demo.model.Bank;
import com.example.srikrishna.demo.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank saveBank(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Page<Bank> getAllBanks(Pageable pageable) {
        return bankRepository.findAll(pageable);
    }

    @Override
    public void deleteBank(int id) {
        bankRepository.deleteById(id);
    }

    @Override
    public Bank getBankById(int id) {
        return bankRepository.findById(id).orElse(null);
    }
}
