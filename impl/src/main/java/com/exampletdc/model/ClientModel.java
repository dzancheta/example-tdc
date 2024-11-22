package com.exampletdc.model;

import com.exampletdc.util.GenderEnum;

import java.time.LocalDate;

public record ClientModel(String name, LocalDate birthDate, GenderEnum gender) {
}