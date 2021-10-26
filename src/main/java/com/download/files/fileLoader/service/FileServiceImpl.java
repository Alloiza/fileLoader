package com.download.files.fileLoader.service;

import com.download.files.fileLoader.entity.CustomerEntity;
import com.download.files.fileLoader.entity.Model;
import com.download.files.fileLoader.model.mapping.FilesAndTablesMapping;
import com.download.files.fileLoader.model.mapping.MappingFields;
import com.download.files.fileLoader.repository.CustomerRepository;
import com.download.files.fileLoader.util.FileUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService{

    private final CustomerRepository customerRepository;

    public void upload(MultipartFile multipartFile) throws IOException {
        Path filePath = Paths.get("target", multipartFile.getOriginalFilename());

        multipartFile.transferTo(filePath);
        File file = filePath.toFile();

        MappingFields[] mappingFields = FilesAndTablesMapping.getMappingFieldsByFileName(file.getName());
        List<Model> list = FileUtil.createObjectsFromCsvFile(
                mappingFields,
                file,
                FilesAndTablesMapping.getClassByFileName(file.getName()));
        list.forEach(entity -> customerRepository.save(entity));
    }

    public List<CustomerEntity> getAll() {
        return customerRepository.findAll();
    }
}
