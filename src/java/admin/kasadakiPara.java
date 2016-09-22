package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class kasadakiPara {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    

    public kasadakiPara() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otel", "root", "");
    }

    public String kasayiOgren() throws ClassNotFoundException, SQLException {

        ps = con.prepareStatement("SELECT * FROM bankaHesaplari WHERE HesapNumarasi=?");
        ps.setString(1, "1111111111111111");
        rs = ps.executeQuery();

        String html = "<table class=\"adminTablo\"><tr class=\"adminTr\"><th class=\"adminTh\">Kasa</th></tr>";

        while (rs.next()) {

            html = html + "<tr class=\"adminTr\"><td class=\"adminTd\">" + rs.getInt("Bakiyesi") + "</td></tr>";
        }
        html = html + "</table>";
        return html;

    }
    
      public String odenenMaaslar() throws ClassNotFoundException, SQLException {

        ps = con.prepareStatement("SELECT * FROM bankaHesaplari WHERE HesapNumarasi=?");
        ps.setString(1, "1111111111111111");
        rs = ps.executeQuery();

        String html = "<table class=\"adminTablo\"><tr class=\"adminTr\"><th class=\"adminTh\">Kasa</th></tr>";

        while (rs.next()) {

            html = html + "<tr class=\"adminTr\"><td class=\"adminTd\">" + rs.getInt("Bakiyesi") + "</td></tr>";
        }
        html = html + "</table>";
        return html;

    }

}
