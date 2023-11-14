package com.coders.vehicle.controller;

import com.coders.vehicle.dto.ImageDTO;
import com.coders.vehicle.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            imageService.uploadImage(file);
            return new ResponseEntity<>("Image uploaded successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to upload image: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/upload-byte")
    public ResponseEntity<String> uploadImage(@RequestBody ImageDTO dto) {
        try {
            byte[] imageBytes = Base64.getDecoder().decode((dto.getImageData()));
            imageService.uploadImage(imageBytes);
            return new ResponseEntity<>("Image uploaded successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Test byte");
            return new ResponseEntity<>("Failed to upload image: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/download/{imageId}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable Integer imageId) {
        byte[] imageData = imageService.downloadImage(imageId);
        if (imageData != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imageData);
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<String>> getAllImages() {
        List<String> imageIds = imageService.getAllImages();
        return new ResponseEntity<>(imageIds, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{imageId}")
    public ResponseEntity<String> deleteImage(@PathVariable Integer imageId) {
        try {
            imageService.deleteImage(imageId);
            return new ResponseEntity<>("Image deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete image: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
