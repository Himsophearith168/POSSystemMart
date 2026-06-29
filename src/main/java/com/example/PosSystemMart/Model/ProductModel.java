package com.example.PosSystemMart.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String productName;
    private String productDescription;
    @Column(length = 100, nullable = false, unique = true)
    private Integer barcode;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private String productImage;
    @Column(nullable = false, unique = true)
    private Integer categoryId;
    @Column(nullable = false, unique = true)
    private Integer stockId;
    @Column(nullable = false, unique = true)
    private Integer brandId;

}
