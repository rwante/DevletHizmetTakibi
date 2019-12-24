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

/**
 *
 * @author user
 */
public class Burs_Database implements Interface{

    @Override
    public void database_yazdırma() {
        String host = "jdbc:derby://localhost:1527/Burs_Basvuru";
        String user = "Burs_Basvuru";
        String sifre = "123";
        try
        {
            Connection conn = DriverManager.getConnection(host, user, sifre);
            Statement stm = conn.createStatement();
            String SQL = "SELECT * FROM BURS_BASVURU";
            ResultSet rs = stm.executeQuery(SQL);
            while(rs.next())
            {
                int no = rs.getInt("NUMARA");
                String ad = rs.getString("AD");
                String soyad = rs.getString("SOYAD");
                System.out.println(no + "//" +ad + "//" + soyad);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void database_yazma(int numara, String ad, String soyad) {
        String host = "jdbc:derby://localhost:1527/Burs_Basvuru";
        String user = "Burs_Basvuru";
        String sifre = "123";
        try
        {
            Connection conn = DriverManager.getConnection(host,user,sifre);
            String sorgu="INSERT INTO BURS_BASVURU_LISTESI(NUMBER,AD,SOYAD) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sorgu);
            ps.setInt(1, numara);
            ps.setString(2, ad);
            ps.setString(3, soyad);
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
        String host = "jdbc:derby://localhost:1527/Burs_Basvuru";
        String user = "Burs_Basvuru";
        String sifre = "123";
        try
        {
            Connection conn = DriverManager.getConnection(host,user,sifre);
            String sorgu = "DELETE FROM BURS_BASVURU_LISTESI WHERE NUMBER=?";
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
    public String harf_hesap(int sayi)
    {
        String sonuc = "HATA";
        if(sayi <= 100 && sayi >= 0)
        {
            if(sayi >= 85)
            {
                sonuc = "AA";
            }
            else if(sayi >= 70)
            {
                sonuc = "BA";
            }
            else if(sayi >= 60)
            {
                sonuc = "BB";
            }
            else if(sayi >= 50)
            {
                sonuc = "CB";
            }
            else if(sayi >= 40)
            {
                sonuc = "CC";
            }
            else if(sayi >= 35)
            {
                sonuc = "DC";
            }
            else{
                sonuc = "FF";
            }
        }
        return sonuc;
        
    }
    public double gano_hesap(int[] dizi)
    {
        int i;
        String harf;
        double toplam = 0;
        for(i = 0; i < dizi.length;i++)
        {
            harf = harf_hesap(dizi[i]);
            if(null != harf)
            switch (harf) {
                case "AA":
                    toplam += 4;
                    break;
                case "BA":
                    toplam += 3.5;
                    break;
                case "BB":
                    toplam += 3;
                    break;
                case "CB":
                    toplam += 2.5;
                    break;
                case "CC":
                    toplam += 2;
                    break;
                case "DC":
                    toplam += 1.5;
                    break;
            }
        }
        return toplam/dizi.length;
    }

    
}
