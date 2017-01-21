/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelTeman;
import model.ModelTeman;
import util.Koneksi;

/**
 *
 * @author ASUS
 */
public class ControllerTeman {
    
    Koneksi koneksi = new Koneksi();
    
    public void SimpanTeman (ModelTeman mt){
        koneksi.KoneksiDatabase();
        String querySimpan = "insert into tbl_teman(nama,nope,email) values ('"+mt.getNama()+"','"+mt.getNope()+"','"+mt.getEmail()+"')";
        try {
            koneksi.state.executeUpdate(querySimpan);
            JOptionPane.showMessageDialog(null, "data disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data tidak tersimpan");
            System.err.println("terjadi galat"+e);
        }
    }
    
    public void HapusTeman(ModelTeman mt){
        try {
            koneksi.KoneksiDatabase();
            String queryHapus="delete from tbl_teman where id = ('"+mt.getId()+"')";
            koneksi.state.executeUpdate(queryHapus);
            JOptionPane.showMessageDialog(null, "data di hapus");
            
        } catch (SQLException e) {
            System.err.println("terjadi galat"+e);
            JOptionPane.showMessageDialog(null, "data tidak terhapus");
        }
    }
    
    public void UbahTeman (ModelTeman mt){
        koneksi.KoneksiDatabase();
        try {
            int id = mt.getId();
            String nama = mt.getNama();
            String nope = mt.getNope();
            String email =  mt.getEmail();
            String queryUbah = "update tbl_teman "
                    + "set nama=('" + nama + "'),"
                    + "nope=('"+ nope +"'),"
                    + "email=('"+ email +"')"
                    + "where id=('" + id + "')";
            koneksi.state.executeUpdate(queryUbah);
            JOptionPane.showMessageDialog(null, "Data di update");
            
        } catch (SQLException e) {
            System.err.println("terjadi galat"+e);
            JOptionPane.showMessageDialog(null, "data tidak berubah");
        }
    }
    
    
}
