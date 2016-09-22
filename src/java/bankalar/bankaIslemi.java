package bankalar;

import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
//@SessionScoped
@RequestScoped
public class bankaIslemi {

    Bankalar otelHesabi = new Bankalar("1111111111111111", "bankasifresi");

    private String kulHesapNumarasi;
    private String kulHesapSifresi;
    String hata = "";
    String gonderilecek;
    int gonderilecekIntegerDeger;

    public String parametre() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        gonderilecek = params.get("ucret");
        this.gonderilecekIntegerDeger = Integer.parseInt(gonderilecek);
        paraTransferi();
        
        if(!this.hata.equals("basarılı")){
            return "kayit-3Demo";
        }
       
        return "kayit-4Demo";
    }
    public int bakiyeOgren(){
        Bankalar kullanıcıHesabı = new Bankalar(this.kulHesapNumarasi, this.kulHesapSifresi);
        return kullanıcıHesabı.getBakiyesi();
    }

    public void paraTransferi() {
        Bankalar kullanıcıHesabı = new Bankalar(this.kulHesapNumarasi, this.kulHesapSifresi);
        this.hata = otelHesabi.paraTransferi(kullanıcıHesabı, otelHesabi, gonderilecekIntegerDeger);
    }

    public String getKulHesapNumarasi() {
        return kulHesapNumarasi;
    }

    public void setKulHesapNumarasi(String kulHesapNumarasi) {
        this.kulHesapNumarasi = kulHesapNumarasi;
    }

    public String getKulHesapSifresi() {
        return kulHesapSifresi;
    }

    public void setKulHesapSifresi(String kulHesapSifresi) {
        this.kulHesapSifresi = kulHesapSifresi;
    }

    public String getHata() {
        return hata;
    }

    public void setHata(String hata) {
        this.hata = hata;
    }

    public String getGonderilecek() {
        return gonderilecek;
    }

    public void setGonderilecek(String gonderilecek) {
        this.gonderilecek = gonderilecek;
    }

}
