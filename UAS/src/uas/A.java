
package uas;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.Period;

public class A {
        String pil;
        long tusia;
        long tanak;
        long tsua;
        ArrayList<String> Nama = new ArrayList<>();
        ArrayList<String> Alamat = new ArrayList<>();
        ArrayList<Date> Tgl = new ArrayList<>();
        ArrayList<Integer> Kode = new ArrayList<>();
        ArrayList<String> Gol = new ArrayList<>();
        ArrayList<Integer> Status = new ArrayList<>();
        ArrayList<Integer> Anak = new ArrayList<>();
        ArrayList<Integer> Umur = new ArrayList<>();
        Scanner in = new Scanner(System.in);
    
    void Menu()throws ParseException {
        System.out.println("------------------");
        System.out.println("Menu :");
        System.out.println("------------------");
        System.out.println("1. Tambah Data");
        System.out.println("2. Hapus Data");
        System.out.println("3. Cari Data");
        System.out.println("4. Lihat Data");
        System.out.println("5. Keluar");
        System.out.print  ("Pilihan Menu : ");
        String Menu = in.nextLine();
        switch (Menu){
            case "1":
                TambahData();
                break;
            case "2":
                HapusData();
                break;
            case "3":
                CariData();
                break;
            case "4":
                LihatData();
                break;
            case "5":
                System.exit(0);
            default:
                Menu();
        }
}   
    void TambahData()throws ParseException{
        System.out.println("-------------------------");
        System.out.println("Tambah Data   : ");
        System.out.println("-------------------------");
        System.out.print  ("Masukkan Kode Karyawan : ");
        int kode = in.nextInt();
        in.nextLine();
        System.out.print  ("Masukkan Nama Karyawan : ");
        String nama = in.nextLine();
        System.out.print  ("Masukkan Alamat  : ");
        String alamat = in.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat( "dd-mm-yyyy" );
        System.out.print  ("Masukkan Tgl Lahir (dd-mm-yyyy): ");
        String tgl = in.nextLine();
        Date date = sdf.parse(tgl);
        Tgl.add(date);
        LocalDate ld = new java.sql.Date( date.getTime())
                                .toLocalDate();
        LocalDate x = LocalDate.now();
        Period umur = Period.between(ld, x);
        int usia = umur.getYears();
        while(true){
            System.out.print ("Masukkan Golongan [A/B/C/D]  : ");
            this.pil = in.next();
            if(!("A".equals(this.pil)) & !("B".equals(this.pil)) & !("C".equals(this.pil)) & !("D".equals(this.pil))){
                System.out.println("Masukan Sesuai Pilihan!");
            }
            else{
                break;
            }
        } 
        System.out.print ("Masukkan Status Menikah (0 : Belum Menikah / 1 : Sudah Menikah) : ");
        int status = in.nextInt();
            if (status == 1) {
            System.out.print ("Masukkan Jumlah Anak : " );
            int anak = in.nextInt();
            Anak.add(anak);
            }
            else{
            Anak.add (0);
            }
        Kode.add(kode);
        Nama.add(nama);
        Alamat.add(alamat);
        Gol.add(this.pil);
        Status.add(status);
        Umur.add(usia);
            System.out.println ("Pilih Sub Menu : " );
            System.out.println (" 1. Kembali ke menu utama " );
            System.out.println (" 2. Tambah Data Kembali " );
            System.out.print   ("Menu Pilihan : " );
        int sub = in.nextInt();
        in.nextLine();
        if (sub == 1) {
            Menu();
    }
        else if (sub == 2) {
            TambahData();
        }
}
    
    void HapusData()throws ParseException{
        System.out.println("----------------");
        System.out.println("Hapus Data   :  ");
        System.out.println("----------------");
        System.out.print  ("Masukkan Kode Karyawan  : ");
        int cari_Kode = in.nextInt();
        int index_pencarian = Kode.indexOf(cari_Kode);
            if (index_pencarian == -1){
            System.out.println("Kode Tidak ditemukan");
            System.out.println ("Pilih Sub Menu : " );
            System.out.println (" 1. Kembali ke menu utama " );
            System.out.println (" 2. Hapus Data Kembali "   );
            System.out.print   ("Menu Pilihan : " );
                int sub = in.nextInt();
            in.nextLine();
            if (sub == 1) {
                Menu();
        }
            else if (sub == 2) {
                HapusData();
            }
        }
            else{
                System.out.println("Data Telah dihapus");
                if (Status.get(index_pencarian) == 0){
                Nama.remove(index_pencarian);
                Alamat.remove(index_pencarian);
                Kode.remove(index_pencarian);
                Tgl.remove(index_pencarian);
                Gol.remove(index_pencarian);
                Status.remove(index_pencarian); 
                }
                System.out.println ("Pilih Sub Menu : " );
                System.out.println (" 1. Kembali ke menu utama " );
                System.out.println (" 2. Hapus Data Kembali "   );
                System.out.print   ("Menu Pilihan : " );
                int sub = in.nextInt();
            in.nextLine();
            if (sub == 1) {
                Menu();
        }
            else if (sub == 2) {
                HapusData();
            }
                else{
                Nama.remove(index_pencarian);
                Alamat.remove(index_pencarian);
                Kode.remove(index_pencarian);
                Tgl.remove(index_pencarian);
                Gol.remove(index_pencarian);
                Status.remove(index_pencarian); 
                Anak.remove(index_pencarian);
                }        
    }
            }
    void CariData()throws ParseException{
        System.out.println("----------------");
        System.out.println("Cari Data   :   ");
        System.out.println("----------------");
        System.out.print  ("Masukan Kode Karyawan : ");
        int cari_code = in.nextInt();
        int index_pencarian = Kode.indexOf(cari_code);
        System.out.println("========================");
        System.out.println("DATA PROFILE KARYAWAN");
        System.out.println("------------------------");
        System.out.println("Kode Karyawan   : " + Kode.get(index_pencarian));
        System.out.println("Nama Karyawan   : " + Nama.get(index_pencarian));
        System.out.println("Golongan        : " + Gol.get(index_pencarian));
        System.out.println("Usia            : " + Umur.get(index_pencarian));
        System.out.println("Status Menikah  : " + Status.get(index_pencarian));
        System.out.println("Jumlah Anak     : " + Anak.get(index_pencarian));
        System.out.println("----------------------------");
        Golongan g = new Golongan();
        if ("A".equals(Gol.get(index_pencarian))){
            System.out.println("Gaji Pokok            : Rp  " + g.golA());
            this.tsua =  (long) (g.golA()* 0.1);
            System.out.println("Tunjangan Istri/suami : Rp " + this.tsua);
            if (Umur.get(index_pencarian) > 30){
                this.tusia = (long) (g.golA() * 0.15);
                System.out.println("Tunjangan Pegawai : Rp " + this.tusia);
            }
            else{
                this.tusia = g.golA()*0;
               
                System.out.println("Tunjangan Pegawai  : Rp " + this.tusia );
            }
            if (Anak.get(index_pencarian) > 0){
                this.tanak = (long) (g.golA() *0.5* Anak.get(index_pencarian));
                System.out.println("Tunjangan Anak     : Rp " + this.tanak);
            }
            else{
                this.tanak = (long) (g.golA() * 0);
                System.out.println("Tunjangan Anak     : Rp " + this.tanak);
            }
            System.out.println("-----------------------------");
            long kotor = g.golA() + this.tusia + this.tsua + this.tanak;
            System.out.println("Gaji Kotor      : Rp " + kotor);
            long pot = (long) (0.025 * kotor);
            System.out.println("Potongan        : Rp " + pot);
            System.out.println("-----------------------------");
            long bersih = kotor-pot;
            System.out.println("Gaji Bersih     : Rp " + bersih);
            System.out.println ("Pilih Sub Menu : " );
            System.out.println (" 1. Kembali ke menu utama " );
            System.out.print   ("Menu Pilihan : " );
            int sub = in.nextInt();
            in.nextLine();
            if (sub == 1) {
                Menu();
        }
        }
        if ("B".equals(Gol.get(index_pencarian))){
            System.out.println("Gaji Pokok            : Rp  " + g.golB());
            this.tsua =  (long) (g.golB()* 0.1);
            System.out.println("Tunjangan Istri/suami : Rp " + this.tsua);
            if (Umur.get(index_pencarian) > 30){
                this.tusia = (long) (g.golB() * 0.15);
                System.out.println("Tunjangan Pegawai : Rp " + this.tusia);
            }
            else{
                this.tusia = g.golB()*0;
               
                System.out.println("Tunjangan Pegawai : Rp " + this.tusia );
            }
            if (Anak.get(index_pencarian) > 0){
                this.tanak = (long) (g.golB() *0.5* Anak.get(index_pencarian));
                System.out.println("Tunjangan Anak    : Rp " + this.tanak);
            }
            else{
                this.tanak = (long) (g.golB() * 0);
                System.out.println("Tunjangan Anak    : Rp " + this.tanak);
            }
            System.out.println("-----------------------------");
            long kotor = g.golB() + this.tusia + this.tsua + this.tanak;
            System.out.println("Gaji Kotor      : Rp " + kotor);
            long pot = (long) (0.025 * kotor);
            System.out.println("Potongan        : Rp " + pot);
            System.out.println("-----------------------------");
            long bersih = kotor-pot;
            System.out.println("Gaji Bersih     : Rp " + bersih);
            System.out.println ("Pilih Sub Menu : " );
            System.out.println (" 1. Kembali ke menu utama " );
            System.out.print   ("Menu Pilihan : " );
            int sub = in.nextInt();
            in.nextLine();
            if (sub == 1) {
                Menu();
        }
    }
        if ("C".equals(Gol.get(index_pencarian))){
            System.out.println("Gaji Pokok            : Rp  " + g.golC());
            this.tsua =  (long) (g.golC()* 0.1);
            System.out.println("Tunjangan Istri/suami : Rp " + this.tsua);
            if (Umur.get(index_pencarian) > 30){
                this.tusia = (long) (g.golC() * 0.15);
                System.out.println("Tunjangan Pegawai : Rp " + this.tusia);
            }
            else{
                this.tusia = g.golC()*0;
               
                System.out.println("Tunjangan Pegawai : Rp " + this.tusia );
            }
            if (Anak.get(index_pencarian) > 0){
                this.tanak = (long) (g.golC() *0.5* Anak.get(index_pencarian));
                System.out.println("Tunjangan Anak    : Rp " + this.tanak);
            }
            else{
                this.tanak = (long) (g.golC() * 0);
                System.out.println("Tunjangan Anak    : Rp " + this.tanak);
            }
            System.out.println("-----------------------------");
            long kotor = g.golC() + this.tusia + this.tsua + this.tanak;
            System.out.println("Gaji Kotor      : Rp " + kotor);
            long pot = (long) (0.025 * kotor);
            System.out.println("Potongan        : Rp " + pot);
            System.out.println("-----------------------------");
            long bersih = kotor-pot;
            System.out.println("Gaji Bersih     : Rp " + bersih);
            System.out.println ("Pilih Sub Menu : " );
            System.out.println (" 1. Kembali ke menu utama " );
            System.out.print   ("Menu Pilihan : " );
            int sub = in.nextInt();
            in.nextLine();
            if (sub == 1) {
                Menu();
        }
    }
        if ("D".equals(Gol.get(index_pencarian))){
            System.out.println("Gaji Pokok            : Rp  " + g.golD());
            this.tsua =  (long) (g.golD()* 0.1);
            System.out.println("Tunjangan Istri/suami : Rp " + this.tsua);
            if (Umur.get(index_pencarian) > 30){
                this.tusia = (long) (g.golD() * 0.15);
                System.out.println("Tunjangan Pegawai : Rp " + this.tusia);
            }
            else{
                this.tusia = g.golD()*0;
               
                System.out.println("Tunjangan Pegawai : Rp " + this.tusia );
            }
            if (Anak.get(index_pencarian) > 0){
                this.tanak = (long) (g.golD() *0.5* Anak.get(index_pencarian));
                System.out.println("Tunjangan Anak    : Rp " + this.tanak);
            }
            else{
                this.tanak = (long) (g.golD() * 0);
                System.out.println("Tunjangan Anak    : Rp " + this.tanak);
            }
            System.out.println("-----------------------------");
            long kotor = g.golD() + this.tusia + this.tsua + this.tanak;
            System.out.println("Gaji Kotor      : Rp " + kotor);
            long pot = (long) (0.025 * kotor);
            System.out.println("Potongan        : Rp " + pot);
            System.out.println("-----------------------------");
            long bersih = kotor-pot;
            System.out.println("Gaji Bersih     : Rp " + bersih);
            System.out.println ("Pilih Sub Menu : " );
            System.out.println (" 1. Kembali ke menu utama " );
            System.out.print   ("Menu Pilihan : " );
            int sub = in.nextInt();
            in.nextLine();
            if (sub == 1) {
                Menu();
        }
    }
}
    void LihatData() throws ParseException {
        System.out.println("============================================================================");
        System.out.println("                               DATA KARYAWAN                                ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Kode Kary\t Nama Kary\t Gol\t Usia\t Status\t Jml Anak");
        System.out.println("----------------------------------------------------------------------------");
        for  (int i = 0; i < Kode.size(); i++){
        String stts_nikah = (Status.get(i) == 1) ? "Menikah" : "Belum";
        System.out.print(Kode.get(i) + " \t\t"  + "  " + Nama.get(i) + "\t\t" + "  " + Gol.get(i) + "\t" + "  "+ Umur.get(i) + "\t" + " "+ Status.get(i) + "\t" + " "+ Anak.get(i) + "\n");}
        System.out.println("----------------------------------------------------------------------------");
        System.out.println ("Jumlah Data : " + Kode.size());
        System.out.println ("Pilih Sub Menu : " );
        System.out.println (" 1. Kembali ke menu utama " );
        System.out.print   ("Menu Pilihan : " );
            int sub = in.nextInt();
            in.nextLine();
            if (sub == 1) {
                Menu();
            }
    }
}
   

