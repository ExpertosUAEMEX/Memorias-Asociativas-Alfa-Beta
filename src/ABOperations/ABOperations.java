/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABOperations;

import java.util.Arrays;

/**
 *
 * @author cachubis
 */
public class ABOperations {
    public static int alfa(int x, int y){
        int response=-1; 
        if(x==0&&y==0){response= 1;}
        else if(x==0&&y==1){response= 0;}
        else if(x==1&&y==0){response= 2;}
        else if(x==1&&y==1){response= 1;}
        return response;
    }
    public static int beta(int x, int y){
        int response =-1;
        if     (x==0&&y==0){response= 0;}
        else if(x==0&&y==1){response= 0;}
        else if(x==1&&y==0){response= 0;}
        else if(x==1&&y==1){response= 1;}
        else if(x==2&&y==0){response= 1;}
        else if(x==2&&y==1){response= 1;}
        return response;
    }
    public static int min(int[] v) {
        int[] ux =v;
        Arrays.sort(ux);
        return v[0];
    }

    public static int max(int[] v) {
        int[] ux=v;
        Arrays.sort(ux);
        return ux[ux.length-1];
    }
}
