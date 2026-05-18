package com.eazybytes.eazystore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message ="Item can't be empty")
    private String itemName;
    @NotBlank(message ="Item can't be empty")
    private String itemDesc;



    @ManyToOne
    @JoinColumn(name = "category_id")

    private Category category;
}
