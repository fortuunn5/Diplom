package com.example.Diplom.Service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;

@Service
public class PhotoService {
    public Resource loadAsResource(String path) {
        try {
            Path file = Path.of(path);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new RuntimeException(
                        "Could not read file: " + path);
            }
        }
        catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: " + path, e);
        }
    }
}
