
package rezarvasyon;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import login.loginIslemi;


@ManagedBean
@SessionScoped
public class navigasyon {
    String odaAraHatasi1;
    boolean odaHatasiVarMi=false;
    String  anasayfaAktif="isaretle";
    String odalarAktif="isaretleme";
    
    @ManagedProperty(value = "#{check}")
    public check checkNesnesi;

    public String getOdaAraHatasi1() {
        return odaAraHatasi1;
    }

    public void setOdaAraHatasi1(String odaAraHatasi1) {
        this.odaAraHatasi1 = odaAraHatasi1;
    }

    public check getCheckNesnesi() {
        return checkNesnesi;
    }

    public void setCheckNesnesi(check checkNesnesi) {
        this.checkNesnesi = checkNesnesi;
    }
    
    public String anasayfayaGit(){
        anasayfaAktif="isaretle";
        odalarAktif="isaretleme";
        return "kulAnasayfa.xhtml?faces-redirect=true";
    } 
     @ManagedProperty(value = "#{loginIslemi}")
    public loginIslemi loginNesnesi;
    public String adminSayfasinaGit(){
        if(loginNesnesi.isLoggedIn()){
            return "secured/adminAnasayfasi.xhtml?faces-redirect=true";
        }
        
        return "logIn?faces-redirect=true";
    }
    public String odalarSayfasinaGit(){
        anasayfaAktif="isaretleme";
        odalarAktif="isaretle";
        return "odalar.xhtml?faces-redirect=true";
    }
    
    public String odaArayaGit(){
        String ilkDeger=checkNesnesi.getCheckIn();
        String ilkDegerYil=ilkDeger.substring(6, ilkDeger.length());
        String ilkDegerAy=ilkDeger.substring(3, 5);
        String ilkDegerGun=ilkDeger.substring(0, 2);
        String sonDeger=checkNesnesi.getCheckOut();
        String sonDegerYil=sonDeger.substring(6, sonDeger.length());
        String sonDegerAy=sonDeger.substring(3, 5);
        String sonDegerGun=sonDeger.substring(0, 2);
        
        int ilkYil=Integer.valueOf(ilkDegerYil);
        int ilkAy=Integer.valueOf(ilkDegerAy);
        int ilkGun=Integer.valueOf(ilkDegerGun);
        int sonYil=Integer.valueOf(sonDegerYil);
        int sonAy=Integer.valueOf(sonDegerAy);
        int sonGun=Integer.valueOf(sonDegerGun);
        
        if(sonYil<ilkYil){
            odaAraHatasi1="Geçen seneden rezarvasyon alma";
            odaHatasiVarMi=true;
            return "kulAnasayfa.xhtml?faces-redirect=true";
        }
        else if(sonAy<ilkAy){
            odaAraHatasi1="Geçen aya rezarvasyon alma";
             odaHatasiVarMi=true;
            return "kulAnasayfa.xhtml?faces-redirect=true";
        }
        else if(sonGun<=ilkGun){
            odaAraHatasi1="Geçen günden rezarvasyon alma";
             odaHatasiVarMi=true;
            return "kulAnasayfa.xhtml?faces-redirect=true";
        }
        odaHatasiVarMi=false;
        if(odaHatasiVarMi=true){
            odaAraHatasi1="";
        }
        return "kayit-1Demo.xhtml?faces-redirect=true";
    }

    public String getAnasayfaAktif() {
        return anasayfaAktif;
    }

    public void setAnasayfaAktif(String anasayfaAktif) {
        this.anasayfaAktif = anasayfaAktif;
    }

    public String getOdalarAktif() {
        return odalarAktif;
    }

    public void setOdalarAktif(String odalarAktif) {
        this.odalarAktif = odalarAktif;
    }

    public loginIslemi getLoginNesnesi() {
        return loginNesnesi;
    }

    public void setLoginNesnesi(loginIslemi loginNesnesi) {
        this.loginNesnesi = loginNesnesi;
    }
    
    
    
}
