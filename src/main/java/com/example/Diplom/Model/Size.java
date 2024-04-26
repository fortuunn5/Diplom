package com.example.Diplom.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Size {
    XS ("XS"),
    S ("S"),
    M ("M"),
    L ("L"),
    XL ("XL");
    private final String size;
}
