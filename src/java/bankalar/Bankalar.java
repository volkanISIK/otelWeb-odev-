package bankalar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bankalar {

    private int bakiyesi;
    private String hesapNumarasi;
    private String hespSifresi;

    public Bankalar(String hesapNumarasi, String hespSifresi) {
        this.hesapNumarasi = hesapNumarasi;
        this.hespSifresi = hespSifresi;

        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otel", "root", "");
            ps = con.prepareStatement("SELECT * FROM bankaHesaplari WHERE HesapNumarasi=?");
            ps.setString(1, this.hesapNumarasi);
            rs=ps.executeQuery();
            rs.next();
            this.bakiyesi=rs.getInt("Bakiyesi");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String paraTransferi(Bankalar hesapGonderecek, Bankalar hesapAlacak, int miktar)  {
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otel", "root", "");
            ps = con.prepareStatement("SELECT * FROM bankahesaplari WHERE HesapNumarasi=? AND BankaSifresi=?");
            ps.setString(1, hesapGonderecek.getHesapNumarasi());
            ps.setString(2, hesapGonderecek.getHespSifresi());
            rs = ps.executeQuery();
            rs.next();
            
           /* if(rs.equals(0)){
                return "Boyle bir banka hesabı yok";
            }
        
            if (rs.getString("HesapNumarasi").equals(hesapGonderecek.getHesapNumarasi()) && rs.getString("BankaSifresi").equals(hesapGonderecek.getHespSifresi())) {
               
            }
            else{
                 return "Boyle bir banka hesabı yok";
            }*/
            
            int bakiye1 = rs.getInt("Bakiyesi");
            if (bakiye1 < miktar) {
                return "bakiyeniz yetersiz";
            }
            bakiye1 = bakiye1 - miktar;
            ps = con.prepareStatement("UPDATE bankaHesaplari SET Bakiyesi=? WHERE HesapNumarasi=?");
            ps.setInt(1, bakiye1);
            ps.setString(2, hesapGonderecek.getHesapNumarasi());
            ps.executeUpdate();

            ps = con.prepareStatement("SELECT * FROM bankaHesaplari WHERE HesapNumarasi=?");
            ps.setString(1, hesapAlacak.getHesapNumarasi());
            rs = ps.executeQuery();
            rs.next();
            int bakiye2 = rs.getInt("Bakiyesi");
            bakiye2 = bakiye2 + miktar;
            ps = con.prepareStatement("UPDATE bankaHEsaplari SET Bakiyesi=? WHERE HesapNumarasi=?");
            ps.setInt(1, bakiye2);
            ps.setString(2, hesapAlacak.getHesapNumarasi());
            ps.executeUpdate();

        } catch (Exception e) {

        }

        return "basarılı";
    }

    public int getBakiyesi() {
        return bakiyesi;
    }

    public void setBakiyesi(int bakiyesi) {
        this.bakiyesi = bakiyesi;
    }

    public String getHesapNumarasi() {
        return hesapNumarasi;
    }

    public void setHesapNumarasi(String hesapNumarasi) {
        this.hesapNumarasi = hesapNumarasi;
    }

    public String getHespSifresi() {
        return hespSifresi;
    }

    public void setHespSifresi(String hespSifresi) {
        this.hespSifresi = hespSifresi;
    }

}
