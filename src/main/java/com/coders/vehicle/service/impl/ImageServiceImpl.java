package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.ImageDTO;
import com.coders.vehicle.entity.ImageEntity;
import com.coders.vehicle.repository.ImageRepository;
import com.coders.vehicle.service.ImageService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public String uploadImage(MultipartFile file) {
        try {
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImageData(file.getBytes());
            ImageEntity savedImage = imageRepository.save(imageEntity);
            return savedImage.getId().toString();
        } catch (IOException e) {
            throw new RuntimeException("Can not uploaded photo");
        }
    }

    public String uploadImage(byte[] file) {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImageData(file);
        ImageEntity savedImage = imageRepository.save(imageEntity);
        return savedImage.getId().toString();
    }

    @Override
    public byte[] downloadImage(Integer imageId) {
        ImageEntity entity = imageRepository.findById(imageId).get();
        return entity.getImageData();
//        return imageRepository.findById(imageId)
//                .map(ImageEntity::getImageData)
//                .orElse(null);
    }

    @Override
    public List<String> getAllImages() {
        List<String> imageIds = new ArrayList<>();
        for (ImageEntity imageEntity : imageRepository.findAll()) {
            imageIds.add(imageEntity.getId().toString());
        }
        return imageIds;
    }

    public List<byte[]> getByBytes() {
        List<byte[]> imageIds = new ArrayList<>();
        for (ImageEntity imageEntity : imageRepository.findAll()) {
            imageIds.add(imageEntity.getImageData());
        }
        return imageIds;
    }

    @Override
    public void deleteImage(Integer imageId) {
        imageRepository.deleteById(imageId);
    }

    @Contract("_ -> new")
    public static @NotNull ImageDTO toDto(@NotNull ImageEntity entity) {
        return new ImageDTO(entity.getId(), entity.getImageData().toString());
    }

    @Contract("_ -> new")
    public static @NotNull ImageEntity toEntity(@NotNull ImageDTO dto) {
        return new ImageEntity(dto.getId(), dto.getImageData().getBytes());
    }
}
