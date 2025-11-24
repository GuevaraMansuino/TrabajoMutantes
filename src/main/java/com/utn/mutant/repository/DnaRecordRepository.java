package com.utn.mutant.repository;

import com.utn.mutant.model.DnaRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DnaRecordRepository extends JpaRepository<DnaRecord, Long> {
    Optional<DnaRecord> findByDnaHash(String dnaHash);
    long countByMutantTrue();
    long countByMutantFalse();
}
