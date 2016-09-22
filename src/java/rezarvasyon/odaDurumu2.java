package rezarvasyon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class odaDurumu2 {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public odaDurumu2() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otel", "root", "");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String suitOdaDurumu() { //Boş oda var mı diye kontrol ediyoruz
        try {
            ps = con.prepareStatement("SELECT Durumu FROM Odalar WHERE OdaTipi='SuitOda'AND Durumu='BOS'");
            rs = ps.executeQuery();
            if (rs.next()) {
                return "BOS";
            } else {
                return "DOLU";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    public String standartOdaDurumu() { //Boş oda var mı diye kontrol ediyoruz
        try {
            ps = con.prepareStatement("SELECT Durumu FROM Odalar WHERE OdaTipi='standart'AND Durumu='BOS'");
            rs = ps.executeQuery();
            if (rs.next()) {
                return "BOS";
            } else {
                return "DOLU";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    public String luxSuitOdaDurumu() { //Boş oda var mı diye kontrol ediyoruz
        try {
            ps = con.prepareStatement("SELECT Durumu FROM Odalar WHERE OdaTipi='luxSuit'AND Durumu='BOS'");
            rs = ps.executeQuery();
            if (rs.next()) {
                return "BOS";
            } else {
                return "DOLU";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    public String luxStandartOdaDurumu() { //Boş oda var mı diye kontrol ediyoruz
        try {
            ps = con.prepareStatement("SELECT Durumu FROM Odalar WHERE OdaTipi='luxStandart'AND Durumu='BOS'");
            rs = ps.executeQuery();
            if (rs.next()) {
                return "BOS";
            } else {
                return "DOLU";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
    public String deluxSuitOdaDurumu(){ //Boş oda var mı diye kontrol ediyoruz
        try{
        ps=con.prepareStatement("SELECT Durumu FROM Odalar WHERE OdaTipi='deluxSuit'AND Durumu='BOS'");
        rs=ps.executeQuery();
        if(rs.next()){
            return "BOS";
        }
        else{
            return "DOLU";
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return "";
    }
    
     public String deluxStandartOdaDurumu(){ //Boş oda var mı diye kontrol ediyoruz
        try{
        ps=con.prepareStatement("SELECT Durumu FROM Odalar WHERE OdaTipi='deluxStandart'AND Durumu='BOS'");
        rs=ps.executeQuery();
        if(rs.next()){
            return "BOS";
        }
        else{
            return "DOLU";
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return "";
    }
}
