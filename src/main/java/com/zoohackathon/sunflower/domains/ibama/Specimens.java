package com.zoohackathon.sunflower.domains.ibama;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Specimens {

    private String infractionId;

    private String quantity;

    private String unity;

    private String type;

    private String group;

    private String popularName;

    private String scientificName;

    private String cites;

    private String description;

    private String characteristics;

    private String situation;

    private String region;

    private String state;

}
