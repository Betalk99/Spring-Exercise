package com.bruno.Servizi.File.Upload.services;

import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileStorageService {
    @Value("${fileRepositoryFolder}")
    private String fileRepositoryFolder;

    @SneakyThrows
    public String /**/upload(MultipartFile file) {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFilename = UUID.randomUUID().toString();
        String completeFilename = newFilename + "." + extension;

        File finalFolder = new File(fileRepositoryFolder);

        File finalDestination = new File(fileRepositoryFolder + "\\" + completeFilename);

        file.transferTo(finalDestination);
        return completeFilename;
    }

    @SneakyThrows
    public byte[] download(String nameFile, HttpServletResponse response){
        String extension = FilenameUtils.getExtension(nameFile);
        switch (extension) {
            case "jpg":
            case "jpeg":
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
            case "png":
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
            case "gif":
                response.setContentType(MediaType.IMAGE_GIF_VALUE);
                break;
        }
        response.setHeader("Content-Disposition", "attachment; filename=\""+nameFile+"\"");

        File fileFromRepository = new File(fileRepositoryFolder + "\\" + nameFile);
        return IOUtils.toByteArray(new FileInputStream(fileFromRepository));
    }


    public void delete(String nameFile) {
        File fileFromRepository = new File(fileRepositoryFolder + "\\" + nameFile);
        fileFromRepository.delete();
    }
}
