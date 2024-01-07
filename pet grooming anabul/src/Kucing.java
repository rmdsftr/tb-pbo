public class Kucing extends Hewan {
    public int hitungBiaya(int nomorLayanan){
        if (nomorLayanan==1){
            return 100000;
        } else if (nomorLayanan==2){
            return 150000;
        } else {
            return 0;
        }
    }
}
