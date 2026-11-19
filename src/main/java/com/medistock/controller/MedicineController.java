
package com.medistock.controller;

import com.medistock.entity.Medicine;
import com.medistock.repository.MedicineRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineRepository medicineRepository;

    public MedicineController(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    // Add a new medicine
    @PostMapping
    public Medicine addMedicine(@Valid @RequestBody Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    // Get all medicines
    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    // Get medicine by ID
    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
        return medicineRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update medicine
    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedicine(
            @PathVariable Long id,
            @Valid @RequestBody Medicine updatedMedicine) {

        return medicineRepository.findById(id)
                .map(medicine -> {
                    medicine.setName(updatedMedicine.getName());
                    medicine.setBatchNumber(updatedMedicine.getBatchNumber());
                    medicine.setPrice(updatedMedicine.getPrice());
                    medicine.setQuantity(updatedMedicine.getQuantity());
                    medicine.setExpiryDate(updatedMedicine.getExpiryDate());

                    return ResponseEntity.ok(medicineRepository.save(medicine));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete medicine
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
        if (!medicineRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        medicineRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Get low-stock medicines (quantity below 10)
    @GetMapping("/low-stock")
    public List<Medicine> getLowStockMedicines() {
        return medicineRepository.findByQuantityLessThan(10);
    }

    // Get expired medicines
    @GetMapping("/expired")
    public List<Medicine> getExpiredMedicines() {
        return medicineRepository.findByExpiryDateBefore(
                java.time.LocalDate.now()
        );
    }

    // Get medicines expiring within the next 30 days
    @GetMapping("/expiring-soon")
    public List<Medicine> getExpiringSoonMedicines() {
        java.time.LocalDate today = java.time.LocalDate.now();

        return medicineRepository.findExpiringSoon(
                today,
                today.plusDays(30)
        );
    }

}

