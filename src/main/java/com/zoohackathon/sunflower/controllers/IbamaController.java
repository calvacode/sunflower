package com.zoohackathon.sunflower.controllers;

import com.zoohackathon.sunflower.commons.BrazilGeoStates;
import com.zoohackathon.sunflower.controllers.converters.MultipartFileToCoordinateConverter;
import com.zoohackathon.sunflower.controllers.converters.MultipartFileToSpecimensConverter;
import com.zoohackathon.sunflower.controllers.json.Animail;
import com.zoohackathon.sunflower.controllers.json.ResponseJson;
import com.zoohackathon.sunflower.domains.ibama.Coordinate;
import com.zoohackathon.sunflower.domains.ibama.Specimens;
import com.zoohackathon.sunflower.gateways.mongo.CoordinateRepository;
import com.zoohackathon.sunflower.gateways.mongo.SpecimensRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
            @ApiResponse(code = 200, message = "Get infos")
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ResponseJson> getDataInfo() {
        List<Map<String, String>> findsss = specimensRepository.findsss();
        return findsss.stream().map(stringStringMap -> {

            Integer quantity = 1;
            Double longitude = 1.0;
            try{
                quantity = Integer.valueOf(stringStringMap.get("quantity"));
                longitude = Double.valueOf(stringStringMap.get("longitude"));

            } catch (Exception ex){

            }

            Animail build = Animail.builder()
                    .especie(stringStringMap.get("scientific_name"))
                    .quantidade(quantity)
                    .vulgo(stringStringMap.get("popular_name"))
                    .build();


            return ResponseJson.builder()
                    .nome(BrazilGeoStates.getState(longitude, 11.00).name())
                    .rank(Collections.singletonList(build))
                    .build();

        }).collect(Collectors.toList());

    }

    @ApiOperation("Receiving file csv bioma type")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get csv")
    })
    @PostMapping(value = "/upload-specimens", consumes = "multipart/form-data")
    @Async
    public void uploadBioma(@RequestParam("file") MultipartFile file) {
        List<Specimens> convert = multipartFileToSpecimensConverter.convert(file);
        if(! Objects.requireNonNull(convert).isEmpty()){
            convert.forEach(specimensRepository::save);
        }
    }

    @ApiOperation("Receiving csv file coordinate-type")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get csv")
    })
    @PostMapping(value = "/upload-coordenada", consumes = "multipart/form-data")
    @Async
    public void uploadCoordenada(@RequestParam("file") MultipartFile file) {
        List<Coordinate> convert = multipartFileToCoordinateConverter.convert(file);
        if(! Objects.requireNonNull(convert).isEmpty()){
            convert.forEach(coordinateRepository::save);
        }
    }
}