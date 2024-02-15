package com.bruno.Servizi.File.Upload.dto;

import com.bruno.Servizi.File.Upload.entities.User;
import lombok.Data;

@Data
public class DownloadProfilePictureDTO {

    private User user;
    private byte[] photo;


}
