package com.zoohackathon.sunflower.domains.ibama;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Specimens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String infractionId;

    private String quantity;

    private String unity;

    private String types;

    private String groupo;

    private String popularName;

    private String scientificName;

    private String cites;

    private String description;

    private String characteristicsT;

    private String situation;

    private String region;

    private String state;

}
