package com.silva.upload;

import org.springframework.web.bind.annotation.*;
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


    @PutMapping(value = "/upload-file")
    public String handleFileUpload(@RequestBody Request1 request) {
        System.out.println("file = " + request ) ;

        return request.getTitle() + " FROM upload-file";
    }
}
