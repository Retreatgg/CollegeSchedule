package com.example.collegeschedule.controller;

import com.example.collegeschedule.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {
    private final FileUtil fileUtil;

    @GetMapping("{name}")
    public ResponseEntity<?> getFileByName(@PathVariable String name) {
        return fileUtil.getOutputFile(name);
    }
}
