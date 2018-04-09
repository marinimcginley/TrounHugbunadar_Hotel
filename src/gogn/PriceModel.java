/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gogn;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author marinmcginley
 */
public class PriceModel extends DefaultComboBoxModel {
    
    public PriceModel(ArrayList<Integer> verd) {
         addElement(" ");
         for (int i = 0; i < verd.size(); i++){
            if(i < 9)
                addElement("0" + verd.get(i));
            else
                addElement(verd.get(i));
        }      
    }
    
}
