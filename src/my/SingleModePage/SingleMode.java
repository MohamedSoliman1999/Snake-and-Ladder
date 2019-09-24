/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.SingleModePage;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import my.LevelsPage.Level;
import my.StartPage.StartPage;
import my.TwoPlayersModePage.TwoPlayersMode;

/**
 *
 * @author Alaa
 */
public class SingleMode extends javax.swing.JFrame {

    /**
     * Creates new form SingleMode
     */
    public static boolean whichColor;
    public static String name;
    public static boolean singleMode;
    public  static Level lev;
    public SingleMode() {
        this.setUndecorated(true); //removes the title bar
        this.setAlwaysOnTop(true); //this interface is always on top
        this.setResizable(false);
        this.setVisible(true);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
         this.setSize(1000,800);
        this.setLocationRelativeTo(null);
        whichColor = false;
        singleMode = true;
        TwoPlayersMode.twoPlayersMode=false;
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
        SingleModeLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        ChooseAColorLabel = new javax.swing.JLabel();
        BackBTN = new javax.swing.JButton();
        BlueChoice = new javax.swing.JRadioButton();
        BlueFigure = new javax.swing.JLabel();
        RedChoice = new javax.swing.JRadioButton();
        RedFigure = new javax.swing.JLabel();
        PlayBTN = new javax.swing.JButton();
        BackgroundPhoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        SingleModeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/SingleModePage/Single Mode.png"))); // NOI18N
        SingleModeLabel.setText("jLabel2");
        getContentPane().add(SingleModeLabel);
        SingleModeLabel.setBounds(190, 90, 400, 80);

        NameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/SingleModePage/Name.png"))); // NOI18N
        NameLabel.setText("jLabel3");
        getContentPane().add(NameLabel);
        NameLabel.setBounds(170, 350, 200, 100);

        NameField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        NameField.setForeground(new java.awt.Color(154, 97, 28));
        NameField.setText("Player Name");
        NameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameFieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NameFieldMouseExited(evt);
            }
        });
        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(NameField);
        NameField.setBounds(280, 430, 330, 50);

        ChooseAColorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/SingleModePage/Choose a color.png"))); // NOI18N
        ChooseAColorLabel.setText("jLabel4");
        getContentPane().add(ChooseAColorLabel);
        ChooseAColorLabel.setBounds(160, 500, 370, 80);

        BackBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/SingleModePage/Back button(medium).png"))); // NOI18N
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
        BackBTN.setBounds(0, -10, 110, 90);

        ColorBG.add(BlueChoice);
        BlueChoice.setContentAreaFilled(false);
        BlueChoice.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BlueChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlueChoiceActionPerformed(evt);
            }
        });
        getContentPane().add(BlueChoice);
        BlueChoice.setBounds(330, 590, 40, 40);

        BlueFigure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/SingleModePage/Blue Figure.png"))); // NOI18N
        getContentPane().add(BlueFigure);
        BlueFigure.setBounds(280, 570, 60, 90);

        ColorBG.add(RedChoice);
        RedChoice.setContentAreaFilled(false);
        RedChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedChoiceActionPerformed(evt);
            }
        });
        getContentPane().add(RedChoice);
        RedChoice.setBounds(510, 600, 93, 30);

        RedFigure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/SingleModePage/Red Figure.png"))); // NOI18N
        getContentPane().add(RedFigure);
        RedFigure.setBounds(460, 570, 70, 90);

        PlayBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/SingleModePage/Play button(medium).png"))); // NOI18N
        PlayBTN.setBorderPainted(false);
        PlayBTN.setContentAreaFilled(false);
        PlayBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PlayBTN.setFocusPainted(false);
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
        PlayBTN.setBounds(710, 690, 128, 80);

        BackgroundPhoto.setForeground(new java.awt.Color(160, 119, 36));
        BackgroundPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/SingleModePage/Game Mode Image.jpg"))); // NOI18N
        BackgroundPhoto.setText("jLabel1");
        getContentPane().add(BackgroundPhoto);
        BackgroundPhoto.setBounds(0, 0, 1000, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_NameFieldActionPerformed

    private void BackBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBTNMouseExited
        BackBTN.setIcon(new ImageIcon(getClass().getResource("/my/SingleModePage/Back button(medium).png")));
    }//GEN-LAST:event_BackBTNMouseExited

    private void BackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBTNActionPerformed
        new StartPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBTNActionPerformed

    private void BackBTNMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBTNMouseMoved
        BackBTN.setIcon(new ImageIcon(getClass().getResource("/my/SingleModePage/Back button.png")));
    }//GEN-LAST:event_BackBTNMouseMoved

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
        name = NameField.getText();
        if(name.equals("")){
            throw new Exception("You must Fill Empty Fields");
        }
      
        try{
           
          lev = new Level();
          lev.setVisible(true);
        }
        catch(Exception e){
            e.getMessage();
        }
        this.dispose();
        }
        catch(RuntimeException r){
                        JOptionPane.showMessageDialog(this,"You must Fill Empty Fields","Error",JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception t){
              JOptionPane.showMessageDialog(this,t.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
          
    }//GEN-LAST:event_PlayBTNActionPerformed

    private void PlayBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayBTNMouseExited
        PlayBTN.setIcon(new ImageIcon(getClass().getResource("/my/SingleModePage/Play button(medium).png")));
    }//GEN-LAST:event_PlayBTNMouseExited

    private void PlayBTNMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayBTNMouseMoved
        PlayBTN.setIcon(new ImageIcon(getClass().getResource("/my/SingleModePage/Play button.png")));
    }//GEN-LAST:event_PlayBTNMouseMoved

    private void NameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameFieldMouseClicked
        // TODO add your handling code here:
        NameField.setText("");
    }//GEN-LAST:event_NameFieldMouseClicked

    private void NameFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameFieldMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldMouseExited

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
            java.util.logging.Logger.getLogger(SingleMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SingleMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SingleMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SingleMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SingleMode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBTN;
    private javax.swing.JLabel BackgroundPhoto;
    private javax.swing.JRadioButton BlueChoice;
    private javax.swing.JLabel BlueFigure;
    private javax.swing.JLabel ChooseAColorLabel;
    private javax.swing.ButtonGroup ColorBG;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JButton PlayBTN;
    private javax.swing.JRadioButton RedChoice;
    private javax.swing.JLabel RedFigure;
    private javax.swing.JLabel SingleModeLabel;
    // End of variables declaration//GEN-END:variables
}