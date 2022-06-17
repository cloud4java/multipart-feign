package com.silva.upload;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
public class UploadController {
    @Autowired
    private UploadClient client;

//    @PostMapping(value = "/upload-file")
//    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
//        return file.getOriginalFilename();
//    }


    @PostMapping(value = "/upload-cli")
    public String handleFileUploadClient(@RequestPart(value = "file") MultipartFile file) {

        client.fileUpload(file);

        return file.getOriginalFilename();
    }
    @PostMapping(value = "/upload-cli-create")
    public String handleFileUploadClient2(@RequestPart(value = "file") MultipartFile file) {
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file1",
                MediaType.TEXT_PLAIN_VALUE, true, "file1" /*file.getName()*/);

        try (/*InputStream input = new FileInputStream(file);*/ OutputStream os = fileItem.getOutputStream()) {
            FileInputStream input = (FileInputStream) file.getInputStream();
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }
        fileItem.setFieldName("file1");
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);

        client.fileUpload(multipartFile);

        return file.getOriginalFilename();
    }
}
