/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import Storage.DaysModel;
import Storage.MonthsModel;
import java.awt.CheckboxGroup;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author marinmcginley
 */
public class Search extends javax.swing.JDialog {

    private DaysModel days;
    private MonthsModel monthFrom;
    private MonthsModel monthTo;
    private Boolean save;
    private String userName;

    
    
    /**
     * Creates new form Search
     */
    public Search(java.awt.Frame parent, boolean modal, String userName) {
        super(parent, modal);
        initComponents();
        
        this.userName = userName;
        setUserName();
        initializeOnStart();
        save = false;
        
    }
    
    private void setUserName() {
        if (!userName.equals("")) {
            jUserName.setText(userName);
        }   
    }
    
    private void initializeOnStart() {
        initializeCombo();
    }
    
    /*
    Setur gildi 1-12 í ComboBox sem er skilgreint fyrir box með mánuðum 
    */
    private void initializeCombo(){
       int[]  months = {1,2,3,4,5,6,7,8,9,10,11,12}; // mánuðir 1-12
       
       monthFrom = new MonthsModel(months);
       monthTo = new MonthsModel(months);
       jMonthFrom.setModel(monthFrom);
       jMonthTo.setModel(monthTo);
    }
    
        /*
       Fallið skilar boolean breytu hvort það er búið að ýta á Vista (og engar villur eru í validation) eða ekki.
    */
    public Boolean isVista(){
        return save;
    }
    public String searchGetHotelName(){
        if(jNameOfHotel.getText().toLowerCase() != " "){
            return jNameOfHotel.getText().toLowerCase();
        }
        return "";
    }
    
    public String searchGetLocation(){
        if(jLocation.getText().toLowerCase() != " ") {
            return jLocation.getText().toLowerCase();
        }
        return "";
    }
    public int searchGetPriceFrom(){
        if(String.valueOf(jPriceFrom.getSelectedItem()) != " ") {
            return Integer.valueOf(String.valueOf(jPriceFrom.getSelectedItem()));
        }
        return -1;
    }
    public int searchGetPriceTo(){
        if(String.valueOf(jPriceTo.getSelectedItem()) != " ") {
            return Integer.valueOf(String.valueOf(jPriceTo.getSelectedItem()));
        }
        return -1;
    }
    public int searchGetGradeFrom(){
        if(String.valueOf(jGradeFrom.getSelectedItem()) != " "){
            return Integer.valueOf(String.valueOf(jGradeFrom.getSelectedItem()));
        }
        return -1;
    }
    public int searchGetGradeTo(){
        if(String.valueOf(jGradeTo.getSelectedItem()) != " "){
            return Integer.valueOf(String.valueOf(jGradeTo.getSelectedItem()));
        }
        return -1;
    }
    public String searchGetWifi(){
        if(jWifi.isSelected()){
            return "1";
        }
        return "";
    }
    public String searchGetHandic(){
        if(jAviableForHandic.isSelected()){
            return "1";
        }
        return "";
    }
    public String searchGetPickup(){
        if(jPickUp.isSelected()){
            return "1";
        }
        return "";
    }
    public String searchGetBreakfast(){
        if(jBreakfastIncluded.isSelected()){
            return "1";
        }
        return "";
    }
    public String searchGetSwimmingpool(){
        if(jPool.isSelected()){
            return "1";
        }
        return "";
    }
    public String searchGetGym(){
        if(jGym.isSelected()){
            return "1";
        }
        return "";
    }
    
    
    public void getSerchQuery(){
        // sækjum það sem notandi fyllti út í leitinni
        
        int manFra = Integer.valueOf(String.valueOf(jMonthFrom.getSelectedItem()));
        int dagFra = Integer.valueOf(String.valueOf(jDayFrom.getSelectedItem()));
        
        int manTil = Integer.valueOf(String.valueOf(jMonthTo.getSelectedItem()));
        int dagTil = Integer.valueOf(String.valueOf(jDayTo.getSelectedItem()));
        
        
        
        // Spurning hvernig við viljum skila hér. Ætlum að búa til Query streng hér eða senda
        // til baka það sem leitað var eftir og annað klasi ser um að búa til QueryStreng.
    }
    
    private void showValidationMessage(String errorInformation) {
        String[] options = {"Ok", "Hætta við"};
        
            int n = JOptionPane.showOptionDialog(this,
                errorInformation,
                "Villa við leið",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
            
            if(n == 1) {
                setVisible(false);
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

        jLabel1 = new javax.swing.JLabel();
        jNameOfHotel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLocation = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSearch = new javax.swing.JButton();
        jMonthFrom = new javax.swing.JComboBox<>();
        jDayFrom = new javax.swing.JComboBox<>();
        jMonthTo = new javax.swing.JComboBox<>();
        jDayTo = new javax.swing.JComboBox<>();
        jPriceFrom = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPriceTo = new javax.swing.JComboBox<>();
        jGradeFrom = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jGradeTo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jWifi = new javax.swing.JCheckBox();
        jPool = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jGym = new javax.swing.JCheckBox();
        jAviableForHandic = new javax.swing.JCheckBox();
        jPickUp = new javax.swing.JCheckBox();
        jBreakfastIncluded = new javax.swing.JCheckBox();
        jUserName = new javax.swing.JLabel();

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

        jMonthFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jMonthFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMonthFromActionPerformed(evt);
            }
        });

        jDayFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMonthTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jMonthTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMonthToActionPerformed(evt);
            }
        });

        jDayTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPriceFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "0", "5000", "10000", "15000", "20000", "25000", "30000" }));

        jLabel7.setText("þús. -");

        jPriceTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "0", "5000", "10000", "15000", "20000", "25000", "30000" }));

        jGradeFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel8.setText("-");

        jGradeTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel9.setText("þús.");

        jLabel10.setText("2018");

        jLabel11.setText("2018");

        jWifi.setText("WIFI");

        jPool.setText("Sundlaug");

        jLabel12.setText("<html>Ef þú óskar eftir að eftirfarandi sé til á hóteli sem þú ert að leita að, <br> endilega hakaðu þá í það </html>");

        jGym.setText("Ræktin");

        jAviableForHandic.setText("Aðgengi fyrir hreyfihamlaða");

        jPickUp.setText("Akstursþjónusta");

        jBreakfastIncluded.setText("Morgunmatur innifalinn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPickUp)
                        .addGap(18, 18, 18)
                        .addComponent(jBreakfastIncluded)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSearch)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNameOfHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jUserName))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jMonthTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDayTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jGradeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jGradeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPriceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPriceTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jWifi)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPool)
                                        .addGap(18, 18, 18)
                                        .addComponent(jGym)
                                        .addGap(18, 18, 18)
                                        .addComponent(jAviableForHandic))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jNameOfHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMonthTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDayTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPriceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jPriceTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jGradeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jGradeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jWifi)
                    .addComponent(jPool)
                    .addComponent(jGym)
                    .addComponent(jAviableForHandic))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jSearch)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPickUp)
                            .addComponent(jBreakfastIncluded))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed
        // hér fer fram validation ! 
        
        int dayFrom = Integer.parseInt(jDayFrom.getSelectedItem().toString());
        int dayTo = Integer.parseInt(jDayTo.getSelectedItem().toString());
        int monthFrom = Integer.parseInt(jMonthFrom.getSelectedItem().toString());
        int monthTo = Integer.parseInt(jMonthTo.getSelectedItem().toString());
        
        int priceFrom = 0;
        if(jPriceFrom.getSelectedItem().toString().isEmpty()){
            priceFrom = Integer.parseInt(jMonthFrom.getSelectedItem().toString());
        }
        int priceTo = 100000; // frumstilli það sem eitthvað mjög hátt
        if(jPriceTo.getSelectedItem().toString().isEmpty()){
            priceTo = Integer.parseInt(jPriceTo.getSelectedItem().toString());
        }
        
        int gradeFrom = 0;
        if(jGradeFrom.getSelectedItem().toString().isEmpty()){
            gradeFrom = Integer.parseInt(jGradeFrom.getSelectedItem().toString());
        }
        int gradeTo = 10; // frumstilli sem hæsta
        if(jGradeTo.getSelectedItem().toString().isEmpty()){
            gradeTo = Integer.parseInt(jGradeTo.getSelectedItem().toString());
        }
        
        
        if(monthTo < monthFrom) {
            showValidationMessage("Ekki er hægt að skrá sig út áður en það er innritað.");
        } else if(monthTo == monthFrom & dayTo <= dayFrom) {
            showValidationMessage("Ekki er hægt að skrá sig út áður en það er innritað");
        } else if(priceTo < priceFrom) {
            showValidationMessage("Verðbil er ekki rétt valið");
        } else if(gradeTo < gradeFrom) {
            showValidationMessage("Einkunnar-bil er ekki rétt valið");
        } else {
            save = true;
            setVisible(false);
        }
        
        
        
        // þurfum svo að gera eitthvað með það :) 
    }//GEN-LAST:event_jSearchActionPerformed

    private void jMonthFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMonthFromActionPerformed
        JComboBox cb1 = (JComboBox)evt.getSource();
        String manFra = String.valueOf(cb1.getSelectedItem());
        
        if(manFra.equals(" ")){
        }
        else {
            int man = Integer.valueOf(manFra);
            setMonths(man, "jManFra");
        }
    }//GEN-LAST:event_jMonthFromActionPerformed

    private void jMonthToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMonthToActionPerformed
        JComboBox cb2 = (JComboBox)evt.getSource();
        String monthsTo = String.valueOf(cb2.getSelectedItem());
        
        if(monthsTo.equals(" ")){
        }
        else {
            int man = Integer.valueOf(monthsTo);
            setMonths(man, "jManTil");
        }
    }//GEN-LAST:event_jMonthToActionPerformed

    
    /*
    Fallið tekur inn töluna man sem er mánuður sem var valinn, og býr til ArrayList með fjölda daga í þeim mánuði
    Uppfærir svo ComboBoxið sem sýnir þessa daga
    */
    public void setMonths(int man, String whichComboBox){
        ArrayList<Integer>  days = new ArrayList<>();
        
        switch(man) {
            case 1: case 3: case 5: case 7: case 8: case 10:  case 12:
                for(int i=1; i<32; i++){
                    days.add(i);
                }
                break;
            case 4: case 6: case 9: case 11:
                for(int i=1; i<31; i++){
                    days.add(i);
                }
                break;
            case 2:
                for(int i=1; i<29; i++){
                    days.add(i);
                }
                break;
        }
        setDays(days, whichComboBox);
    }
    
    /*
    Tekur inn listan með dögum í mánuðinum og lætur setja þessi stök í ComboBox fyrir daga 
    */
    private void setDays(ArrayList<Integer> m, String whichComboBox){
        days = new DaysModel(m);
        if(whichComboBox == "jManFra") {
            jDayFrom.setModel(days);
        } else if(whichComboBox == "jManTil") {
            jDayTo.setModel(days);
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
                Search dialog = new Search(new javax.swing.JFrame(), true, new String());
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
    private javax.swing.JCheckBox jAviableForHandic;
    private javax.swing.JCheckBox jBreakfastIncluded;
    private javax.swing.JComboBox<String> jDayFrom;
    private javax.swing.JComboBox<String> jDayTo;
    private javax.swing.JComboBox<String> jGradeFrom;
    private javax.swing.JComboBox<String> jGradeTo;
    private javax.swing.JCheckBox jGym;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLocation;
    private javax.swing.JComboBox<String> jMonthFrom;
    private javax.swing.JComboBox<String> jMonthTo;
    private javax.swing.JTextField jNameOfHotel;
    private javax.swing.JCheckBox jPickUp;
    private javax.swing.JCheckBox jPool;
    private javax.swing.JComboBox<String> jPriceFrom;
    private javax.swing.JComboBox<String> jPriceTo;
    private javax.swing.JButton jSearch;
    private javax.swing.JLabel jUserName;
    private javax.swing.JCheckBox jWifi;
    // End of variables declaration//GEN-END:variables
}
