package com.zoohackathon.sunflower.gateways.mongo;

import com.zoohackathon.sunflower.domains.ibama.Specimens;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpecimensRepository extends MongoRepository<Specimens, String> {

    Specimens findFirstByInfractionId(String infractionId);
}
