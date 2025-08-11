package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fruit", schema = "fsweb")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    private Long id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private Double price;
    @NotNull
    @Column(name = "fruit_type")
    @Enumerated(EnumType.STRING)
    private FruitType fruitType;
}
