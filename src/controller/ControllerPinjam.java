/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelPinjam;
import util.Koneksi;

/**
 *
 * @author ASUS
 */
public class ControllerPinjam {
    Koneksi koneksi = new Koneksi();

    public void simpanPinjaman(ModelPinjam mp) {
        koneksi.KoneksiDatabase();
        String querySimpan = "insert into tbl_pinjam(namaTeman,barangPinjam) values('" + mp.getNama() + "','" + mp.getBarang() + "')";
        try {
            koneksi.state.executeUpdate(querySimpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan");
            System.err.println("Galat Controller Teman : " + e);
        }
    }
    
    public void hapusPinjam(ModelPinjam mp){
        try {
            koneksi.KoneksiDatabase();
            String queryHapusPinjam = "delete from tbl_pinjam where id=('"+mp.getId()+"')";
            koneksi.state.executeUpdate(queryHapusPinjam);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
            //koneksi.connect.close();
        } catch (SQLException e) {
            System.err.println("Error : "+e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terhapus");
        }
    }
    
    public void ubahPinjam(ModelPinjam mp){
        koneksi.KoneksiDatabase();
         try {
            int id = mp.getId();
            String nama = mp.getNama();
            String barang = mp.getBarang();

            String queryUbahPinjam = "update tbl_pinjam "
                    + "set barangPinjam=('"+ barang +"') where id=('" + id + "')";
            koneksi.state.executeUpdate(queryUbahPinjam);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate..");
        } catch (SQLException e) {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terubah");
        }
    }
    
    
    
}
