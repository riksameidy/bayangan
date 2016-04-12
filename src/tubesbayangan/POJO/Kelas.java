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
        mhs = new Mahasiswa[jumlahMhs];
        tugas = new Tugas[jumlahTugas];
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
            tugas[jumlahTugas++] = new Tugas(nama);
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

}

