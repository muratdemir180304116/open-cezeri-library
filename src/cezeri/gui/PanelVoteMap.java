/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cezeri.gui;

import cezeri.utils.FactoryNormalization;
import cezeri.utils.FactoryUtils;
import cezeri.types.TVoteMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BAP1
 */
public class PanelVoteMap extends javax.swing.JPanel {

    private List<TVoteMap> vm;
    private String[] fNames;
    private double[] votes;
    private double scale = 1;

    public PanelVoteMap(List<TVoteMap> m) {
        this.vm = m;
        processVoteMap(m);
        repaint();
    }

    public void setMap(List<TVoteMap> m) {
        this.vm = m;
        processVoteMap(m);
        repaint();
    }

    public List<TVoteMap> getMap() {
        return this.vm;
    }

    public void paint(Graphics gr1) {
        Graphics2D gr = (Graphics2D) gr1;
        Font fnt = gr.getFont();
        gr.setFont(new Font(fnt.getFontName(), 1, 18));
        gr.setColor(Color.white);
        int w = getWidth();
        int h = getHeight();
        gr.fillRect(0, 0, w, h);
        gr.setColor(Color.red);
        gr.drawRect(0, 0, w - 1, h - 1);
        gr.drawRect(1, 1, w - 3, h - 3);
        gr.setColor(Color.black);
        int px = 50;
        int py = 50;
        Rectangle rect = new Rectangle(px, py, w - 2*px, h - 2*py);
        drawVoteMap(gr, rect);
    }

    private void drawVoteMap(Graphics2D gr, Rectangle rect) {
        gr.setColor(Color.red);
        int n = fNames.length;
        int ch=rect.height-150;
        int cw = rect.width / n;
        double carp=255.0/maxNorm;
        double[] cl=FactoryUtils.normalizeToCanvas(votes,rect);
        for (int i = 0; i < n; i++) {
            int x = rect.x + i * cw;
            int y = rect.height;
            int color = 255 - (int) (votes[i]*carp);
            gr.setColor(new Color(color, color, color));
            int h = (int) cl[i];
            gr.fillRect(x, y - h, cw, h);
            gr.setColor(Color.red);
            gr.drawRect(x, y - h, cw, h);
            gr.setColor(Color.blue);
            gr.drawString(votes[i] + "", x + 20, y - h-5);
            if (fNames[i].equals("Nem")) {
                fNames[i]="H1";
            }
            gr.drawString(fNames[i], x + 30, rect.height+30);
        }
    }
    
    private void drawVoteMap2(Graphics2D gr, Rectangle rect) {
        gr.setColor(Color.red);
        int n = fNames.length;
        int ch=rect.height-150;
        int cw = rect.width / n;
        double[] cl = FactoryNormalization.normalizeIntensity(votes, 20, 230);
        for (int i = 0; i < n; i++) {
            int x = rect.x + i * cw;
            int y = rect.y + 200;
            gr.setColor(Color.green);
//            int h = (int) cl[i]/3+50;
            int h = (int) cl[i];
            gr.fillRect(x, y - h, cw, h);
            gr.setColor(Color.red);
            gr.drawRect(x, y - h, cw, h);
            int color = 255 - (int) cl[i];
            gr.setColor(new Color(color, color, color));
            gr.fillRect(x, y, cw, ch);
            gr.setColor(Color.red);
            gr.drawRect(x, y, cw, ch);
            gr.setColor(Color.blue);
            gr.drawString(votes[i] + "", x + 20, y - h-5);
            if (fNames[i].equals("Nem")) {
                fNames[i]="H1";
            }
            gr.drawString(fNames[i], x + 20, rect.y+rect.height+10);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public void setScale(double scale) {
        this.scale = scale;
        repaint();
    }

    public double getScale() {
        return scale;
    }
    
    int maxNorm=100;
    
    private void processVoteMap(List<TVoteMap> m) {
        Object[] obj = m.toArray();
        double[] val = new double[obj.length];
        String[] name = new String[obj.length];
        for (int i = 0; i < obj.length; i++) {
            val[i] = ((TVoteMap)obj[i]).value;
            name[i] = ((TVoteMap)obj[i]).name;
        }
        votes = FactoryNormalization.normalizeIntensity(val, 20, maxNorm);
//        votes = val;
        fNames = name;
    }
    
    private void processVoteMap2(Map<String, Double> m) {
        Object[] dd = m.values().toArray();
        double[] d = new double[dd.length];
        for (int i = 0; i < dd.length; i++) {
            d[i] = (double) dd[i];
        }
        votes = d;
        Object[] ss = m.keySet().toArray();
        String[] s = new String[ss.length];
        for (int i = 0; i < dd.length; i++) {
            s[i] = ss[i] + "";
        }
        fNames = s;
    }

}
