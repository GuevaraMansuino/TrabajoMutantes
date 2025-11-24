package com.utn.mutant.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="dna_record")
public class DnaRecord {

 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;

 @Column(name="dna_hash", unique=true, nullable=false)
 private String dnaHash;

 @Column(name="is_mutant", nullable=false)
 private boolean mutant;

 @Column(name="created_at", nullable=false)
 private LocalDateTime createdAt;

 public DnaRecord() {}

 public DnaRecord(String dnaHash, boolean mutant, LocalDateTime createdAt) {
   this.dnaHash = dnaHash;
   this.mutant = mutant;
   this.createdAt = createdAt;
 }

 public Long getId() { return id; }
 public String getDnaHash() { return dnaHash; }
 public boolean isMutant() { return mutant; }
 public LocalDateTime getCreatedAt() { return createdAt; }
 public void setDnaHash(String d) { this.dnaHash = d; }
 public void setMutant(boolean m) { this.mutant = m; }
 public void setCreatedAt(LocalDateTime c) { this.createdAt = c; }
}
