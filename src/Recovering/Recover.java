/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recovering;

import ABOperations.ABOperations;
import java.util.Arrays;

/**
 *
 * @author cachubis
 */
public class Recover {
    public static int[] recoverGivenMaxMat(int[][] maxMat, int[] badPattern){
        int[][] recoverMtx= new int[maxMat.length][maxMat.length];
        System.out.println("Matriz Recuperación dada matriz maximos ");
        for(int i=0;i<maxMat.length;i++){
            for( int j=0;j<maxMat.length;j++){
                recoverMtx[i][j] = ABOperations.beta(maxMat[i][j],badPattern[j]);
            }
            System.out.println(Arrays.toString(recoverMtx[i]));
        }
        int[] v = new int[maxMat.length];
        for(int i=0;i<recoverMtx.length;i++){
            v[i]=ABOperations.min(recoverMtx[i]);
        }
        System.out.println("Patron recuperado: "+ Arrays.toString(v));
        
        return v;
    }
    public static int[] recoverGivenMinMat(int[][] minMat, int[] badPattern){
        int[][] recoverMtx= new int[minMat.length][minMat.length];
        System.out.println("Matriz Recuperación dada matriz minimos ");
        for(int i=0;i<minMat.length;i++){
            for( int j=0;j<minMat.length;j++){
                recoverMtx[i][j] = ABOperations.beta(minMat[i][j],badPattern[j]);
            }
            System.out.println(Arrays.toString(recoverMtx[i]));
        }
        int[] v = new int[minMat.length];
        for(int i=0;i<recoverMtx.length;i++){
            v[i]=ABOperations.max(recoverMtx[i]);
        }
        System.out.println("Patron recuperado: "+ Arrays.toString(v));
        
        return v;
    }
}
