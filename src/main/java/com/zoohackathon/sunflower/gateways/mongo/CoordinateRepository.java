package com.zoohackathon.sunflower.gateways.mongo;

import com.zoohackathon.sunflower.domains.ibama.Coordinate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoordinateRepository extends MongoRepository<Coordinate, String> {

}
