package com.starlab.microbiome.microbiomdata.model.microbiome.converter;


import com.starlab.microbiome.microbiomdata.model.microbiome.Category;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category attribute) {
        return attribute.getCode();
    }

    @Override
    public Category convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(Category.class).stream()
                .filter(e -> e.getCode().equals(dbData))
                .findAny()
                .orElseThrow( () -> new NoSuchElementException());
    }
}
