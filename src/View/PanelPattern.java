package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools  Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cachubis
 */
public class PanelPattern extends JPanel {

    private final int row;
    private final int column;
    private GridLayout grid;
    private JTextField patternView[];
    private JTextField recoverView[];
    private int[]recoverPattern;
   
    public PanelPattern(int row, int column,int[] recoverPatern){
        this.column=column;
        this.row=row;
        this.recoverPattern=recoverPatern;
        grid= new GridLayout(row, column);
        setLayout(grid);
        initComponentsV2();
        repaint();
    }
    public PanelPattern(int row, int column) {
        this.row = row;
        this.column = column;
        grid = new GridLayout(this.row, this.column);
        setLayout(grid);
        initComponents();
        repaint();
    }
    private void initComponents() {
        patternView = new JTextField[column * row];
        for (int i = 0; i < patternView.length; i++) {
            patternView[i] = new JTextField("0");
            patternView[i].setHorizontalAlignment(JTextField.CENTER);
            patternView[i].setBackground(Color.BLACK);
            patternView[i].setForeground(Color.WHITE);
            patternView[i].addMouseListener(new MyAdapter(patternView[i]));
            patternView[i].setEditable(false);
            add(patternView[i]);
        }
    }

    private void initComponentsV2() {
        recoverView = new JTextField[recoverPattern.length];
        for(int i=0;i<recoverView.length;i++){
            recoverView[i] = new JTextField(""+recoverPattern[i]);
            if(recoverPattern[i]==0){
                recoverView[i].setHorizontalAlignment(JTextField.CENTER);
                recoverView[i].setBackground(Color.BLACK);
                recoverView[i].setForeground(Color.WHITE);
                recoverView[i].setEditable(false);
                add(recoverView[i]);
               
            }else{
                recoverView[i].setBackground(Color.GREEN);
                recoverView[i].setForeground(Color.DARK_GRAY);
                recoverView[i].setText(""+recoverPattern[i]);
                recoverView[i].setEditable(false);
                add(recoverView[i]);
            }
        }
    }

    public JTextField[] getPatternView() {
        return patternView;
    }

    public JTextField[] getRecoverView() {
        return recoverView;
    }
    
    private static class MyAdapter implements MouseListener {

        JTextField tx;

        public MyAdapter(JTextField tx) {
            this.tx = tx;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (tx.getText().equals("0")) {
                tx.setBackground(Color.GREEN);
                tx.setForeground(Color.DARK_GRAY);
                tx.setText("1");
            } else {
                tx.setText("0");
                tx.setBackground(Color.BLACK);
                tx.setForeground(Color.WHITE);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (tx.getText().equals("0")) {
                tx.setBackground(Color.GREEN);
                tx.setForeground(Color.DARK_GRAY);
                tx.setText("1");
            } else {
                tx.setText("0");
                tx.setBackground(Color.BLACK);
                tx.setForeground(Color.WHITE);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           if(tx.getText().equals("0")){
                tx.setBackground(Color.GREEN);
                tx.setForeground(Color.DARK_GRAY);
                tx.setText("1");
            }else{
               tx.setText("0");
               tx.setBackground(Color.BLACK);
               tx.setForeground(Color.WHITE);
            } 
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

      
    }

}
