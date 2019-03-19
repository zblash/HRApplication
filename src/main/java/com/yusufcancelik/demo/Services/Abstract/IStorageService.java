package com.yusufcancelik.demo.Services.Abstract;

import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {

    String store(MultipartFile file, String fileName);

    void init();

}
