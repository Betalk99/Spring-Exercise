package com.bruno.Servizi.File.Upload.controllers;

import com.bruno.Servizi.File.Upload.services.FileStorageService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    @ResponseBody
    @SneakyThrows
    public String upload(@RequestParam MultipartFile file) {
        return fileStorageService.upload(file);
    }

    @GetMapping("/download")
    @ResponseBody
    @SneakyThrows
    public byte[] download(@RequestParam String filename, HttpServletResponse response) {
        return fileStorageService.download(filename, response);

    }




}
