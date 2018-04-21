/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import Model.Booking;
import databases.DatabaseConnection;
import databases.MD5;
import static databases.MD5.computeMD5;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marinmcginley
 */
public class LogIn extends javax.swing.JDialog {
    private String userName;
    private char[] password;
    private String sPassword;
    private ArrayList<Booking> bookings;
    DefaultTableModel model;

    /**
     * Creates new form LogIn
     */
    public LogIn(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        jTable.getTableHeader().setPreferredSize(new Dimension(10,35)); // stilli breidd og hæð á column head
        model = (DefaultTableModel) jTable.getModel();
        
        // virkar ekki að fela töflu
        jPanelForTable.setVisible(false);
        putListInTable();
        
        userName = null;
    }
    
    public void setUsername(String userName) {
        this.userName = userName;
    }
    
    // skilar true ef username er tómt
    public boolean checkUsername() {
        if (userName == null) {
            return true;
        } else return false;
    }
    
    public void putListInTable() {
        bookings = DatabaseConnection.getBookings(userName);
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println(bookings.get(i).getNameOfHotel());
            model.addRow(new Object[]{bookings.get(i).getNameOfHotel(), bookings.get(i).getLocationOfHotel(),
                bookings.get(i).getPrice(), bookings.get(i).getFirstDate(), bookings.get(i).getLastDate()});  
        }
    }
    
    public void displayBookings() {
        jUser.setText(userName);
        jPanelForTable.setVisible(true);
        
        jLabelForUserName.setVisible(false);
        jLabelForPassword.setVisible(false);
        jUserName.setVisible(false);
        jPassword.setVisible(false);
        jLogIn.setVisible(false);
        
    }

    
    // Skilar true ef notendanafn er gilt annars false
    public boolean verifyUser() {
        
        String p = MD5.toHexString(computeMD5(sPassword.getBytes()));
        // Skilar true ef notendanafn er til í töflu og lykilorð passar við notendanafnið
        if (DatabaseConnection.logIn(userName, p)) {
            return true;
        }
        else return false;
    }
    
    public String getUserName() {
        return userName;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelForUserName = new javax.swing.JLabel();
        jLabelForPassword = new javax.swing.JLabel();
        jUserName = new javax.swing.JTextField();
        jText = new javax.swing.JLabel();
        jLogIn = new javax.swing.JButton();
        jWarning = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jPanelForTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jClose = new javax.swing.JButton();
        jUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(695, 653));

        jLabelForUserName.setText("Notendanafn:");

        jLabelForPassword.setText("Lykilorð:");

        jText.setText("Gaman að sjá þig");

        jLogIn.setText("Skrá inn ");
        jLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogInActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Hotel", "Staðsetning", "Verð", "Frá", "Til"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout jPanelForTableLayout = new javax.swing.GroupLayout(jPanelForTable);
        jPanelForTable.setLayout(jPanelForTableLayout);
        jPanelForTableLayout.setHorizontalGroup(
            jPanelForTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelForTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelForTableLayout.setVerticalGroup(
            jPanelForTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelForTableLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jClose.setText("Loka");
        jClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelForTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(688, 688, 688)
                            .addComponent(jWarning))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jText)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jUser)
                            .addGap(31, 31, 31)
                            .addComponent(jClose)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLogIn))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelForUserName)
                                    .addComponent(jLabelForPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jUserName)
                                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jWarning))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jClose)
                            .addComponent(jUser)
                            .addComponent(jText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelForUserName)
                            .addComponent(jUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelForPassword)
                            .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLogIn)))
                .addGap(18, 18, 18)
                .addComponent(jPanelForTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Fyrst þarf að skrá sig inn í kerfið, svo þarf að logga sig inn í kerfið
    private void jLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogInActionPerformed
        userName = jUserName.getText();
        password = jPassword.getPassword();
        sPassword = new String(password);
        
        
        // ef notendanafn og lykilorð stemma er farið aftur í index
        if (verifyUser()) {
            displayBookings();
        } else {
            userName = null;
            password = null;
            jUserName.setText("");
            jPassword.setText("");
            jWarning.setText("Notendanafn eða lykilorð er vitlaust");
        }
    }//GEN-LAST:event_jLogInActionPerformed

    private void jCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCloseActionPerformed
        dispose();
    }//GEN-LAST:event_jCloseActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LogIn dialog = new LogIn(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jClose;
    private javax.swing.JLabel jLabelForPassword;
    private javax.swing.JLabel jLabelForUserName;
    private javax.swing.JButton jLogIn;
    private javax.swing.JPanel jPanelForTable;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel jText;
    private javax.swing.JLabel jUser;
    private javax.swing.JTextField jUserName;
    private javax.swing.JLabel jWarning;
    // End of variables declaration//GEN-END:variables
}
