package com.download.files.fileLoader.controller;

import com.download.files.fileLoader.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("file") MultipartFile multipart) throws IOException {
        fileService.upload(multipart);
    }
}
