/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesbayangan.POJO;

/**
 *
 * @author ASUS
 */
public class Kelompok {
    private int noKelompok;
    private int jumlahAnggota;
    private int jumlahTugas;
    private int maxTugas;
    private int maxAnggota;
    private Mahasiswa[] anggota;
    private Mahasiswa ketua;
    private Tugas[] tugas;
    
    public Kelompok(){
        maxAnggota=5;
        maxTugas = 5;
        anggota = new Mahasiswa[maxAnggota];
        tugas = new Tugas[maxTugas];
    }

    public Kelompok(int noKelompok) {
        this.noKelompok = noKelompok;
        maxAnggota=5;
        maxTugas = 5;
        anggota = new Mahasiswa[maxAnggota];
        tugas = new Tugas[maxTugas];
    }
    
    public Kelompok(int noKelompok, int maxAnggota){
         this.noKelompok = noKelompok;
         this.maxAnggota = maxAnggota;
         anggota = new Mahasiswa[maxAnggota];
         maxTugas = 5;
         tugas = new Tugas[maxTugas];
    
    }
    

    public int getNoKelompok() {
        return noKelompok;
    }
    public void setNoKelompok(int noKelompok) {
        this.noKelompok = noKelompok;
    }
    public int getMaxTugas() {
        return maxTugas;
    }
    public void setMaxTugas(int maxTugas) {
        this.maxTugas = maxTugas;
    }
    public int getMaxAnggota() {
        return maxAnggota;
    }
    public void setMaxAnggota(int maxAnggota) {
        this.maxAnggota = maxAnggota;
    }
    public Mahasiswa getKetua() {
        return ketua;
    }
    public void setKetua(int n) {
        ketua = anggota[n];
    }
    public void addTugas(Tugas t){
        if(jumlahTugas<maxTugas){
            tugas[jumlahTugas++] = t;
        }
    }
    public void doTugas(int t, String jawaban, int noSoal){
        if(tugas[t].getIsTugasIndividu()==false){
        tugas[t].addJawaban(jawaban,noSoal);
        }
    }
    public void submitTugas(int t){
        tugas[t].setStatusDikerjakan(true);
    }
    public Mahasiswa getAnggota(int n){
        return anggota[n];
    }
    public Tugas getTugas(int n){
        return tugas[n];
    }
    
    public int indeksAnggota(Mahasiswa m){
        int idx=-1;
        for (int i=0;i<jumlahAnggota;i++){
            if(m==anggota[i]){
                idx = i;
            }
        }
        return idx;
    }
    public void addAnggota(Mahasiswa m){
        if(jumlahAnggota<maxAnggota){
            anggota[jumlahAnggota++] = m;
        }
    }
    public void deleteAnggota(int n){
    if(jumlahAnggota>0){
            if(n==jumlahAnggota-1){
                anggota[n] = null;
                jumlahAnggota--;
            }
            else if(jumlahAnggota==1){
                anggota[n]=null;
                jumlahAnggota--;
             }
            else{
                anggota[n]= null;
                for(int i=n;i<jumlahAnggota-1;i++){
                    anggota[i] = anggota[i+1];
                }
                anggota[jumlahAnggota-1] = null;
                jumlahAnggota--;
            }
        }
    }
    
    public long[] getAllnimMhs(){
        long[] temp;
        if(jumlahAnggota==0){
            return null;
        }
        else{
        temp = new long[jumlahAnggota];
            for (int i = 0; i < jumlahAnggota; i++) {
                temp[i] = anggota[i].getNim(); 
            }
            return temp;
        }
        
        
    
    }
}
