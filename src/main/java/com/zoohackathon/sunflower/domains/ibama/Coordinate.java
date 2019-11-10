package com.zoohackathon.sunflower.domains.ibama;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Coordinate {

    private String infractionId;

    private String longitude;

    private String latitude;
}
