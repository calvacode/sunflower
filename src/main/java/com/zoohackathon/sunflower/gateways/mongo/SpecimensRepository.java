package com.zoohackathon.sunflower.gateways.mongo;

import com.zoohackathon.sunflower.domains.ibama.Specimens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecimensRepository extends JpaRepository<Specimens, Long> {

    Specimens findFirstByInfractionId(String infractionId);
}
