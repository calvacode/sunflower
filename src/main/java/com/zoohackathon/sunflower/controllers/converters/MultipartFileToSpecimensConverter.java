package com.zoohackathon.sunflower.controllers.converters;

import com.zoohackathon.sunflower.commons.ReadCsvFile;
import com.zoohackathon.sunflower.domains.ibama.Specimens;
import com.zoohackathon.sunflower.gateways.mongo.CoordinateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.zoohackathon.sunflower.commons.NormalizeData.normalize;

@Component
@RequiredArgsConstructor
public class MultipartFileToSpecimensConverter implements Converter<MultipartFile, List<Specimens>> {

    private final CoordinateRepository coordinateRepository;

    private static final String COMMA = ";";
    private static final int SEQ_AUTO_INFRACAO = 0;
    private static final int QUANTIDADE = 1;
    private static final int UNIDADE = 2;
    private static final int TIPO = 3;
    private static final int GRUPO = 4;
    private static final int NOME_POPULAR = 5;
    private static final int NOME_CIENTIFICO = 6;
    private static final int CITES = 7;
    private static final int DESCRICAO = 8;
    private static final int CARACTERISTICA = 9;
    private static final int SITUACAO = 10;

    @Override
    public List<Specimens> convert(final MultipartFile multipartFile) {
        List<Specimens> collect = new ArrayList<>();
        try {
            collect = ReadCsvFile.convert(multipartFile.getInputStream())
                    .map(this::buildSpecimens)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return collect;
    }

    private Specimens buildSpecimens(final String line) {
        final String[] split = line.split(COMMA);
        return Specimens.builder()
                .infractionId(split[SEQ_AUTO_INFRACAO])
                .quantity(normalize(split[QUANTIDADE]))
                .unity(normalize(split[UNIDADE]))
                .types(normalize(split[TIPO]))
                .groupo(normalize(split[GRUPO]))
                .popularName(normalize(split[NOME_POPULAR]))
                .scientificName(normalize(split[NOME_CIENTIFICO]))
                .cites(normalize(split[CITES]))
                .description(normalize(split[DESCRICAO]))
                .characteristicsT(normalize(split[CARACTERISTICA]))
                .situation(normalize(split[SITUACAO]))
                .build();
    }
}
