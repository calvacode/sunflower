package com.zoohackathon.sunflower.gateways.mongo;

import java.util.*;
import com.zoohackathon.sunflower.domains.ibama.Specimens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpecimensRepository extends JpaRepository<Specimens, Long> {

    @Query(value = "SELECT A.*, B.longitude FROM specimens AS A JOIN coordinate AS B ON A.infraction_id = B.infraction_id WHERE NOT types = 'flora'", nativeQuery = true)
    List<Map<String, String>> findsss();

}
