/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prediksi.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import prediksi.boundary.InterfaceManager;
import prediksi.entity.Cuaca;

/**
 *
 * @author afrilia
 */
public class PSOTsukamotoManager {
    int cerah, berawan, hujan_ringan, hujan;
    InterfaceManager InterfaceManager;
    private double cuaca;
    ArrayList<ArrayList> excel_dokumen;
    ArrayList<Cuaca> data_cuaca;
    ArrayList<ArrayList> rules;
    double [] f_anggota_lama;
    double [][] f_keanggotaan_cuaca, m_keanggotaan;
    String [] hasil_cuaca;
    double [] hasil_deffuzifikasi;
    double tingkat_akurasi;
   

    public PSOTsukamotoManager() {
        f_anggota_lama = new double[12];
        f_anggota_lama[0] = 26;
        f_anggota_lama[1] = 27.5;
        f_anggota_lama[2] = 29;
        f_anggota_lama[3] = 65;
        f_anggota_lama[4] = 75;
        f_anggota_lama[5] = 85;
        f_anggota_lama[6] = 1008.5;
        f_anggota_lama[7] = 1011;
        f_anggota_lama[8] = 1013.5;
        f_anggota_lama[9] = 2;
        f_anggota_lama[10] = 4.5;
        f_anggota_lama[11] = 7;
        cerah = 2;
        berawan = 8;
        hujan_ringan = 22;
        hujan = 14;
    }
        
    public void init_cuaca (ArrayList<Cuaca> data_cuaca)
    {
        this.data_cuaca = data_cuaca;
    }
        
    public void do_fuzzyfikasi(){
        DecimalFormat format = new DecimalFormat("####,##");
        Cuaca cuaca;
        
        f_keanggotaan_cuaca = new double[data_cuaca.size()][12];
            for (int i = 0; i < data_cuaca.size(); i++) {
                
//========================Fuzzyfikasi Suhu==========================================  
//      ++++++++++++++ Suhu Dingin ++++++++++++++++++++++++++++++++++++++++++++  
                  if(data_cuaca.get(i).getSuhu()<= f_anggota_lama[0])
                    {
                        f_keanggotaan_cuaca[i][0]=1;
                    }
                    else if(data_cuaca.get(i).getSuhu()>f_anggota_lama[0] && data_cuaca.get(i).getSuhu()<f_anggota_lama[1])
                        {
                            f_keanggotaan_cuaca[i][0] = Double.parseDouble(String.format("%.2f", (f_anggota_lama[1]-data_cuaca.get(i).getSuhu())/(f_anggota_lama[1]-f_anggota_lama[0])).replace(",", "."));
                        }
                    else
                    {
                        f_keanggotaan_cuaca[i][0] = 0;
                    }
                
//      +++++++++++++ Suhu Hangat ++++++++++++++++++++++++++++++++++++++++++++++                    
                if(data_cuaca.get(i).getSuhu()>f_anggota_lama[0] && data_cuaca.get(i).getSuhu() <= f_anggota_lama[1]){
                     f_keanggotaan_cuaca[i][1] = Double.parseDouble(String.format("%.2f", (data_cuaca.get(i).getSuhu()-f_anggota_lama[0])/(f_anggota_lama[1]-f_anggota_lama[0])).replace(",", "."));
                }
                else if(data_cuaca.get(i).getSuhu()>f_anggota_lama[1] && data_cuaca.get(i).getSuhu()<=f_anggota_lama[i]){
                    f_keanggotaan_cuaca[i][1] = Double.parseDouble(String.format("%.2f", (f_anggota_lama[2]-data_cuaca.get(i).getSuhu())/(f_anggota_lama[2]-f_anggota_lama[1])).replace(",", "."));
                }
                else{
                    f_keanggotaan_cuaca[i][1]= 0;
                }
                
//      +++++++++++++ Suhu Panas ++++++++++++++++++++++++++++++++++++++++++++++                 
                if(data_cuaca.get(i).getSuhu()<=f_anggota_lama[1]){
                    f_keanggotaan_cuaca[i][2] = 0;
                }
                else if(data_cuaca.get(i).getSuhu()>f_anggota_lama[1] && data_cuaca.get(i).getSuhu()<=f_anggota_lama[2]){
                    f_keanggotaan_cuaca[i][2] = Double.parseDouble(String.format("%.2f", (data_cuaca.get(i).getSuhu()-f_anggota_lama[1])/(f_anggota_lama[2]-f_anggota_lama[1])).replace(",", "."));
                }
                else{
                    f_keanggotaan_cuaca[i][2] = 1;
                }
                
//      +++++++++++++ Kelembaban Dry ++++++++++++++++++++++++++++++++++++++++++++++ 
                if(data_cuaca.get(i).getKelembaban() <= f_anggota_lama[3]){
                    f_keanggotaan_cuaca[i][3] = 1;
                }
                else if(data_cuaca.get(i).getKelembaban()>f_anggota_lama[3] && data_cuaca.get(i).getKelembaban()<f_anggota_lama[4]){
                    f_keanggotaan_cuaca[i][3] = Double.parseDouble(String.format("%.2f", (f_anggota_lama[4]-data_cuaca.get(i).getKelembaban())/(f_anggota_lama[4]-f_anggota_lama[3])).replace(",", "."));
                }
                else{
                    f_keanggotaan_cuaca[i][3] = 0;
                }
                
//      +++++++++++++ Kelembaban Wet ++++++++++++++++++++++++++++++++++++++++++++++ 
                if(data_cuaca.get(i).getKelembaban()> f_anggota_lama[3] && data_cuaca.get(i).getKelembaban() <= f_anggota_lama[4]){
                    f_keanggotaan_cuaca[i][4] = Double.parseDouble(String.format("%.2f", (data_cuaca.get(i).getKelembaban()-f_anggota_lama[3])/(f_anggota_lama[4]-f_anggota_lama[3])).replace(",", "."));
                }
                else if(data_cuaca.get(i).getKelembaban()>f_anggota_lama[4] && data_cuaca.get(i).getKelembaban()<=f_anggota_lama[5]){
                    f_keanggotaan_cuaca[i][4] = Double.parseDouble(String.format("%.2f", (f_anggota_lama[5]-data_cuaca.get(i).getKelembaban())/(f_anggota_lama[5]-f_anggota_lama[4])).replace(",", "."));
                }
                else{
                    f_keanggotaan_cuaca[i][4] = 0;
                }
                
//      +++++++++++++ Kelembaban Moist ++++++++++++++++++++++++++++++++++++++++++++++ 
                if(data_cuaca.get(i).getKelembaban()<=f_anggota_lama[4]){
                    f_keanggotaan_cuaca[i][5] = 0;
                }
                else if(data_cuaca.get(i).getKelembaban()>f_anggota_lama[4] && data_cuaca.get(i).getKelembaban()<=f_anggota_lama[5]){
                    f_keanggotaan_cuaca[i][5] = Double.parseDouble(String.format("%.2f", (data_cuaca.get(i).getKelembaban()-f_anggota_lama[4])/(f_anggota_lama[5]-f_anggota_lama[4])).replace(",", "."));
                }
                else{
                    f_keanggotaan_cuaca[i][5] = 1;
                }

//      +++++++++++++ Tekanan Udara Rendah ++++++++++++++++++++++++++++++++++++++++++++++ 
                if(data_cuaca.get(i).getTekanan_udara()<= f_anggota_lama[6]){
                    f_keanggotaan_cuaca[i][6] = 1;
                }
                else if(data_cuaca.get(i).getTekanan_udara()>f_anggota_lama[6] && data_cuaca.get(i).getTekanan_udara()<f_anggota_lama[7]){
                    f_keanggotaan_cuaca[i][6] = Double.parseDouble(String.format("%.2f", (f_anggota_lama[7]-data_cuaca.get(i).getTekanan_udara())/(f_anggota_lama[7]-f_anggota_lama[6])).replace(",", "."));
                }
                else{
                    f_keanggotaan_cuaca[i][6] = 0;
                }
                
//      +++++++++++++ Tekanan Udara Sedang ++++++++++++++++++++++++++++++++++++++++++++++ 
                if(data_cuaca.get(i).getTekanan_udara()> f_anggota_lama[6] && data_cuaca.get(i).getTekanan_udara() <= f_anggota_lama[7]){
                    f_keanggotaan_cuaca[i][7] = Double.parseDouble(String.format("%.2f", (data_cuaca.get(i).getTekanan_udara()-f_anggota_lama[6])/(f_anggota_lama[7]-f_anggota_lama[6])).replace(",", "."));
                }
                else if(data_cuaca.get(i).getTekanan_udara()>f_anggota_lama[7] && data_cuaca.get(i).getTekanan_udara()<=f_anggota_lama[8]){
                    f_keanggotaan_cuaca[i][7] = Double.parseDouble(String.format("%.2f", (f_anggota_lama[8]-data_cuaca.get(i).getTekanan_udara())/(f_anggota_lama[8]-f_anggota_lama[7])).replace(",", "."));
                }
                else{
                    f_keanggotaan_cuaca[i][7] = 0;
                }
                
//      +++++++++++++ Tekanan Udara Tinggi ++++++++++++++++++++++++++++++++++++++++++++++ 
                if(data_cuaca.get(i).getTekanan_udara()<=f_anggota_lama[7]){
                    f_keanggotaan_cuaca[i][8] = 0;
                }
                else if(data_cuaca.get(i).getTekanan_udara()>f_anggota_lama[7] && data_cuaca.get(i).getTekanan_udara()<=f_anggota_lama[8]){
                    f_keanggotaan_cuaca[i][8] = Double.parseDouble(String.format("%.2f", (data_cuaca.get(i).getTekanan_udara()-f_anggota_lama[7])/(f_anggota_lama[8]-f_anggota_lama[7])).replace(",", "."));
                }
                else{
                    f_keanggotaan_cuaca[i][8] = 1;
                }

//      +++++++++++++ Kecapatan Angin Sedang ++++++++++++++++++++++++++++++++++++++++++++++ 
                if(data_cuaca.get(i).getKecepatan_angin()<= f_anggota_lama[9]){
                    f_keanggotaan_cuaca[i][9] = 1;
                }
                else if(data_cuaca.get(i).getKecepatan_angin()>f_anggota_lama[9] && data_cuaca.get(i).getKecepatan_angin()<f_anggota_lama[10]){
                    f_keanggotaan_cuaca[i][9] = Double.parseDouble(String.format("%.2f", (f_anggota_lama[10]-data_cuaca.get(i).getKecepatan_angin())/(f_anggota_lama[10]-f_anggota_lama[9])).replace(",", "."));
                }
                else{
                    f_keanggotaan_cuaca[i][9] = 0;
                }
                
//      +++++++++++++ Kecepatan Angin Kencang ++++++++++++++++++++++++++++++++++++++++++++++ 
                if(data_cuaca.get(i).getKecepatan_angin()> f_anggota_lama[9] && data_cuaca.get(i).getKecepatan_angin() <= f_anggota_lama[10]){
                    f_keanggotaan_cuaca[i][10] = Double.parseDouble(String.format("%.2f", (data_cuaca.get(i).getKecepatan_angin()-f_anggota_lama[9])/(f_anggota_lama[10]-f_anggota_lama[9])).replace(",", "."));
                }
                else if(data_cuaca.get(i).getKecepatan_angin()>f_anggota_lama[10] && data_cuaca.get(i).getKecepatan_angin()<=f_anggota_lama[11]){
                    f_keanggotaan_cuaca[i][10] = Double.parseDouble(String.format("%.2f", (f_anggota_lama[11]-data_cuaca.get(i).getKecepatan_angin())/(f_anggota_lama[11]-f_anggota_lama[10])).replace(",", "."));
                }
                else{
                    f_keanggotaan_cuaca[i][10] = 0;
                }
                
//      +++++++++++++ Kecepatan Angin Sangat Kencang ++++++++++++++++++++++++++++++++++++++++++++++ 
                if(data_cuaca.get(i).getKecepatan_angin()<=f_anggota_lama[10]){
                    f_keanggotaan_cuaca[i][11] = 0;
                }
                else if(data_cuaca.get(i).getKecepatan_angin()>f_anggota_lama[10] && data_cuaca.get(i).getKecepatan_angin()<=f_anggota_lama[11]){
                    f_keanggotaan_cuaca[i][11] = Double.parseDouble(String.format("%.2f", (data_cuaca.get(i).getKecepatan_angin()-f_anggota_lama[10])/(f_anggota_lama[11]-f_anggota_lama[10])).replace(",", "."));
                }
                else{
                    f_keanggotaan_cuaca[i][11] = 1;
                }
                
                //f_anggota_cuaca_cuaca.add(f_keanggotaan_cuaca);
            }
            System.out.println("Fuzzifikasi : ");
            for (int j = 0; j < data_cuaca.size(); j++) {
                System.out.print("Data "+(j+1)+" ");
                for (int k = 0; k < 12; k++) {
                    System.out.print(f_keanggotaan_cuaca[j][k]+" ");
                }
                 System.out.println();
            }
    }   
    
        
    public void init_rules (ArrayList rule)
    {
        this.rules = rule;
    }

    public void do_hitung_fuzzy_tsukamoto()
    {
        DecimalFormat format = new DecimalFormat("####,##");
        double [][] f_anggota_cuaca;
        double tukar;
       
        ArrayList<Double[][]> listm_keanggotan;
        f_anggota_cuaca = new double[f_keanggotaan_cuaca.length][f_keanggotaan_cuaca[0].length];
        
        for (int i = 0; i < data_cuaca.size(); i++) {
            for (int j = 0; j < 12; j++) {
                f_anggota_cuaca[i][j] = f_keanggotaan_cuaca[i][j];
            }
        }
        for (int i = 0; i < f_anggota_cuaca.length; i++) {
            m_keanggotaan = new double[rules.size()][rules.get(0).size()];
            //System.out.println("rule kolom : "+rules.get(0).size());
            for (int j = 0; j < rules.size(); j++) {
                double min = 10;
                for (int k = 0; k < rules.get(j).size(); k++) {
                    //if (l==1){
                        if (rules.get(j).get(k).equals("Cold")){
                            m_keanggotaan[j][k] = f_anggota_cuaca[i][0];
                        }
                        else if (rules.get(j).get(k).equals("Warm")){
                            m_keanggotaan[j][k] = f_anggota_cuaca[i][1];
                        }
                        else if (rules.get(j).get(k).equals("Hot")){
                            m_keanggotaan[j][k] = f_anggota_cuaca[i][2];
                        }
                        //System.out.println("");
                   // }
                   // else if (l==2){
                        if (rules.get(j).get(k).equals("Dry")){
                            m_keanggotaan[j][k] = f_anggota_cuaca[i][3];
                        }
                        else if (rules.get(j).get(k).equals("Wet")){
                            m_keanggotaan[j][k] = f_anggota_cuaca[i][4];
                        }
                        else if (rules.get(j).get(k).equals("Moist")){
                            m_keanggotaan[j][k] = f_anggota_cuaca[i][5];
                        }
                  //  }
                 //   else if (l==3){
                        if (rules.get(j).get(k).equals("Low")){
                            m_keanggotaan[j][k] = f_anggota_cuaca[i][6];
                        }
                        else if (rules.get(j).get(k).equals("Medium")){
                            m_keanggotaan[j][k] = f_anggota_cuaca[i][7];
                        }
                        else if (rules.get(j).get(k).equals("High")){
                            m_keanggotaan[j][k] = f_anggota_cuaca[i][8];
                        }                
                   // }
                  //  else if (l==4){
                        if (rules.get(j).get(k).equals("Sedang")){
                            m_keanggotaan[j][k] = f_anggota_cuaca[i][9];
                        }
                        else if (rules.get(j).get(k).equals("Kencang")){
                            m_keanggotaan[j][k] = f_anggota_cuaca[i][10];
                        }
                        else if (rules.get(j).get(k).equals("Skencang")){
                            m_keanggotaan[j][k] = f_anggota_cuaca[i][11];
                        }


                        if (k==4)
                        {
                            m_keanggotaan[j][k] = min;
                            min = m_keanggotaan[j][k];

                            tukar = min;
                            min = m_keanggotaan[j][k];
                            m_keanggotaan[j][k] = tukar;
                            //System.out.println("min result : "+m_keanggotaan[k][l]);
                        }

                        else{

                            if (min > m_keanggotaan[j][k]) {
                                min = m_keanggotaan[j][k];
                                tukar = min;
                                min = m_keanggotaan[j][k];
                                m_keanggotaan[j][k] = tukar;
                            }
                            //System.out.println("nilai min" + min);
                        }
                        //System.out.println("Rule "+(j+1)+" : "+rules.get(j).get(k)+" f_anggota : "+m_keanggotaan[j][k]);
                }
            }
        }

        
    }

        //System.out.println("daftar rule : "+rules.size());
            

   
    public double agregasi ()
    {
        DecimalFormat format = new DecimalFormat("####,##");
        Cuaca cuaca;
        ArrayList<double[][]> listm_keanggotaan;
        String[] hasil_cuaca;
        double[][] m_keanggotan_rule;
        double total, z, x1, x2, x3, x4;
        double tingkat_akurasi;
        
        tingkat_akurasi = 0;
        hasil_cuaca = new String[data_cuaca.size()];
        total = 0;
        z = 0;
        x1 = 0;
        x2 = 0;
        x3 = 0;
        x4 = 0; 
        
        m_keanggotan_rule = new double[m_keanggotaan.length][m_keanggotaan[0].length];
        System.out.println("m_keanggotaan rule1 : " + m_keanggotaan.length);
        System.out.println("m_keanggotaan rule2 : " + m_keanggotaan[0].length);
        
        
        for (int i = 0; i < m_keanggotaan.length; i++) {
            for (int j = 0; j < m_keanggotaan[0].length; j++) {
                m_keanggotan_rule[i][j] = m_keanggotaan[i][j];
            }
        }
        for (int i = 0; i < data_cuaca.size(); i++) {
            for (int j = 0; j < m_keanggotan_rule.length; j++) {
                if (data_cuaca.get(i).getKeadaan_cuaca().equals("Rain"))
                    {
                        z = z + (m_keanggotan_rule[j][4]*hujan);
                    }
                    else if (data_cuaca.get(i).getKeadaan_cuaca().equals("Light rain"))
                    {
                        z = z + (m_keanggotan_rule[j][4]*hujan_ringan);
                    }
                    else if (data_cuaca.get(i).getKeadaan_cuaca().equals("Cloudy"))
                    {
                        z = z + (m_keanggotan_rule[j][4]*berawan);
                    }
                    else
                    {
                        z = z + (m_keanggotan_rule[j][4]*cerah);
                    }
                    
                    total = total + m_keanggotan_rule[j][4];
                    
            }
            System.out.println("total = " +total);
            z = Double.parseDouble(String.format("%.2f", z).replace(",", "."));
                total = Double.parseDouble(String.format("%.2f", total).replace(",", "."));
                
                System.out.println("nilai z : " + z);
                System.out.println("nilai total : " + total);
                
                z = z/total;
                System.out.println("nilai z : " + z);
                
                if(z <= 0 && z <= 4){
                    if (z<=2){
                        x1 = 1;
                    }
                    else if (z>2 && z <4){
                        x1 = (4-z)/(4-2);
                    }
                    else{
                        x1 = 0;
                    }
                }
                
                else if(z >=2 && z <= 14){
                    if (z > 2 && z<=8){
                        x2 = (z-2)/(8-2);
                    }
                    else if  (z > 8 && z <= 14){
                        x2 = (14-z)/(14-8);
                    }
                    else{
                        x2 = 0;
                    }
                }
                
                else if(z > 6 && z <= 22){
                    if (z > 6 && z<= 14){
                        x3 = (z-6)/(14-6);
                    }
                    else if (z>14 && z<=22){
                        x3 = (22-z)/(22-14);
                    }
                    else{
                        x3 = 0;
                    }
                }
                else {
                    if (z>=14){
                        x4 = 0;
                    }
                    else if (z >14 && z <=22){
                        x4 = (z-14)/(22/14);
                    }
                    else{
                        x4 = 1;
                    }
                }
                
                if (x1>x2 && x1>x3 && x1>x4){
                    hasil_cuaca[i] = "Sunny";
                    
                }
                else if ( x2> x1 && x2>x3 && x2>x4){
                    hasil_cuaca[i] = "Cloudy";
                }
                else if ( x3> x1 && x3>x2 && x3>x4){
                    hasil_cuaca[i] = "Light Rain";
                }
                else {
                    hasil_cuaca[i] = "Rain";
                }
                System.out.println(hasil_cuaca[i]);
                if (data_cuaca.get(i).getKeadaan_cuaca().equals(hasil_cuaca[i])){
                   tingkat_akurasi++;
                }
        }
            tingkat_akurasi = (tingkat_akurasi/data_cuaca.size())*100;
            System.out.println("tingkat akurasi = " + tingkat_akurasi);
            return tingkat_akurasi;
        }
        
}