package com.eazybytes.eazystore.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto{

    @NotBlank(message = "Item name can't be empty")
    private String itemName;

    @NotBlank(message = "Item desc can't be empty")
    private String itemDesc;

    private int categoryId;
}