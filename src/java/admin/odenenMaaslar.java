package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class odenenMaaslar {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public odenenMaaslar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otel", "root", "");
    }
   
    public String ilkTarih;
    public String sonTarih;
    
    public String html;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    
    public String maaslariOgren() throws SQLException{
         ps = con.prepareStatement("SELECT * FROM odemekaydi WHERE Tarihi BETWEEN ? AND ?");
         ps.setString(1,getIlkTarih());
         ps.setString(2,getSonTarih());
         rs = ps.executeQuery();
         
         this.html="<table><tr><th>Odeme ID </th><th>Adı</th><th>Soy Adı</th><th>TC</><th>Odenen</th><th>Tarihi</th><th>Saati</th></tr>";
         
         while(rs.next()){
             this.html=this.html+"<tr><td>"+rs.getInt("OdemeId")+"</td><td>"+rs.getString("Adi")+"</td><td>"+rs.getString("SoyAdi")+
                     "</td><td>"+rs.getString("TC")+"</td><td>"+rs.getInt("Odenen")+"</td><td>"+rs.getString("Tarihi")+"</td><td>"+rs.getString("Saati")+"</td></tr>";
         }
         this.html=this.html+"</table>";
         return "gelir-gider";
    }

    public String getIlkTarih() {
        return ilkTarih;
    }

    public void setIlkTarih(String ilkTarih) {
        this.ilkTarih = ilkTarih;
    }

    public String getSonTarih() {
        return sonTarih;
    }

    public void setSonTarih(String sonTarih) {
        this.sonTarih = sonTarih;
    }
    
    

}
