package com.utn.mutant.util;

public class MutantDetector {

 private static final int SEQ = 4;

 public static boolean isMutant(String[] dna) {
   validate(dna);
   int n = dna.length;
   char[][] m = new char[n][n];
   for (int i=0;i<n;i++) m[i] = dna[i].toCharArray();

   int found = 0;
   for (int i=0;i<n && found<=1;i++) {
     for (int j=0;j<n && found<=1;j++) {
       char c = m[i][j];
       if (j+SEQ-1<n) {
         boolean ok=true;
         for(int k=1;k<SEQ;k++) if(m[i][j+k]!=c){ok=false;break;}
         if(ok) found++;
       }
       if (i+SEQ-1<n) {
         boolean ok=true;
         for(int k=1;k<SEQ;k++) if(m[i+k][j]!=c){ok=false;break;}
         if(ok) found++;
       }
       if (i+SEQ-1<n && j+SEQ-1<n) {
         boolean ok=true;
         for(int k=1;k<SEQ;k++) if(m[i+k][j+k]!=c){ok=false;break;}
         if(ok) found++;
       }
       if (i-SEQ+1>=0 && j+SEQ-1<n) {
         boolean ok=true;
         for(int k=1;k<SEQ;k++) if(m[i-k][j+k]!=c){ok=false;break;}
         if(ok) found++;
       }
     }
   }
   return found>1;
 }

 private static void validate(String[] dna) {
   if (dna==null) throw new IllegalArgumentException("null");
   int n=dna.length;
   if(n==0) throw new IllegalArgumentException("empty");
   for(String s: dna){
     if(s==null || s.length()!=n) throw new IllegalArgumentException("not square");
     for(char c: s.toCharArray())
       if(c!='A'&&c!='T'&&c!='C'&&c!='G') throw new IllegalArgumentException("invalid");
   }
 }
}
