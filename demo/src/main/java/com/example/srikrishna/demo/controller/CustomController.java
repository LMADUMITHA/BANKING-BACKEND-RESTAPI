


// package com.example.srikrishna.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.srikrishna.demo.model.Account;
// import com.example.srikrishna.demo.service.CustomService;

// import java.util.List;
// import java.util.Map;

// @RestController
// @RequestMapping("/custom")
// public class CustomController {

//     @Autowired
//     private CustomService customService;

//     @PostMapping("/createEntities")
//     public ResponseEntity<String> createEntities(@RequestBody Map<String, Object> requestData) {
//         customService.createEntities(requestData);
//         return ResponseEntity.ok("Entities created successfully");
//     }

//     @PutMapping("/updateEntity/{id}")
//     public ResponseEntity<String> updateEntity(@PathVariable Long id, @RequestBody Map<String, Object> requestData) {
//         customService.updateEntity(id, requestData);
//         return ResponseEntity.ok("Entity with ID " + id + " updated successfully");
//     }

//     // @DeleteMapping("/deleteEntity/{id}")
//     // public ResponseEntity<String> deleteEntity(@PathVariable int id) {
//     //     customService.deleteEntity(id);
//     //     return ResponseEntity.ok("Entity with ID " + id + " deleted successfully");
//     // }
//     @DeleteMapping("/deleteEntity/{id}")
// public ResponseEntity<String> deleteEntity(@PathVariable Long id) {
//     customService.deleteEntity(id);
//     return ResponseEntity.ok("Entity with ID " + id + " deleted successfully");
// }


//     @GetMapping("/getEntity/{id}")
//     public ResponseEntity<?> getEntity(@PathVariable Long id) {
//         Object entity = customService.getEntity(id);
//         if (entity != null) {
//             return ResponseEntity.ok(entity);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @GetMapping("/getAllEntities")
// public ResponseEntity<List<Account>> getAllEntities() {
//     List<Account> entities = customService.getAllEntities(); // Assuming customService has a method to retrieve all entities
//     if (entities.isEmpty()) {
//         return ResponseEntity.noContent().build(); // Return 204 No Content if no entities found
//     } else {
//         return ResponseEntity.ok(entities); // Return 200 OK with the list of entities
//     }
// }

// @GetMapping("/getAllEntities")
//     public ResponseEntity<Page<Account>> getAllEntities(
//             @RequestParam(defaultValue = "0") int page,
//             @RequestParam(defaultValue = "10") int size,
//             @RequestParam(defaultValue = "id") String sortBy) {
        
//         Page<Account> entities = customService.getAllEntities(page, size, sortBy);
//         return ResponseEntity.ok(entities);
//     }

// }


package com.example.srikrishna.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page; // Import Page class
import com.example.srikrishna.demo.model.Account;
import com.example.srikrishna.demo.service.CustomService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    private CustomService customService;

    @PostMapping("/createEntities")
    public ResponseEntity<String> createEntities(@RequestBody Map<String, Object> requestData) {
        customService.createEntities(requestData);
        return ResponseEntity.ok("Entities created successfully");
    }

    @PutMapping("/updateEntity/{id}")
    public ResponseEntity<String> updateEntity(@PathVariable Long id, @RequestBody Map<String, Object> requestData) {
        customService.updateEntity(id, requestData);
        return ResponseEntity.ok("Entity with ID " + id + " updated successfully");
    }

    @DeleteMapping("/deleteEntity/{id}")
    public ResponseEntity<String> deleteEntity(@PathVariable Long id) {
        customService.deleteEntity(id);
        return ResponseEntity.ok("Entity with ID " + id + " deleted successfully");
    }

    @GetMapping("/getEntity/{id}")
    public ResponseEntity<?> getEntity(@PathVariable Long id) {
        Object entity = customService.getEntity(id);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAllEntities")
    public ResponseEntity<Page<Account>> getAllEntities(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        
        Page<Account> entities = customService.getAllEntities(page, size, sortBy);
        return ResponseEntity.ok(entities);
    }


    @GetMapping("/accountsByBalanceRange")
    public ResponseEntity<List<Account>> getAccountsByBalanceRange(
            @RequestParam double minBalance,
            @RequestParam double maxBalance) {
        
        List<Account> accounts = customService.findAccountsByBalanceRange(minBalance, maxBalance);
        if (accounts.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(accounts);
        }
    }
}
