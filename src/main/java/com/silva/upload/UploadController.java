package com.silva.upload;

import feign.Feign;
import feign.Request;
import feign.form.spring.SpringFormEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    public UploadController(UploadClient client) {
        this.client = client;
    }

    private UploadClient client;

    @PostMapping(value = "/upload-cli")
    public String handleFileUploadClient(@RequestPart(value = "file") MultipartFile file) {
        System.out.println("file = " + file);

        return client.fileUpload(new Request1());
    }

    @PutMapping(value = "/upload-cli-hands")
//    public String uploadFileWithManualClient(MultipartFile file) {
    public String uploadFileWithManualClient(@RequestPart MultipartFile file) {

//        UploadClient fileUploadResource = Feign.builder().encoder(new SpringFormEncoder())
//                .target(UploadClient.class, "http://HTTP_FILE_UPLOAD_URL");
        //threw this error:  java.lang.IllegalStateException: Method UploadClient#fileUpload(Request1) not annotated with HTTP method type (ex. GET, POST)
        String response = client.fileUpload(new Request1());

        System.out.println("response = " + response);

        return response;
    }
}
