/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 *
 * @author user
 */
public class Trafik_UlasimDatabase {
    public String[] plaka_yazdırma(String plaka)
    {
        String[] dizi = new String[10];
        String host = "jdbc:derby://localhost:1527/Plaka_Kayit";
        String user = "Plaka_Kayit";
        String sifre = "123";
        try
        {
            Connection conn = DriverManager.getConnection(host, user, sifre);
            String SQL = "SELECT * FROM PLAKA_LISTE WHERE PLAKA=?";
            PreparedStatement s=conn.prepareStatement(SQL);
            s.setString(1, plaka);
            ResultSet rs = s.executeQuery();
            while(rs.next())
            {
                dizi[0] = rs.getString("SEFER1");
                dizi[1] = rs.getString("SEFER2");
                dizi[2] = rs.getString("SEFER3");
                dizi[3] = rs.getString("SEFER4");
                dizi[4] = rs.getString("SEFER5");
                dizi[5] = rs.getString("SEFER6");
                dizi[6] = rs.getString("SEFER7");
                dizi[7] = rs.getString("SEFER8");
                dizi[8] = rs.getString("SEFER9");
                dizi[9] = rs.getString("SEFER10");
            }
            
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return dizi;
    }
    public void plaka_ekleme(String plaka,String[] dizi)
    {
        String host = "jdbc:derby://localhost:1527/Plaka_Kayit";
        String user = "Plaka_Kayit";
        String sifre = "123";
        try
        {
            Connection conn = DriverManager.getConnection(host,user,sifre);
            String sql = "INSERT INTO PLAKA_LISTE(PLAKA,SEFER1,SEFER2,SEFER3,SEFER4,SEFER5,SEFER6,SEFER7,SEFER8,SEFER9,SEFER10) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, plaka);
            ps.setString(2, dizi[0]);
            ps.setString(3, dizi[1]);
            ps.setString(4, dizi[2]);
            ps.setString(5, dizi[3]);
            ps.setString(6, dizi[4]);
            ps.setString(7, dizi[5]);
            ps.setString(8, dizi[6]);
            ps.setString(9, dizi[7]);
            ps.setString(10, dizi[8]);
            ps.setString(11, dizi[9]);
            ps.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void plaka_silme(String plaka)
    {
        String host = "jdbc:derby://localhost:1527/Plaka_Kayit";
        String user = "Plaka_Kayit";
        String sifre = "123";
        try
        {
            Connection conn = DriverManager.getConnection(host,user,sifre);
            String sorgu = "DELETE FROM PLAKA_LISTE WHERE PLAKA=?";
            PreparedStatement ps = conn.prepareStatement(sorgu);
            ps.setString(1, plaka);
            ps.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println("SQL HATA");
        }
        catch(Exception ex1)
        {
            System.out.println(ex1.getMessage());
        }
    }
    public void hat_degistirme(String plaka,String dizi[])
    {
        String host = "jdbc:derby://localhost:1527/Plaka_Kayit";
        String user = "Plaka_Kayit";
        String sifre = "123";
        try
        {
            Connection conn = DriverManager.getConnection(host,user,sifre);
            String sorgu = "UPDATE PLAKA_LISTE SET SEFER1=?,SEFER2=?,SEFER3=?,SEFER4=?,"
                    + "SEFER5=?,SEFER6=?,SEFER7=?,SEFER8=?,SEFER9=?,SEFER10=? WHERE PLAKA=?";
            PreparedStatement ps = conn.prepareStatement(sorgu);
            ps.setString(1, dizi[0]);
            ps.setString(2, dizi[1]);
            ps.setString(3, dizi[2]);
            ps.setString(4, dizi[3]);
            ps.setString(5, dizi[4]);
            ps.setString(6, dizi[5]);
            ps.setString(7, dizi[6]);
            ps.setString(8, dizi[7]);
            ps.setString(9, dizi[8]);
            ps.setString(10, dizi[9]);
            ps.setString(11, plaka);
            ps.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println("SQL HATA");
        }
        catch(Exception ex1)
        {
            System.out.println(ex1.getMessage());
        }
    }
}
