package com.zoohackathon.sunflower.controllers;

import com.zoohackathon.sunflower.controllers.converters.MultipartFileToCoordinateConverter;
import com.zoohackathon.sunflower.controllers.converters.MultipartFileToSpecimensConverter;
import com.zoohackathon.sunflower.domains.ibama.Coordinate;
import com.zoohackathon.sunflower.domains.ibama.Specimens;
import com.zoohackathon.sunflower.gateways.mongo.CoordinateRepository;
import com.zoohackathon.sunflower.gateways.mongo.SpecimensRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/ibama")
@RequiredArgsConstructor
public class IbamaController {


    private final MultipartFileToSpecimensConverter multipartFileToSpecimensConverter;
    private final MultipartFileToCoordinateConverter multipartFileToCoordinateConverter;

    private final SpecimensRepository specimensRepository;
    private final CoordinateRepository coordinateRepository;

    @ApiOperation("Get csv")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get csv")
    })
    @GetMapping
    public void getIbamaCsv() {
//        MultipartFile multipartFile = ibamaClient.downFile();
//        multipartFile.getSize();

    }


    @ApiOperation("Receiving file csv bioma type")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get csv")
    })
    @PostMapping(value = "/upload-specimens", consumes = "multipart/form-data")
    public void uploadBioma(@RequestParam("file") MultipartFile file) {
        List<Specimens> convert = multipartFileToSpecimensConverter.convert(file);
        if(! Objects.requireNonNull(convert).isEmpty()){
            specimensRepository.saveAll(convert);
        }
    }

    @ApiOperation("Receiving csv file coordinate-type")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get csv")
    })
    @PostMapping(value = "/upload-coordenada", consumes = "multipart/form-data")
    public void uploadCoordenada(@RequestParam("file") MultipartFile file) {
        List<Coordinate> convert = multipartFileToCoordinateConverter.convert(file);
        if(! Objects.requireNonNull(convert).isEmpty()){
            coordinateRepository.saveAll(convert);
        }
    }
}