package ru.maxima.finalproject.model;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Data;

@Data
@JsonAppend
public class BooleanRequest {

    public boolean blocked;
}
