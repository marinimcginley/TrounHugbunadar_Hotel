/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.xml.datatype.DatatypeConfigurationException;
import vinnsla.Hotel;


/**
 *
 * @author marinmcginley
 */
public class Index extends javax.swing.JFrame {
    private javax.swing.JButton jLogOut;
    private javax.swing.JLabel jUser;
    private LogIn logIn;
    
    //public Hotel testHotel;

    /**
     * Creates new form Index
     */
    public Index() {
        initComponents();
        
        buaTilTestHotel();
    }
    
    private void buaTilTestHotel() {
        /*Hotel test1 = new Hotel("Test", "Test", true, true, true, true, true, true);
        System.out.println("Búin að búa til Hotel");
        ArrayList<LocalDate> isBooked;
        isBooked = new ArrayList<>();
        LocalDate a = LocalDate.of(2018, 4, 13);
        isBooked.add(a);
        test1.addRoom(15000, 2, 1, isBooked);
        //System.out.println(testHotel.getNameOfHotel());*/
    }

    public void initializeAfterLogIn() {
        // finna út úr staðsetningum
        jLogIn.removeAll();
        jSignInFirstTime.removeAll();
        jLogOut.setAlignmentX(TOP_ALIGNMENT);
        jLogOut.setAlignmentY(TOP_ALIGNMENT);
        jLogOut.setLocation(WIDTH, WIDTH);
        jLogOut.setText("Útskráning");
        jUser.setAlignmentX(TOP_ALIGNMENT);
        jUser.setAlignmentY(TOP_ALIGNMENT);
        jUser.setLocation(WIDTH, WIDTH);
        jUser.setText(logIn.getUserName());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLogIn = new javax.swing.JButton();
        jSignInFirstTime = new javax.swing.JButton();
        jSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Velkomin inná forritið okkar.  Hér getur þú leita að hóteli á Íslandi :");

        jLogIn.setText("Innskráning");
        jLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogInActionPerformed(evt);
            }
        });

        jSignInFirstTime.setText("Nýskráning");
        jSignInFirstTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSignInFirstTimeActionPerformed(evt);
            }
        });

        jSearch.setText("Byrja leit");
        jSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLogIn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSignInFirstTime))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLogIn)
                    .addComponent(jSignInFirstTime))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSearch)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed
        Search search = new Search(this, true);
        
        search.setVisible(true);
        
        // útvega svo eins og í AdalDagra.java í Dagska verkefninu.
        // Ef isVista() == true þá birtum við lista af hótelum fyrir neðan
        
    }//GEN-LAST:event_jSearchActionPerformed

    private void jLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogInActionPerformed
        logIn = new LogIn(this, true);  
        logIn.setVisible(true);
        if (logIn.getUserName() != null) {
            initializeAfterLogIn();
        }
    }//GEN-LAST:event_jLogInActionPerformed

    private void jSignInFirstTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSignInFirstTimeActionPerformed
        Register nyskraning = null;
        
        nyskraning = new Register(this, true);
        
        nyskraning.setVisible(true);
    }//GEN-LAST:event_jSignInFirstTimeActionPerformed

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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JButton jLogIn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSearch;
    private javax.swing.JButton jSignInFirstTime;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
