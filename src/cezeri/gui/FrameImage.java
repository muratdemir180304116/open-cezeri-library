/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cezeri.gui;

import cezeri.image_processing.ImageProcess;
import cezeri.matrix.CMatrix;
import cezeri.factory.FactoryUtils;
import cezeri.vision.PanelPicture;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import javax.swing.JFrame;

/**
 *
 * @author BAP1
 */
public class FrameImage extends javax.swing.JFrame {

    private BufferedImage img;
    int pw = 180;
    int ph = 180;
    BufferedImage currBufferedImage = null;
    private Vector<String> listImageFile = new Vector<String>();
    int listIndex = 0;
    CMatrix cm=null;

    /**
     * Creates new form FrameImage
     */
    public FrameImage() {
        initComponents();
//        getPicturePanel().setFrame(this);
    }

    /**
     * Draws A Picture Frame
     *
     * @param img : image to be drawn
     * @param title : Caption of the frame
     */
    public FrameImage(CMatrix cm, String title) {
        super(title);
        initComponents();
        this.cm=cm;
        this.img=cm.getImage();
        getPicturePanel().setImage(img);
         getPicturePanel().imageFileName=title;
        this.setSize(img.getWidth() + pw, img.getHeight() + ph);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        getPicturePanel().setFrame(this);
    }
    
    public void setImage(BufferedImage img){
        getPicturePanel().setImage(img);
    }

//    public FrameImage(BufferedImage img) {
//        super("Image");
//        initComponents();
//        getPicturePanel().setImage(img);
//        this.setSize(img.getWidth() + pw, img.getHeight() + ph);
////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        getPicturePanel().setFrame(this);
//    }
//
//    public FrameImage(BufferedImage img,double[][] data) {
//        super("Image");
//        initComponents();
//        getPicturePanel().setImage(img,data);
//        this.setSize(img.getWidth() + pw, img.getHeight() + ph);
////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        getPicturePanel().setFrame(this);
//    }

//    public FrameImage(CMatrix cm) {
//        super(cm.name);
//        initComponents();
//        BufferedImage img = ImageProcess.pixelsToImageGray(cm.toIntArray2D());
//        getPicturePanel().setImage(img);
//        this.setSize(img.getWidth() + pw, img.getHeight() + ph);
////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    public FrameImage(int[][] data) {
//        initComponents();
//        BufferedImage img = ImageProcess.pixelsToImageGray(data);
//        getPicturePanel().setImage(img);
//        this.setSize(img.getWidth() + pw, img.getHeight() + ph);
////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    public FrameImage(String filePath) {
//        super(filePath);
//        initComponents();
//        img = ImageProcess.readImageFromFile(filePath);
//        getPicturePanel().setImage(img);
//        this.setSize(img.getWidth() + pw, img.getHeight() + ph);
////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btn_dataGrid = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        txt_dpi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panelPicture = new cezeri.vision.PanelPicture();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_dataGrid.setText("Data Grid");
        btn_dataGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dataGridActionPerformed(evt);
            }
        });

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        txt_dpi.setText("300");

        jLabel2.setText("dpi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btn_dataGrid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(443, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_dataGrid)
                .addComponent(btn_save)
                .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
        );

        panelPicture.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelPictureLayout = new javax.swing.GroupLayout(panelPicture);
        panelPicture.setLayout(panelPictureLayout);
        panelPictureLayout.setHorizontalGroup(
            panelPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPictureLayout.setVerticalGroup(
            panelPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dataGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dataGridActionPerformed
        CMatrix cm = CMatrix.getInstance(((PanelPicture) panelPicture).getImage());
//        CMatrix cm = CMatrix.getInstance(img);
        new FrameDataGrid(cm).setVisible(true);
    }//GEN-LAST:event_btn_dataGridActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        savePanel();
    }//GEN-LAST:event_btn_saveActionPerformed
    
    public  PanelPicture getPicturePanel() {
        return ((PanelPicture) panelPicture);
    }

    public void savePanel() {
        PanelPicture cp = ((PanelPicture) panelPicture);
        int dpi = Integer.parseInt(txt_dpi.getText());
        double scale = dpi / 96.0;
        cp.setSize((int) (cp.getWidth() * scale), (int) (cp.getHeight() * scale));
        File file = FactoryUtils.getFileFromChooser();
        if (file != null) {
            ImageProcess.saveGridImage(ImageProcess.getBufferedImage(((PanelPicture) panelPicture)), file.getAbsolutePath());
        } else {
            FactoryUtils.showMessage("kaydedilemedi CPlotFrame.savePanel()");
        }
        cp.setSize((int) (cp.getWidth() / scale), (int) (cp.getHeight() / scale));
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrameImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrameImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrameImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrameImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrameImage().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dataGrid;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelPicture;
    private javax.swing.JTextField txt_dpi;
    // End of variables declaration//GEN-END:variables
}
