package com.springcommerce.product_service.controller;

import com.springcommerce.product_service.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class MinioController {

    private final MinioService minioService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String bucketName = "springcommerce";
            String originalFilename = file.getOriginalFilename();
            String objectName = UUID.randomUUID() + "-" + originalFilename;

            minioService.uploadFile(
                    bucketName,
                    objectName,
                    file.getInputStream(),
                    file.getContentType()
            );

            // Construct public URL (assumes bucket policy allows it)
            String fileUrl = "http://localhost:9000/" + bucketName + "/" + objectName;

            return ResponseEntity.ok(fileUrl);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/get-url")
    public ResponseEntity<String> getUrl(@RequestParam String path) {
        String url = minioService.getFileUrl(path);
        return ResponseEntity.ok(url);
    }

}
