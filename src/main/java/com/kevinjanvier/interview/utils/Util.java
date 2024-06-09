package com.kevinjanvier.interview.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinjanvier.interview.data.ResponseData;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

public class Util {
    public static List listFromPost(ObjectMapper objectMapper) throws IOException {
        ClassPathResource resource = new ClassPathResource("data.json");
        return objectMapper.readValue(resource.getInputStream(), ResponseData.class).getNumbers();
    }
}
