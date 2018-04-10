/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import gogn.DagarModel;
import gogn.ManudirModel;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author marinmcginley
 */
public class Search extends javax.swing.JDialog {

    private DagarModel dag;
    private ManudirModel manFra;
    private ManudirModel manTil;

    
    
    /**
     * Creates new form Search
     */
    public Search(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        frumstillingIByrjun();
    }
    
    private void frumstillingIByrjun() {
        frumstillaCombo();
        frumstillaMedmaeliCombo();
    }
    
    /*
    Setur gildi 1-12 í ComboBox sem er skilgreint fyrir box með mánuðum 
    */
    private void frumstillaCombo(){
       int[]  manudur = {1,2,3,4,5,6,7,8,9,10,11,12}; // mánuðir 1-12
       
       manFra = new ManudirModel(manudur);
       manTil = new ManudirModel(manudur);
       jManFra.setModel(manFra);
       jManTil.setModel(manTil);
    }
    

    
    private void frumstillaMedmaeliCombo() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jNameOfHotel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLocation = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSearch = new javax.swing.JButton();
        jManFra = new javax.swing.JComboBox<>();
        jDagFra = new javax.swing.JComboBox<>();
        jManTil = new javax.swing.JComboBox<>();
        jDagTil = new javax.swing.JComboBox<>();
        jVerdFra = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jVerdTil = new javax.swing.JComboBox<>();
        jMedmaeliFra = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jMedmaeliTil = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Hótel:");

        jLabel2.setText("Staðsetning:");

        jLabel3.setText("Frá:");

        jLabel4.setText("Til:");

        jLabel5.setText("Verð per. nótt :");

        jLabel6.setText("Vil skoða hotel sem er með einkunn á bilinu : ");

        jSearch.setText("Leita");
        jSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchActionPerformed(evt);
            }
        });

        jManFra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jManFra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jManFraActionPerformed(evt);
            }
        });

        jDagFra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jManTil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jManTil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jManTilActionPerformed(evt);
            }
        });

        jDagTil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jVerdFra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "0", "5000", "10000", "15000", "20000", "25000", "30000" }));

        jLabel7.setText("þús. -");

        jVerdTil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "0", "5000", "10000", "15000", "20000", "25000", "30000" }));

        jMedmaeliFra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel8.setText("-");

        jMedmaeliTil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel9.setText("þús.");

        jLabel10.setText("2018");

        jLabel11.setText("2018");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNameOfHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jManFra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDagFra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jManTil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDagTil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMedmaeliFra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jMedmaeliTil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jVerdFra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jVerdTil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSearch)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jNameOfHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jManFra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDagFra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jManTil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDagTil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jVerdFra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jVerdTil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jMedmaeliFra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jMedmaeliTil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jSearch)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed
        // sækjum það sem notandi fyllti út í leitinni
        String nafnAHotel = jNameOfHotel.getText().toLowerCase();
        String stadsetning = jLocation.getText().toLowerCase();
        
        int manFra = Integer.valueOf(String.valueOf(jManFra.getSelectedItem()));
        int dagFra = Integer.valueOf(String.valueOf(jDagFra.getSelectedItem()));
        
        int manTil = Integer.valueOf(String.valueOf(jManTil.getSelectedItem()));
        int dagTil = Integer.valueOf(String.valueOf(jDagTil.getSelectedItem()));
        
        int verdFra = Integer.valueOf(String.valueOf(jVerdFra.getSelectedItem()));
        int verdTil = Integer.valueOf(String.valueOf(jVerdTil.getSelectedItem()));
        
        int medmaeliFra = Integer.valueOf(String.valueOf(jMedmaeliFra.getSelectedItem()));
        int medmaeliTil = Integer.valueOf(String.valueOf(jMedmaeliTil.getSelectedItem()));
        
        // þurfum svo að gera eitthvað með það :) 
    }//GEN-LAST:event_jSearchActionPerformed

    private void jManFraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jManFraActionPerformed
        JComboBox cb1 = (JComboBox)evt.getSource();
        String manFra = String.valueOf(cb1.getSelectedItem());
        
        if(manFra.equals(" ")){
        }
        else {
            int man = Integer.valueOf(manFra);
            setjaMan(man, "jManFra");
        }
    }//GEN-LAST:event_jManFraActionPerformed

    private void jManTilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jManTilActionPerformed
        JComboBox cb2 = (JComboBox)evt.getSource();
        String manTil = String.valueOf(cb2.getSelectedItem());
        
        if(manTil.equals(" ")){
        }
        else {
            int man = Integer.valueOf(manTil);
            setjaMan(man, "jManTil");
        }
    }//GEN-LAST:event_jManTilActionPerformed

    
    /*
    Fallið tekur inn töluna man sem er mánuður sem var valinn, og býr til ArrayList með fjölda daga í þeim mánuði
    Uppfærir svo ComboBoxið sem sýnir þessa daga
    */
    public void setjaMan(int man, String whichComboBox){
        ArrayList<Integer>  dagur = new ArrayList<>();
        
        switch(man) {
            case 1: case 3: case 5: case 7: case 8: case 10:  case 12:
                for(int i=1; i<32; i++){
                    dagur.add(i);
                }
                break;
            case 4: case 6: case 9: case 11:
                for(int i=1; i<31; i++){
                    dagur.add(i);
                }
                break;
            case 2:
                for(int i=1; i<29; i++){
                    dagur.add(i);
                }
                break;
        }
        setjaDaga(dagur, whichComboBox);
    }
    
    /*
    Tekur inn listan með dögum í mánuðinum og lætur setja þessi stök í ComboBox fyrir daga 
    */
    private void setjaDaga(ArrayList<Integer> m, String whichComboBox){
        dag = new DagarModel(m);
        if(whichComboBox == "jManFra") {
            jDagFra.setModel(dag);
        } else if(whichComboBox == "jManTil") {
            jDagTil.setModel(dag);
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Search dialog = new Search(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jDagFra;
    private javax.swing.JComboBox<String> jDagTil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLocation;
    private javax.swing.JComboBox<String> jManFra;
    private javax.swing.JComboBox<String> jManTil;
    private javax.swing.JComboBox<String> jMedmaeliFra;
    private javax.swing.JComboBox<String> jMedmaeliTil;
    private javax.swing.JTextField jNameOfHotel;
    private javax.swing.JButton jSearch;
    private javax.swing.JComboBox<String> jVerdFra;
    private javax.swing.JComboBox<String> jVerdTil;
    // End of variables declaration//GEN-END:variables
}
