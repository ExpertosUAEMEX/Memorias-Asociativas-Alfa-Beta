/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import ABOperations.ABOperations;
import Recovering.Recover;
import java.util.Arrays;

/**
 *
 * @author cachubis
 */
public class Training {

    public static int[][] getTrainingMatrix(int[] pattern) {
        System.out.println("Matriz entrenamiento: ");
        int[][] mtx = new int[pattern.length][pattern.length];
        for (int h = 0; h < pattern.length; h++) {
            for (int i = 0; i < pattern.length; i++) {
                mtx[h][i] = ABOperations.alfa(pattern[h], pattern[i]);
            }
            System.out.println(Arrays.toString(mtx[h]));
        }
        return mtx;
    }

    public static int[][] getMinMtx(int[][][] mtxTrainig) {
        System.out.println("Matriz de mínimos");
        int[][] minMtx = new int[mtxTrainig[0].length][mtxTrainig[0][0].length];
        
        for (int i = 0; i < mtxTrainig[0].length; i++) {
            
            for (int j = 0; j < mtxTrainig[0].length; j++) {
                
                int[] v = new int[mtxTrainig.length];
                for (int n = 0; n < mtxTrainig.length; n++) {
                    v[n] = mtxTrainig[n][i][j];
                }
                
                minMtx[i][j] = ABOperations.min(v);
            }
            System.out.println(Arrays.toString(minMtx[i]));
        }

        return minMtx;
    }
    public static int[][] getMaxMtx(int[][][] mtxTrainig) {
        System.out.println("Matriz de máximos");
        int[][] maxMtx = new int[mtxTrainig[0].length][mtxTrainig[0][0].length];
        
        for (int i = 0; i < mtxTrainig[0].length; i++) {
            
            for (int j = 0; j < mtxTrainig[0].length; j++) {
                
                int[] v = new int[mtxTrainig.length];
                for (int n = 0; n < mtxTrainig.length; n++) {
                    v[n] = mtxTrainig[n][i][j];
                }
                
                maxMtx[i][j] = ABOperations.max(v);
            }
            System.out.println(Arrays.toString(maxMtx[i]));
        }

        return maxMtx;
    }

    public static void main(String[] args) {
        int[] v =  {1,1,1,1,1,1,1,0,0,1,0,0};
        int[] v2 = {1,0,1,1,0,1,1,0,1,1,1,1};
        int[] v3 = {1,0,0,1,0,0,1,1,1,1,1,1};
        int[] v4 = {1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1};
        int[][][] trainingMatrixx = {
            Training.getTrainingMatrix(v),
            Training.getTrainingMatrix(v2),
            Training.getTrainingMatrix(v3)
        //    Training.getTrainingMatrix(v4)};
        };
        int[][] minMat=Training.getMinMtx(trainingMatrixx);
        int[][] maxMat=Training.getMaxMtx(trainingMatrixx);
        
        
        int[] badPattern={1,1,1,1,1,0,1,0,0,0,0,0};
        System.out.println("Bad pattern: "+Arrays.toString(badPattern));
        Recover.recoverGivenMaxMat(maxMat, badPattern);
        Recover.recoverGivenMinMat(minMat, badPattern);
    }
}
