package com.utn.mutant.service;

import com.utn.mutant.repository.DnaRecordRepository;
import com.utn.mutant.model.DnaRecord;
import com.utn.mutant.util.MutantDetector;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Service
public class MutantService {

 private final DnaRecordRepository repo;

 public MutantService(DnaRecordRepository repo){
   this.repo = repo;
 }

 public boolean isMutantAndSave(String[] dna){
   String hash = hashDna(dna);
   return repo.findByDnaHash(hash)
     .map(r -> r.isMutant())
     .orElseGet(() -> {
       boolean m = MutantDetector.isMutant(dna);
       repo.save(new DnaRecord(hash,m,LocalDateTime.now()));
       return m;
     });
 }

 public String hashDna(String[] dna){
   try{
     MessageDigest md = MessageDigest.getInstance("SHA-256");
     for(String s: dna){
       md.update(s.getBytes(StandardCharsets.UTF_8));
       md.update((byte)'|');
     }
     return Base64.getEncoder().encodeToString(md.digest());
   }catch(Exception e){
     throw new RuntimeException(e);
   }
 }
}
