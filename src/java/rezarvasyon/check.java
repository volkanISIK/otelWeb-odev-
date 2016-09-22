package rezarvasyon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class check {
    /*veri tabanı değişkenleri başlangıcı*/

    private String checkIn="";
    private String checkOut="";
    private String adi="";
    private String soyAdi="";
    private String tcKimlik="";
    private String email="";
    private String telefon="";
    private int kisiSayisi;
    private String odaTipi="";
    private String adres="";
    String sorgu;
    /*veritabanı değişkenleri sonu*/
    
    public String hidden = "none";
    Ucretler toplamUcret = new Ucretler();

    public String odaAra() {
        return "kayit-1Demo";
    }
    public int toplamUcretiAl(){
        return toplamUcret.getToplamUcret();
    }
    public String kayit() {  //bu fonksiyon rezarvasyonu tamamlıyor
        sorgu = null;
        if(checkIn.equals("") && adi.equals("") && odaTipi.equals("")){
       
            setSorgu("Bir şeyler eksik gibi...");
            return "kayit-4Demo";
        }
        String hata;
        PreparedStatement ps = null;
        Connection con = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
        String date = dateFormat.format(new Date());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(new Date());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otel", "root", "");

            ps = con.prepareStatement("INSERT INTO rezarvasyon (CheckIn,CheckOut,Adi, SoyAdi,TC,Email,Telefon,KisiSayisi,OdaTipi,"
                    + "Adress,AlinanTopUcret,RezarvasyonTarihi,RezarvasyonSaati)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, checkIn);
            ps.setString(2, checkOut);
            ps.setString(3, adi);
            ps.setString(4, soyAdi);
            ps.setString(5, tcKimlik);
            ps.setString(6, email);
            ps.setString(7, telefon);
            ps.setInt(8, kisiSayisi);
            ps.setString(9, odaTipi);
            ps.setString(10, adres);
            ps.setInt(11,toplamUcretiAl());
            ps.setString(12, "tarih");
            ps.setString(13, "saat");
            
            ps.executeQuery();
            

        } catch (Exception e) {
            System.out.println(e);
            hata = e.toString();

        } finally {
                checkIn="";
                checkOut="";
                adi="";
                soyAdi="";
                tcKimlik="";
                email="";
                telefon="";
                kisiSayisi=0;
                odaTipi="";
                adres="";
                toplamUcret.topamUcretiSifirla();
                
            try {
                con.close();
                ps.close();
             
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return sorgu;
    }

    public String suitOdaTut() {
        setOdaTipi("suitOda");
        toplamUcret.ucretEkle(toplamUcret.SUITODA);
        return "kayit-2Demo";
    }

    public String standartOdaTut() {
        setOdaTipi("standart");
         toplamUcret.ucretEkle(toplamUcret.STANDART);
        return "kayit-2Demo";
    }

    public String luxSuitOdaTut() {
        setOdaTipi("luxSuit");
         toplamUcret.ucretEkle(toplamUcret.LUXSUIT);
        return "kayit-2Demo";
    }

    public String luxStandartOdaTut() {
        setOdaTipi("luxStandart");
         toplamUcret.ucretEkle(toplamUcret.LUXSTANDART);
        return "kayit-2Demo";
    }

    public String deluxSuitOdaTut() {
        setOdaTipi("deluxSuit");
         toplamUcret.ucretEkle(toplamUcret.DELUXSUIT);
        return "kayit-2Demo";
    }

    public String deluxStandartOdaTut() {
        setOdaTipi("deluxStandart");
         toplamUcret.ucretEkle(toplamUcret.DELUXSTANDART);
        return "kayit-2Demo";
    }


    /*bunlar getter ve setterlar*/
    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyAdi() {
        return soyAdi;
    }

    public void setSoyAdi(String soyAdi) {
        this.soyAdi = soyAdi;
    }

    public String getTcKimlik() {
        return tcKimlik;
    }

    public void setTcKimlik(String tcKimlik) {
        this.tcKimlik = tcKimlik;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getKisiSayisi() {
        return kisiSayisi;
    }

    public void setKisiSayisi(int kisiSayisi) {
        this.kisiSayisi = kisiSayisi;
    }

    public String getOdaTipi() {
        return odaTipi;
    }

    public void setOdaTipi(String odaTipi) {
        this.odaTipi = odaTipi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
    
    

    public Ucretler getToplamUcret() {
        return toplamUcret;
    }

    public void setToplamUcret(Ucretler toplamUcret) {
        this.toplamUcret = toplamUcret;
    }

    public String getSorgu() {
        return sorgu;
    }

    public void setSorgu(String sorgu) {
        this.sorgu = sorgu;
    }
    

}
