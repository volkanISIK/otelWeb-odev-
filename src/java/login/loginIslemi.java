package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class loginIslemi {

     private static final long serialVersionUID = 7765876811740798583L;
    
    private String username;
    private String password;

    private boolean loggedIn=false;

    public String girisYap() {
        String admin;
        String sifresi;
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otel", "root", "");
            ps = con.prepareStatement("SELECT * FROM adminler WHERE KullaniciAdi=?");
            ps.setString(1, this.username);
            rs = ps.executeQuery();
            rs.next();
            admin = rs.getString("KullaniciAdi");
            sifresi = rs.getString("Sifresi");
            if (admin.equals(username) && sifresi.equals(password)) {
                loggedIn = true;
                return "secured/adminAnasayfasi";
            }
        } catch (Exception e) {

        }
        return "logIn";
    }

    public String cikisYap() {
        loggedIn = false;
        return "/logIn";
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

   
}
