
package rezarvasyon;
            
public class Ucretler {
    public final int SUITODA=150;
    public final int STANDART=120;
    public final int LUXSUIT=200;
    public final int LUXSTANDART=180;
    public final int DELUXSUIT=277;
    public final int DELUXSTANDART=220;
    
    public int toplamUcret=0;
    
    public void ucretEkle(int oda_tipi){
        this.toplamUcret+=oda_tipi;
    }
    public void ucretCikar(int oda_tipi){
        this.toplamUcret-=oda_tipi;
    }

    public int getToplamUcret() {
        return toplamUcret;
    }
    public int topamUcretiSifirla(){
        toplamUcret=0;
        return toplamUcret;
    }
}
