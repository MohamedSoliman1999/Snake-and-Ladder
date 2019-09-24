/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.LevelsPage;

import GameGui.DrawBoard;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import my.NewOrContinueForm.NewOrContinue;
import my.SingleModePage.SingleMode;

/**
 *
 * @author Alaa
 */
public class Level extends javax.swing.JFrame {
    public static DrawBoard Pass;
    public static int choice ;
    public boolean resumeChoice = NewOrContinue.Resume;
    /**
     * Creates new form Level
     */
    public Level() {
        initComponents();
         Toolkit tk = Toolkit.getDefaultToolkit();
         this.setSize(1000,800);
         this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChooseLabel = new javax.swing.JLabel();
        BackBTN = new javax.swing.JButton();
        EasyBTN = new javax.swing.JButton();
        HardBTN = new javax.swing.JButton();
        MediumBTN = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(998, 798));
        getContentPane().setLayout(null);

        ChooseLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/LevelsPage/Choose a level.png"))); // NOI18N
        getContentPane().add(ChooseLabel);
        ChooseLabel.setBounds(160, 80, 410, 90);

        BackBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/LevelsPage/Back button(medium).png"))); // NOI18N
        BackBTN.setBorderPainted(false);
        BackBTN.setContentAreaFilled(false);
        BackBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BackBTN.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BackBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BackBTN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BackBTNMouseMoved(evt);
            }
        });
        BackBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackBTNMouseExited(evt);
            }
        });
        BackBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBTNActionPerformed(evt);
            }
        });
        getContentPane().add(BackBTN);
        BackBTN.setBounds(0, 0, 110, 80);

        EasyBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/LevelsPage/Easy button.png"))); // NOI18N
        EasyBTN.setBorderPainted(false);
        EasyBTN.setContentAreaFilled(false);
        EasyBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EasyBTN.setFocusPainted(false);
        EasyBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EasyBTN.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        EasyBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EasyBTN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                EasyBTNMouseMoved(evt);
            }
        });
        EasyBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EasyBTNMouseExited(evt);
            }
        });
        EasyBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EasyBTNActionPerformed(evt);
            }
        });
        getContentPane().add(EasyBTN);
        EasyBTN.setBounds(300, 360, 170, 100);

        HardBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/LevelsPage/Hard button.png"))); // NOI18N
        HardBTN.setBorderPainted(false);
        HardBTN.setContentAreaFilled(false);
        HardBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HardBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        HardBTN.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        HardBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        HardBTN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                HardBTNMouseMoved(evt);
            }
        });
        HardBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HardBTNMouseExited(evt);
            }
        });
        HardBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HardBTNActionPerformed(evt);
            }
        });
        getContentPane().add(HardBTN);
        HardBTN.setBounds(300, 550, 180, 110);

        MediumBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/LevelsPage/Medium button.png"))); // NOI18N
        MediumBTN.setBorderPainted(false);
        MediumBTN.setContentAreaFilled(false);
        MediumBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MediumBTN.setFocusPainted(false);
        MediumBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MediumBTN.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        MediumBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MediumBTN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MediumBTNMouseMoved(evt);
            }
        });
        MediumBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MediumBTNMouseExited(evt);
            }
        });
        MediumBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MediumBTNActionPerformed(evt);
            }
        });
        getContentPane().add(MediumBTN);
        MediumBTN.setBounds(280, 460, 220, 100);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/LevelsPage/Game Mode Image.jpg"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, -2, 998, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBTNActionPerformed
        new SingleMode().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBTNActionPerformed

    private void BackBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBTNMouseExited
        BackBTN.setIcon(new ImageIcon(getClass().getResource("/my/SingleModePage/Back button(medium).png")));
    }//GEN-LAST:event_BackBTNMouseExited

    private void BackBTNMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBTNMouseMoved
        BackBTN.setIcon(new ImageIcon(getClass().getResource("/my/SingleModePage/Back button.png")));
    }//GEN-LAST:event_BackBTNMouseMoved

    private void EasyBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EasyBTNMouseExited
        EasyBTN.setIcon(new ImageIcon(getClass().getResource("/my/LevelsPage/Easy button.png")));
    }//GEN-LAST:event_EasyBTNMouseExited

    private void EasyBTNMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EasyBTNMouseMoved
        EasyBTN.setIcon(new ImageIcon(getClass().getResource("/my/LevelsPage/Easy button(small).png")));
    }//GEN-LAST:event_EasyBTNMouseMoved

    private void EasyBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EasyBTNActionPerformed
      choice = 1;
       if (GameGui.ReturnGame.HavePuase(SingleMode.name,"Computer")!= "Not Found")
      {
          NewOrContinue me = new NewOrContinue();
          me.setVisible(true);
      }
       else{
      
        Pass = new DrawBoard();
        dispose();
       }
         // TODO add your handling code here:
      
                   
                    
         
     
    }//GEN-LAST:event_EasyBTNActionPerformed

    private void HardBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HardBTNMouseExited
        HardBTN.setIcon(new ImageIcon(getClass().getResource("/my/LevelsPage/Hard button.png")));
    }//GEN-LAST:event_HardBTNMouseExited

    private void HardBTNMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HardBTNMouseMoved
        HardBTN.setIcon(new ImageIcon(getClass().getResource("/my/LevelsPage/Hard button(small).png")));
    }//GEN-LAST:event_HardBTNMouseMoved

    private void MediumBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MediumBTNActionPerformed
      choice = 2;
       if (GameGui.ReturnGame.HavePuase(SingleMode.name,"Computer")!= "Not Found")
      {
          NewOrContinue me = new NewOrContinue();
          me.setVisible(true);
      }
    
     else{
      
        Pass = new DrawBoard();
       }
      
      // TODO add your handling code here:
      
                    
      
    }//GEN-LAST:event_MediumBTNActionPerformed

    private void MediumBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MediumBTNMouseExited
        MediumBTN.setIcon(new ImageIcon(getClass().getResource("/my/LevelsPage/Medium button.png")));
    }//GEN-LAST:event_MediumBTNMouseExited

    private void MediumBTNMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MediumBTNMouseMoved
        MediumBTN.setIcon(new ImageIcon(getClass().getResource("/my/LevelsPage/Medium button(small).png")));
    }//GEN-LAST:event_MediumBTNMouseMoved

    private void HardBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HardBTNActionPerformed
      choice = 3;
       if (GameGui.ReturnGame.HavePuase(SingleMode.name,"Computer")!= "Not Found")
      {
          NewOrContinue me = new NewOrContinue();
          me.setVisible(true);
      }
    
         else{
      
        Pass = new DrawBoard();
       }
        
      
              // TODO add your handling code here:
      
                    
      
      
    }//GEN-LAST:event_HardBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Level().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBTN;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel ChooseLabel;
    private javax.swing.JButton EasyBTN;
    private javax.swing.JButton HardBTN;
    private javax.swing.JButton MediumBTN;
    // End of variables declaration//GEN-END:variables
}