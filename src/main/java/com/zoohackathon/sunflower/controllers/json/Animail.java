package com.zoohackathon.sunflower.controllers.json;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Animail {

    private String vulgo;

    private String especie;

    private int quantidade;

}
