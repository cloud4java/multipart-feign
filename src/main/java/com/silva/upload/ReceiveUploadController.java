package com.silva.upload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ReceiveUploadController {

    @PostMapping(value = "/upload-file")
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        System.out.println("file = " + file);
        System.out.println("file = " + file);
        System.out.println("file = " + file);
        System.out.println("file = " + file);

        return file.getOriginalFilename()+" FROM upload-file";
    }

}
