package com.example.PosSystemMart.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "brands")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private String brandDescription;

}
