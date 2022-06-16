package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {


    private long id;

    private String name;

    private BigDecimal price;

    private String img_url;

    private int quantity;

    private boolean status;

    private CategoryDTO categoryDTO;
}
