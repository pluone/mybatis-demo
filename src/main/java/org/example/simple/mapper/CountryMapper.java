package org.example.simple.mapper;

import org.example.simple.model.Country;

import java.util.List;

public interface CountryMapper {
    List<Country> selectAll();
}
