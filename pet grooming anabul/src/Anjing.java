public class Anjing extends Hewan {
    public int hitungBiaya(int nomorLayanan){
        if (nomorLayanan==1){
            return 150000;
        } else if (nomorLayanan==2){
            return 200000;
        } else {
            return 0;
        }
    }
}
