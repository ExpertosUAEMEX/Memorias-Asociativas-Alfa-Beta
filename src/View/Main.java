/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Recovering.Recover;
import Training.Training;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author cachubis
 */
public class Main extends JFrame {

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private PanelPattern[] pattern;
    private PanelPattern[] badPatterns;
    private PanelPattern[] recoveryPatterns;
    private JButton btn;
    private int[][] origPat, errorPat, recoverPat;

    public Main() {
        setSize(900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        pattern = new PanelPattern[4];
        badPatterns = new PanelPattern[2];
        recoveryPatterns = new PanelPattern[4];
        btn = new JButton("Comenzar");
        for (int i = 0; i < pattern.length; i++) {
            pattern[i] = new PanelPattern(4, 3);
            pattern[i].setBounds(0, (i * 120) + 25, 200, 100);
            add(pattern[i]);
        }
        for (int i = 0; i < badPatterns.length; i++) {
            badPatterns[i] = new PanelPattern(4, 3);
            badPatterns[i].setBounds(250, ((i * 230) + 25), 300, 200);
            add(badPatterns[i]);
        }
        for (int i = 0; i < recoveryPatterns.length; i++) {
            recoveryPatterns[i] = new PanelPattern(4, 3, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
            recoveryPatterns[i].setBounds(650, (i * 120) + 25, 200, 100);
            add(recoveryPatterns[i]);
        }
        l1 = new JLabel("Patrones: ");
        l1.setBounds(25, 5, 150, 25);
        l2 = new JLabel("Patron ruido aditivo: ");
        l2.setBounds(225, 225, 200, 25);
        l3 = new JLabel("Patron ruido substractivo: ");
        l3.setBounds(225, 0, 200, 25);

        btn.setBounds(250, 470, 125, 25);
        btn.addActionListener((ActionEvent e) -> {
            origPat = new int[pattern.length][];
            for(int i=0;i<pattern.length;i++){
                origPat[i] = mapping(pattern[i].getPatternView());
                System.out.println(Arrays.toString(origPat[i]));
            }
            errorPat= new int[badPatterns.length][];
            for(int i=0;i<badPatterns.length;i++){
                errorPat[i]=mapping(badPatterns[i].getPatternView());
                System.out.println(Arrays.toString(errorPat[i]));
            }
            int[][][] trainingMatrixx= new int[origPat.length][origPat[0].length][origPat[0].length];
            for(int i=0;i<trainingMatrixx.length;i++){
                trainingMatrixx[i]=Training.getTrainingMatrix(origPat[i]);
            }
            int[][] minMat=Training.getMinMtx(trainingMatrixx);
            int[][] maxMat=Training.getMaxMtx(trainingMatrixx);
            recoverPat= new int[4][];
        
            recoverPat[0]=Recover.recoverGivenMaxMat(maxMat, errorPat[0]);
            recoverPat[1]=Recover.recoverGivenMinMat(minMat, errorPat[0]);
            recoverPat[2]=Recover.recoverGivenMaxMat(maxMat, errorPat[1]);
            recoverPat[3]=Recover.recoverGivenMinMat(minMat, errorPat[01]);
            
            
            for(int i=0;i<4;i++){
                recoveryPatterns[i]= new PanelPattern(4, 3, recoverPat[i]);
                recoveryPatterns[i].setBounds(650, (i * 120) + 25, 200, 100);
                add(recoveryPatterns[i]);
                                recoveryPatterns[i].updateUI();

            } 
        });
        add(l1);
        add(l2);
        add(l3);
        add(btn);
        
    }

    public static void main(String[] args) {
        Main m = new Main();
    }

    private int[] mapping(JTextField[] pat) {
        int[] ar = new int[pat.length];
        for (int i = 0; i < pat.length; i++) {
            if (pat[i].getText().equals("1")) {
                ar[i] = 1;
            } else {
                ar[i] = 0;
            }
        }
        return ar;
    }
}
