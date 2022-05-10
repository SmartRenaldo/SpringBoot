package com.awesome.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book implements Serializable {
    private Integer id;;
    private String type;
    private String name;
    private String description;
}
