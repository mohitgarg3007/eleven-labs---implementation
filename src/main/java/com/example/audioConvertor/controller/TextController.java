package com.example.audioConvertor.controller;


import com.example.audioConvertor.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TextController {
    @Autowired
  AudioService audioService;

    @PostMapping("/speak")
    public ResponseEntity<?> speak(@RequestBody Map<String,String> payload){
        String text = payload.get("text");
        byte[] audioBytes = audioService.convertTextToSpeech(text);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.attachment().filename("audio.mp3").build());
        return new ResponseEntity<>(audioBytes, headers, HttpStatus.OK);

    }

}
