package com.medistock.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

    @Entity
    @Table(name = "medicines")
    public class Medicine {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Medicine name is required")
        private String name;

        @NotBlank(message = "Batch number is required")
        @Column(unique = true)
        private String batchNumber;

        @NotNull(message = "Price is required")
        @Positive(message = "Price must be greater than zero")
        private Double price;

        @NotNull(message = "Quantity is required")
        @Min(value = 0, message = "Quantity cannot be negative")
        private Integer quantity;

        @NotNull(message = "Expiry date is required")
        private LocalDate expiryDate;

        public Medicine() {
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBatchNumber() {
            return batchNumber;
        }

        public void setBatchNumber(String batchNumber) {
            this.batchNumber = batchNumber;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
        }
    }


