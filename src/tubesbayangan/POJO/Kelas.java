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
public class Kelas {
    private String nama;
    private MataKuliah mataKuliah;
    private Mahasiswa[] mhs;
    private Tugas[] tugas;
    private Kelompok[] kelompok;
    private int jumlahMhs;
    private int maxMhs;
    private int jumlahTugas;
    private int maxTugas;
    private int jumlahKelompok;
    private int maxKelompok;
    
    public Kelas() {
        nama = "default";
        maxKelompok = 5;
        maxMhs = 40;
        maxTugas = 20;
        mhs = new Mahasiswa[maxMhs];
        tugas = new Tugas[maxTugas];
        kelompok = new Kelompok[maxKelompok];
    }
    public Kelas(String nama) {
        this.nama = nama;
        maxKelompok = 5;
        maxMhs = 40;
        maxTugas = 20;
        mhs = new Mahasiswa[maxMhs];
        tugas = new Tugas[maxMhs];
        kelompok = new Kelompok[maxKelompok];
    }
    
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getMaxMhs() {
        return maxMhs;
    }
    public void setMaxMhs(int maxMhs) {
        this.maxMhs = maxMhs;
    }
    public int getMaxKelompok() {
        return maxKelompok;
    }
    public void setMaxKelompok(int maxKelompok) {
        this.maxKelompok = maxKelompok;
    }
    public void addKelompok(Kelompok k){
        if(jumlahKelompok<maxKelompok){
            kelompok[jumlahKelompok++] = k;
        }
    }
    public void addTugas(String nama){
        if(jumlahTugas<maxTugas){
            tugas[jumlahTugas] = new Tugas(nama);
            tugas[jumlahTugas].setStatusAssign(false);
            jumlahTugas++;
        }
    }
    public void addMahasiswa(Mahasiswa m){
        if(jumlahMhs<maxMhs){
            mhs[jumlahMhs++] = m;
        }
    }
    public void setMataKuliah(MataKuliah m){
        mataKuliah = m;
    }
    
    public MataKuliah getMataKuliah(){
        return mataKuliah;
    }
    public Kelompok getKelompok(int n){
        return kelompok[n];
    }
    public Mahasiswa getMahasiswa(int n){
        return mhs[n];
    }
    public Tugas getTugas(int n){
        return tugas[n];
    }

    public int getJumlahMhs() {
        return jumlahMhs;
    }

    public int getJumlahTugas() {
        return jumlahTugas;
    }

    public int getJumlahKelompok() {
        return jumlahKelompok;
    }

    public int getJumlahTugasIndividu(){
        int hasil=0;
        for(int i=0;i<jumlahTugas;i++){
            if(tugas[i].getIsTugasIndividu()){
                hasil++;
            }
        }
        return hasil;
    }
    
    public int idxTugas(String s){
        int hasil = -1;
        for(int i =0; i< jumlahTugas;i++){
            if(s.equals(tugas[i].getNamaTugas())){
                hasil = i;
            }
        }
        return hasil;
    
    }
    
    public String[] getAllTugasAssigned(){
        if(jumlahTugas==0){
            return null;
        }
        else{
        String[] temp = new String[jumlahTugas];
        int jum = 0;
        for(int i=0;i<jumlahTugas;i++){
           if(tugas[i].getStatusAssign()){
            temp[i] = tugas[i].getNamaTugas();
            jum++;
           }
        }
        if(jum==0){return null;}
        else{
        return temp;
        }
        }
    }
    
    public String[] getAllTugasnotAssigned(){
        if(jumlahTugas==0){
            return null;
        }
        else{
        String[] temp = new String[jumlahTugas];
        int jum=0;
        for(int i=0;i<jumlahTugas;i++){
           if(!tugas[i].getStatusAssign()){
            temp[i] = tugas[i].getNamaTugas();
            jum++;
           }
        }
        if(jum==0){return null;}
        else{
        return temp;
        }
       
        }
    }
    
    public int idxKelompok(int noKelompok){
        int idx = -1;
        for(int i=0;i<jumlahKelompok;i++){
            if(noKelompok==kelompok[i].getNoKelompok()){
                idx = i;
            }
        }
        return idx;
    
    }
    
    public int idxMhs(long nim){
        int idx = -1;
        for(int i=0;i<jumlahMhs;i++){
            if(nim==mhs[i].getNim()){
                idx = i;
            }
        }
        return idx;
    
    
    }
    
    public long[] getAllnim(){
        long[] temp;
        if(jumlahMhs==0){
            return null;
        }
        else{
            temp = new long[jumlahMhs];
            for (int i = 0; i < jumlahMhs; i++) {
                temp[i] = mhs[i].getNim();
            }
            return temp;
        }
    
    }
    
    public void deleteMhs(int n){
    if(jumlahMhs>0){
            if(n==jumlahMhs-1){
                mhs[n] = null;
                jumlahMhs--;
            }
            else if(jumlahMhs==1){
                mhs[n]=null;
                jumlahMhs--;
             }
            else{
                mhs[n]= null;
                for(int i=n;i<jumlahMhs-1;i++){
                    mhs[i] = mhs[i+1];
                }
                mhs[jumlahMhs-1] = null;
                jumlahMhs--;
            }
        }
    }
    public void deleteKelompok(int n){
    if(jumlahKelompok>0){
            if(n==jumlahKelompok-1){
                kelompok[n] = null;
                jumlahKelompok--;
            }
            else if(jumlahKelompok==1){
                kelompok[n]=null;
                jumlahKelompok--;
             }
            else{
                kelompok[n]= null;
                for(int i=n;i<jumlahKelompok-1;i++){
                    kelompok[i] = kelompok[i+1];
                }
                kelompok[jumlahKelompok-1] = null;
                jumlahKelompok--;
            }
        }
    }
    
    public int[] getAllKelompok(){
        int[] temp;
        if(jumlahKelompok==0){
            return null;
        }
        else{
            temp = new int[jumlahKelompok];
            for (int i = 0; i < jumlahKelompok; i++) {
                temp[i] = kelompok[i].getNoKelompok();
            }
            return temp;
        }
    
    }
    
    public Kelompok searchMhsInKelompok(long nim){
        Kelompok k=  null;
        for (int i = 0; i < jumlahKelompok; i++) {
            
            for (int j = 0; j < kelompok[i].getJumlahAnggota(); j++) {
                if(kelompok[i].getAnggota(j).getNim()==nim){
                    k = kelompok[i];
                }
            }
            
        }
        return k;
    }
    
    public void deleteMhsInKelompok(long nim){
        
        Kelompok k = searchMhsInKelompok(nim);
        if(k!=null){
                int idx = k.idxAnggota(nim);
                k.deleteAnggota(idx);
            if(nim==k.getKetua().getNim()){
                k.deleteKetua();
            }
        }
    
    }
    
    
    

}

