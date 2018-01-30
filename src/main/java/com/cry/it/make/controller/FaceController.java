package com.cry.it.make.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class FaceController {

    @GetMapping("/face")
    public String face(Map<String, Object> model) {
        model.put("face", "smile");
        return "face";
    }
}
