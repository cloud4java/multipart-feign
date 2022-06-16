//package com.silva.upload2.upload;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.io.IOUtils;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.commons.CommonsFileUploadSupport;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import java.io.*;
//import java.nio.file.Files;
//
//@RestController
//public class UploadController {
//
//    public UploadController(UploadClient client) {
//        this.client = client;
//    }
//
//    private UploadClient client;
//
//    @PostMapping(value = "/upload-cli2")
//    public String handleFileUploadClient(@RequestPart(value = "file") MultipartFile file0) {
//
//        File file1 = new File("/path/to/file");
//        FileItem fileItem = null;
//        try {
//            fileItem = new DiskFileItem("mainFile", Files.probeContentType(file1.toPath()), false, file1.getName(), (int) file1.length(), file1.getParentFile());
//
//            InputStream input = new FileInputStream(file1);
//            OutputStream os = fileItem.getOutputStream();
////            IOUtils.copy(input, os);
//            // Or faster..
//             IOUtils.copy(new FileInputStream(file1), fileItem.getOutputStream());
//        } catch (IOException ex) {
//            // do something.
//        }
//
//        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
////        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
//        System.out.println("file = " + file0);
//
//        return client.fileUpload(new Request1());
//    }
//
////    void outro2(File file) {
////        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",
////                MediaType.TEXT_PLAIN_VALUE, true, file.getName());
////
////        try (InputStream input = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()) {
////            IOUtils.copy(input, os);
////        } catch (Exception e) {
////            throw new IllegalArgumentException("Invalid file: " + e, e);
////        }
////
////        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
////        client.fileUpload(multipartFile);
////    }
//
//}
