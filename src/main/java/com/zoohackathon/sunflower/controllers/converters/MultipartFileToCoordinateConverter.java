package com.zoohackathon.sunflower.controllers.converters;

import com.zoohackathon.sunflower.commons.ReadCsvFile;
import com.zoohackathon.sunflower.domains.ibama.Coordinate;
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
        return Coordinate.builder()
                .infractionId(split[SEQ_AUTO_INFRACAO])
                .longitude(Double.valueOf(split[LONGITUDE]))
                .latitude(Double.valueOf(split[LATITUDE]))
                .build();
    }
}
