package com.coders.vehicle.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    String uploadImage(MultipartFile file);
    String uploadImage(byte[] file);

    byte[] downloadImage(Integer imageId);

    List<String> getAllImages();

    void deleteImage(Integer imageId);
}
