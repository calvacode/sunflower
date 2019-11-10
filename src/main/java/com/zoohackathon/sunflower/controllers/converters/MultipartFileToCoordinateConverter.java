package com.zoohackathon.sunflower.controllers.converters;

import com.zoohackathon.sunflower.commons.BrazilGeoStates;
import com.zoohackathon.sunflower.commons.ReadCsvFile;
import com.zoohackathon.sunflower.domains.ibama.Coordinate;
import com.zoohackathon.sunflower.domains.ibama.Specimens;
import com.zoohackathon.sunflower.gateways.mongo.SpecimensRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MultipartFileToCoordinateConverter implements Converter<MultipartFile, List<Coordinate>> {

    private final SpecimensRepository specimensRepository;

    private static final String COMMA = ";";
    private static final int SEQ_AUTO_INFRACAO = 0;
    private static final int LATITUDE = 1;
    private static final int LONGITUDE = 2;

    @Override
    public List<Coordinate> convert(final MultipartFile multipartFile) {
        List<Coordinate> collect = new ArrayList<>();
        try {
            collect = ReadCsvFile.convert(multipartFile.getInputStream())
                    .map(this::buildCoordinate)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return collect;
    }

    private Coordinate buildCoordinate(final String line) {
        final String[] split = line.split(COMMA);
        Specimens specimens = specimensRepository.findFirstByInfractionId(split[SEQ_AUTO_INFRACAO]);
        try {
            specimens.setState(BrazilGeoStates.getState(Double.valueOf(split[LONGITUDE]),
                    Double.valueOf(split[LATITUDE])).name());
        } catch (Exception ex) {

        }


        return Coordinate.builder()
                .infractionId(split[SEQ_AUTO_INFRACAO])
                .longitude(split[LONGITUDE])
                .latitude(split[LATITUDE])
                .build();
    }
}