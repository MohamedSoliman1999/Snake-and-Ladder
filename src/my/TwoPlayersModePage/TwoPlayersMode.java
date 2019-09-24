/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.TwoPlayersModePage;

import GameGui.DrawBoard;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import my.NewOrContinueForm.NewOrContinue;
import my.SingleModePage.SingleMode;
import my.StartPage.StartPage;

/**
 *
 * @author Alaa
 */
public class TwoPlayersMode extends javax.swing.JFrame {

    /**
     * Creates new form TwoPlayersMode
     */
    public static boolean twoPlayersMode;
    public static boolean whichColor;
    public static String name1,name2;
    public static DrawBoard Pass;
    public TwoPlayersMode() {
        this.setUndecorated(true); //removes the title bar
        this.setAlwaysOnTop(true); //this interface is always on top
        this.setResizable(false);
        this.setVisible(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
         this.setSize(1000,800);
        this.setLocationRelativeTo(null);
        whichColor = false;
        twoPlayersMode = true;
        SingleMode.singleMode = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ColorBG = new javax.swing.ButtonGroup();
        BackBTN = new javax.swing.JButton();
        NamesColorsLabel = new javax.swing.JLabel();
        Player1NameField = new javax.swing.JTextField();
        Player2NameField = new javax.swing.JTextField();
        TwoPlayersModeLabel = new javax.swing.JLabel();
        BlueChoice = new javax.swing.JRadioButton();
        RedChoice = new javax.swing.JRadioButton();
        BlueFigure = new javax.swing.JLabel();
        RedFigure = new javax.swing.JLabel();
        PlayBTN = new javax.swing.JButton();
        BackgroundPhoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        BackBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/TwoPlayersModePage/Back button(medium).png"))); // NOI18N
        BackBTN.setBorderPainted(false);
        BackBTN.setContentAreaFilled(false);
        BackBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackBTN.setFocusPainted(false);
        BackBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BackBTN.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BackBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BackBTN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BackBTNMouseMoved(evt);
            }
        });
        BackBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackBTNMouseEntered(evt);
            }
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
        BackBTN.setBounds(-10, 0, 128, 84);

        NamesColorsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/TwoPlayersModePage/Names & colors.png"))); // NOI18N
        getContentPane().add(NamesColorsLabel);
        NamesColorsLabel.setBounds(180, 360, 420, 80);

        Player1NameField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Player1NameField.setForeground(new java.awt.Color(154, 97, 36));
        Player1NameField.setText("Player 1");
        Player1NameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Player1NameFieldMouseClicked(evt);
            }
        });
        Player1NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player1NameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(Player1NameField);
        Player1NameField.setBounds(360, 450, 270, 50);

        Player2NameField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Player2NameField.setForeground(new java.awt.Color(154, 97, 36));
        Player2NameField.setText("Player 2");
        Player2NameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Player2NameFieldMouseClicked(evt);
            }
        });
        getContentPane().add(Player2NameField);
        Player2NameField.setBounds(360, 540, 270, 50);

        TwoPlayersModeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/TwoPlayersModePage/Two Players Mode.png"))); // NOI18N
        getContentPane().add(TwoPlayersModeLabel);
        TwoPlayersModeLabel.setBounds(150, 80, 600, 90);

        ColorBG.add(BlueChoice);
        BlueChoice.setContentAreaFilled(false);
        BlueChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlueChoiceActionPerformed(evt);
            }
        });
        getContentPane().add(BlueChoice);
        BlueChoice.setBounds(270, 470, 93, 23);

        ColorBG.add(RedChoice);
        RedChoice.setContentAreaFilled(false);
        RedChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedChoiceActionPerformed(evt);
            }
        });
        getContentPane().add(RedChoice);
        RedChoice.setBounds(270, 560, 21, 21);

        BlueFigure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/TwoPlayersModePage/Blue Figure.png"))); // NOI18N
        getContentPane().add(BlueFigure);
        BlueFigure.setBounds(200, 440, 50, 80);

        RedFigure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/TwoPlayersModePage/Red Figure.png"))); // NOI18N
        getContentPane().add(RedFigure);
        RedFigure.setBounds(200, 530, 50, 80);

        PlayBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/TwoPlayersModePage/Play button(medium).png"))); // NOI18N
        PlayBTN.setBorderPainted(false);
        PlayBTN.setContentAreaFilled(false);
        PlayBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PlayBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PlayBTN.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        PlayBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PlayBTN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PlayBTNMouseMoved(evt);
            }
        });
        PlayBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PlayBTNMouseExited(evt);
            }
        });
        PlayBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayBTNActionPerformed(evt);
            }
        });
        getContentPane().add(PlayBTN);
        PlayBTN.setBounds(720, 690, 110, 85);

        BackgroundPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/SingleModePage/Game Mode Image.jpg"))); // NOI18N
        BackgroundPhoto.setText("jLabel1");
        getContentPane().add(BackgroundPhoto);
        BackgroundPhoto.setBounds(0, 0, 1000, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBTNActionPerformed
       new StartPage().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_BackBTNActionPerformed

    private void BackBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBTNMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BackBTNMouseEntered

    private void BackBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBTNMouseExited
        BackBTN.setIcon(new ImageIcon(getClass().getResource("/my/TwoPlayersModePage/Back button(medium).png")));
    }//GEN-LAST:event_BackBTNMouseExited

    private void BackBTNMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBTNMouseMoved
        BackBTN.setIcon(new ImageIcon(getClass().getResource("/my/TwoPlayersModePage/Back button.png")));
    }//GEN-LAST:event_BackBTNMouseMoved

    private void Player1NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player1NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Player1NameFieldActionPerformed

    private void BlueChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlueChoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BlueChoiceActionPerformed

    private void RedChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedChoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RedChoiceActionPerformed

    private void PlayBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayBTNActionPerformed
        // TODO add your handling code here: 
        
        RedChoice.setActionCommand("RedPlayer");
        BlueChoice.setActionCommand("BluePlayer");
        try{
        String choice = ColorBG.getSelection().getActionCommand();
        if(choice == "RedPlayer"){
            whichColor = true;
        }
       name1 = Player1NameField.getText();
        name2=Player2NameField.getText();
        if(name1.equals("")||name2.equals("")){
            throw new Exception("You must Fill Empty Fields");
        }
        if (GameGui.ReturnGame.HavePuase(name1, name2)!="Not Found")
        {
            NewOrContinue mm = new NewOrContinue();
            mm.setVisible(true);
        }
        
        else{
        Pass = new DrawBoard();
        Pass.setVisible(true);
        dispose();
        }
       
        
           
       
        }
        catch(RuntimeException r){
                        JOptionPane.showMessageDialog(this,"You must Fill Empty Fields","Error",JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception t){
              JOptionPane.showMessageDialog(this,t.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_PlayBTNActionPerformed

    private void PlayBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayBTNMouseExited
        PlayBTN.setIcon(new ImageIcon(getClass().getResource("/my/TwoPlayersModePage/Play button(medium).png")));
    }//GEN-LAST:event_PlayBTNMouseExited

    private void PlayBTNMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayBTNMouseMoved
        PlayBTN.setIcon(new ImageIcon(getClass().getResource("/my/TwoPlayersModePage/Play button.png")));
    }//GEN-LAST:event_PlayBTNMouseMoved

    private void Player1NameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player1NameFieldMouseClicked
        // TODO add your handling code here:
        Player1NameField.setText("");
    }//GEN-LAST:event_Player1NameFieldMouseClicked

    private void Player2NameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player2NameFieldMouseClicked
        // TODO add your handling code here:
        Player2NameField.setText("");
    }//GEN-LAST:event_Player2NameFieldMouseClicked

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
            java.util.logging.Logger.getLogger(TwoPlayersMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TwoPlayersMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TwoPlayersMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TwoPlayersMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TwoPlayersMode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBTN;
    private javax.swing.JLabel BackgroundPhoto;
    private javax.swing.JRadioButton BlueChoice;
    private javax.swing.JLabel BlueFigure;
    private javax.swing.ButtonGroup ColorBG;
    private javax.swing.JLabel NamesColorsLabel;
    private javax.swing.JButton PlayBTN;
    private javax.swing.JTextField Player1NameField;
    private javax.swing.JTextField Player2NameField;
    private javax.swing.JRadioButton RedChoice;
    private javax.swing.JLabel RedFigure;
    private javax.swing.JLabel TwoPlayersModeLabel;
    // End of variables declaration//GEN-END:variables
}