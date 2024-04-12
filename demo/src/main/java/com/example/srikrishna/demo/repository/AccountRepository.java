package com.example.srikrishna.demo.repository;




// import java.util.List;
// import java.util.Optional;

// import org.hibernate.query.Page;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

// import java.lang.Long;
// import java.util.Optional;

// import com.example.srikrishna.demo.model.Account;
// import org.springframework.data.jpa.repository.JpaRepository;


// public interface AccountRepository extends JpaRepository<Account, Integer> {
//     // void deleteById(Long id);
//     // void deleteById(Long id);
//     Optional<Account> findById(Long id);
// }


// import java.util.Optional;
// import com.example.srikrishna.demo.model.Account;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface AccountRepository extends JpaRepository<Account, Long> {
//     Optional<Account> findById(int id);
// }


// import org.springframework.data.repository.PagingAndSortingRepository;

// import com.example.srikrishna.demo.model.Account;

// public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

//     Optional<Account> findById(Long id);
//     // Your custom repository methods

//     List<Account> findAll();

//     void deleteById(Long id);

//     void save(Account account);

//     Page findAll(Pageable pageable);
// }


// import org.springframework.data.repository.PagingAndSortingRepository;

// import com.example.srikrishna.demo.model.Account;

// public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

//     Optional<Account> findById(Long id);

//     List<Account> findAll();

//     void deleteById(Long id);

//     Page<Account> findAll(Pageable pageable);
// }


// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.repository.PagingAndSortingRepository;

// import com.example.srikrishna.demo.model.Account;

// import java.util.List;
// import java.util.Optional;

// public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

//     Optional<Account> findById(Long id);

//     List<Account> findAll();

//     void deleteById(Long id);

//     Page<Account> findAll(Pageable pageable);
// }



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.srikrishna.demo.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    Optional<Account> findById(Long id);
    
    List<Account> findAll();
    
    void deleteById(Long id);
    
    Page<Account> findAll(Pageable pageable);

    Account save(Account account);


    @Query("SELECT a FROM Account a WHERE a.balance >= :minBalance AND a.balance <= :maxBalance")
    List<Account> findAccountsByBalanceRange(@Param("minBalance") double minBalance, @Param("maxBalance") double maxBalance);
}

