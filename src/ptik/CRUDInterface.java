/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptik;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author YudiantoSujana
 */
public interface CRUDInterface {
    public void bukaKoneksi() throws ClassNotFoundException, SQLException;
    public void tutupKoneksi() throws SQLException;
    public ArrayList<BukuAlamat> read() throws SQLException;
    public BukuAlamat readById(int id) throws SQLException;
    public void create(BukuAlamat ba) throws SQLException;
    public void delete(BukuAlamat ba) throws SQLException;
    public void update(BukuAlamat ba) throws SQLException;
}
