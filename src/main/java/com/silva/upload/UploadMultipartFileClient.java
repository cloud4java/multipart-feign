package com.silva.upload;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

//https://jsonplaceholder.typicode.com/todos/1
@FeignClient(name = "uploadfileclient", url = "http://localhost:8080"/*, configuration = UploadMultipartFileClient.FeignSupportConfigInternal.class*/)
public interface UploadMultipartFileClient {

    @PostMapping(value = "/upload-file")
    String fileUpload(@RequestPart MultipartFile file);

    public class FeignSupportConfigInternal {
        @Bean
        public Encoder multipartFormEncoder() {
            return new SpringFormEncoder(new SpringEncoder(new ObjectFactory<HttpMessageConverters>() {
                @Override
                public HttpMessageConverters getObject() throws BeansException {
                    return new HttpMessageConverters(new RestTemplate().getMessageConverters());
                }
            }));
        }
    }
}

