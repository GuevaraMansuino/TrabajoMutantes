package com.utn.mutant.controller;

import com.utn.mutant.dto.DnaRequest;
import com.utn.mutant.dto.StatsResponse;
import com.utn.mutant.service.MutantService;
import com.utn.mutant.service.StatsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestController
public class MutantController {

    private final MutantService mutantService;
    private final StatsService statsService;

    public MutantController(MutantService m, StatsService s){
        this.mutantService = m;
        this.statsService = s;
    }

    @PostMapping("/mutant")
    public ResponseEntity<Void> isMutant(@RequestBody DnaRequest req){
        try{
            boolean r = mutantService.isMutantAndSave(req.getDna());
            return r ? ResponseEntity.ok().build() : ResponseEntity.status(403).build();
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<StatsResponse> stats(){
        return ResponseEntity.ok(statsService.getStats());
    }
}