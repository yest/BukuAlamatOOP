/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author YudiantoSujana
 */
public class CRUDSQLite implements CRUDInterface{
    private Connection conn;

    @Override
    public void bukaKoneksi() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:bukualamat.db");
    }

    @Override
    public void tutupKoneksi() throws SQLException {
        conn.close();
    }

    @Override
    public ArrayList<BukuAlamat> read() throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from alamat");
        ArrayList<BukuAlamat> listBukuAlamat = new ArrayList();
        while (rs.next()) {
            BukuAlamat ba = new BukuAlamat();
            ba.setId(rs.getInt(1));
            ba.setNama(rs.getString(2));
            ba.setAlamat(rs.getString(3));
            ba.setTelp(rs.getString(4));
            ba.setEmail(rs.getString(5));
            listBukuAlamat.add(ba);
        }
        return listBukuAlamat;
    }

    @Override
    public BukuAlamat readById(int id) throws SQLException {
        String query = "select * from alamat where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);  
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        BukuAlamat ba = new BukuAlamat();
        while (rs.next()) {            
            ba.setId(rs.getInt(1));
            ba.setNama(rs.getString(2));
            ba.setAlamat(rs.getString(3));
            ba.setTelp(rs.getString(4));
            ba.setEmail(rs.getString(5));
        }
        return ba;
    }

    @Override
    public void create(BukuAlamat ba) throws SQLException {
        String query = "insert into alamat(nama, alamat,telp,email) values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, ba.getNama());
        ps.setString(2, ba.getAlamat());
        ps.setString(3, ba.getTelp());
        ps.setString(4, ba.getEmail());
        ps.execute();
    }

    @Override
    public void delete(BukuAlamat ba) throws SQLException {
        String query = "delete from alamat where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, ba.getId());
        ps.execute();
    }

    @Override
    public void update(BukuAlamat ba) throws SQLException {
        String query = "update alamat set nama=?, alamat=?,telp=?,email=? where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, ba.getNama());
        ps.setString(2, ba.getAlamat());
        ps.setString(3, ba.getTelp());
        ps.setString(4, ba.getEmail());
        ps.setInt(5, ba.getId());
        ps.execute();
    }
    
}
