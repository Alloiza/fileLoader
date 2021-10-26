package com.download.files.fileLoader.util;

import com.download.files.fileLoader.entity.Model;
import com.download.files.fileLoader.model.mapping.MappingFields;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtil {

    public static <T extends Model> List createObjectsFromCsvFile(MappingFields [] mappingFieldsEnum,
                                                          File file,
                                                          Class<T> modelClass) {
        Map<String, String> columnMappings = new HashMap<>();
        Arrays.stream(mappingFieldsEnum).forEach(value ->
                columnMappings.put(value.getCsvColumn(), value.getObjectField()));

        HeaderColumnNameTranslateMappingStrategy<T> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(modelClass);
        strategy.setColumnMapping(columnMappings);

        BufferedReader csvReader = null;
        try {
            csvReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        CsvToBean csvToBean = new CsvToBeanBuilder(csvReader)
                .withSeparator(';')
                .withType(modelClass)
                .withIgnoreEmptyLine(true)
                .withMappingStrategy(strategy).build();
        return csvToBean.parse();
    }
}
