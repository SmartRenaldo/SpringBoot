package com.awesome.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yiqi Li
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String name;
    private int id;
}
