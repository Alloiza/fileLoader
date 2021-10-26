package com.download.files.fileLoader.model.mapping.mapping_tables;

import com.download.files.fileLoader.model.mapping.MappingFields;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomerFields implements MappingFields {

    INN("customer_inn", "inn"),
    NAME("customer_name", "name");

    private String csvColumn;
    private String objectField;
}
