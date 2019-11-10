package com.zoohackathon.sunflower.gateways.mongo;

import com.zoohackathon.sunflower.domains.ibama.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {

}
