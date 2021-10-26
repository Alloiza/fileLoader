package com.download.files.fileLoader.model.mapping;

import com.download.files.fileLoader.entity.CustomerEntity;
import com.download.files.fileLoader.entity.LoanEntity;
import com.download.files.fileLoader.entity.Model;
import com.download.files.fileLoader.model.mapping.mapping_tables.CustomerFields;
import com.download.files.fileLoader.model.mapping.mapping_tables.LoanFields;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FilesAndTablesMapping {
    CUSTOMER_FIELDS("customer.csv", CustomerFields.values(), CustomerEntity.class),
    LOAN_FIELDS("loan.csv", LoanFields.values(), LoanEntity.class);

    private String fileName;
    private MappingFields[] mappingFields;
    private Class<? extends Model> modelClass;

    public static MappingFields[] getMappingFieldsByFileName(String fileName) {
        for (FilesAndTablesMapping filesAndTablesMapping: values()) {
            if (filesAndTablesMapping.fileName.equalsIgnoreCase(fileName)) {
                return filesAndTablesMapping.mappingFields;
            }
        }
        throw new IllegalStateException("Для файла с именем " + fileName + " не задана обработка.");
    }

    public static Class<? extends Model> getClassByFileName(String fileName) {
        for (FilesAndTablesMapping filesAndTablesMapping: values()) {
            if (filesAndTablesMapping.fileName.equalsIgnoreCase(fileName)) {
                return filesAndTablesMapping.modelClass;
            }
        }
        throw new IllegalStateException("Для файла с именем " + fileName + " не задана обработка.");
    }
}
