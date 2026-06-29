package com.example.PosSystemMart.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Stocks")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StockModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer stockQuantity;
}
