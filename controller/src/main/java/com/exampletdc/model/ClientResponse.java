package com.exampletdc.model;

import com.exampletdc.util.GenderEnum;

import java.time.LocalDate;

public record ClientResponse(String name, LocalDate brithDate, GenderEnum gender) {
}
