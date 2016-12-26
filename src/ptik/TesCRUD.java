/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptik;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YudiantoSujana
 */
public class TesCRUD {
    public static void main(String[] args) {
        try {
            CRUD crud = new CRUD();
            crud.bukaKoneksi();
            ArrayList<BukuAlamat> list = new ArrayList();
            list = crud.read();
            System.out.println(list.size());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
