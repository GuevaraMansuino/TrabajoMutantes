package com.utn.mutant.dto;

public class StatsResponse {
    private long count_mutant_dna;
    private long count_human_dna;
    private double ratio;
    public StatsResponse(long m, long h, double r) {
        this.count_mutant_dna = m;
        this.count_human_dna = h;
        this.ratio = r;
    }
    public long getCount_mutant_dna() { return count_mutant_dna; }
    public long getCount_human_dna() { return count_human_dna; }
    public double getRatio() { return ratio; }
}
