/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author user
 */
public class Suclu_Database implements Interface{

    @Override
    public void database_yazdırma() {
        try
        {
            String host = "jdbc:derby://localhost:1527/Suclu_Kayit";
            String user = "Suclu_Kayit";
            String sifre = "123";
            Connection conn = DriverManager.getConnection(host, user, sifre);
            Statement stm = conn.createStatement();
            String SQL = "SELECT * FROM SUCLU_KAYIT";
            ResultSet rs = stm.executeQuery(SQL);
            while(rs.next())
            {
                String ad = rs.getString("AD");
                String soyad = rs.getString("SOYAD");
                String suc = rs.getString("SUC");
                String renk = rs.getString("RENK");
                System.out.println(ad + "//" + soyad + "//" + suc + "//" + renk);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void database_yazma(int numara,String ad,String soyad,String suc,String renk) {
        String host = "jdbc:derby://localhost:1527/Suclu_Kayit";
        String user = "Suclu_Kayit";
        String sifre = "123";
        try
        {
            Connection conn = DriverManager.getConnection(host,user,sifre);
            String sorgu="INSERT INTO SUCLU_KAYIT_DATABASE(NUMBER,AD,SOYAD,SUC,RENK) values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sorgu);
            ps.setInt(1, numara);
            ps.setString(2, ad);
            ps.setString(3, soyad);
            ps.setString(4, suc);
            ps.setString(5, renk);
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

    @Override
    public void database_silme(int number) {
        String host = "jdbc:derby://localhost:1527/Suclu_Kayit";
        String user = "Suclu_Kayit";
        String sifre = "123";
        try
        {
            Connection conn = DriverManager.getConnection(host,user,sifre);
            String sorgu = "DELETE FROM SUCLU_KAYIT_DATABASE WHERE NUMBER=?";
            PreparedStatement ps = conn.prepareStatement(sorgu);
            ps.setInt(1, number);
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

    public void database_degistirme(int number,String ad,String soyad,String suc,String renk) {
        String host = "jdbc:derby://localhost:1527/Suclu_Kayit";
        String user = "Suclu_Kayit";
        String sifre = "123";
        try
        {
            Connection conn = DriverManager.getConnection(host,user,sifre);
            String sorgu = "UPDATE SUCLU_KAYIT_DATABASE SET AD=?,SOYAD=?,SUC=?,RENK=? WHERE NUMBER=?";
            PreparedStatement ps = conn.prepareStatement(sorgu);
            ps.setString(1, ad);
            ps.setString(2, soyad);
            ps.setString(3, suc);
            ps.setString(4, renk);
            ps.setInt(5, number);
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
