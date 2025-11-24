package com.utn.mutant.service;

import com.utn.mutant.repository.DnaRecordRepository;
import com.utn.mutant.dto.StatsResponse;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
 private final DnaRecordRepository repo;
 public StatsService(DnaRecordRepository repo){
   this.repo = repo;
 }
 public StatsResponse getStats(){
   long m = repo.countByMutantTrue();
   long h = repo.countByMutantFalse();
   double r = h>0 ? (double)m/h : (m>0? m:0);
   return new StatsResponse(m,h,r);
 }
}
