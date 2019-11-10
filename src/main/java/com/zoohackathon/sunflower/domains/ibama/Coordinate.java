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
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String infractionId;

    private double longitude;

    private double latitude;
}
