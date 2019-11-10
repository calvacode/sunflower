package com.zoohackathon.sunflower.controllers;

import com.zoohackathon.sunflower.gateways.http.IbamaClient;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/ibama")
@RequiredArgsConstructor
public class IbamaController {

    private final IbamaClient ibamaClient;

    @ApiOperation("Get csv")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get csv")
    })
    @GetMapping
    public void getIbamaCsv() {
//        MultipartFile multipartFile = ibamaClient.downFile();
//        multipartFile.getSize();

    }


    @ApiOperation("Receiving file csv")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get csv")
    })
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadMultipart(@RequestParam("file") MultipartFile file) {
        System.out.println(file);

    }
}