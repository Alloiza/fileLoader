package com.download.files.fileLoader.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    void upload(MultipartFile file) throws IOException;
}
