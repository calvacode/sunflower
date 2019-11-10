package com.zoohackathon.sunflower.controllers.json;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Builder
@Getter
@Setter
public class ResponseJson {

    private String nome;

    private List<Animail> rank;

}
