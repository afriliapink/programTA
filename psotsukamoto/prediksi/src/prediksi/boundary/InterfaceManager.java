/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prediksi.boundary;

import java.util.ArrayList;
import prediksi.Controller.TsukamotoManager;
import prediksi.controller.DokumenManager;
import prediksi.controller.PSOTsukamotoManager;
import prediksi.entity.Cuaca;

/**
 *
 * @author afrilia
 */
public class InterfaceManager {
    ArrayList<ArrayList> excel_dokumen;
    ArrayList<ArrayList> rules_dokumen;
    DokumenManager excel_manager;
    ArrayList<Cuaca> data_cuaca;
    String[][] rule;
    TsukamotoManager TM;
    PSOTsukamotoManager F;
    
    public InterfaceManager() {
    }
    
    public ArrayList<Cuaca> muat_data_excel(String path){
        int baris_excel, kolom_excel;
        Cuaca cuaca;
        
        excel_manager = new DokumenManager();
        excel_dokumen = excel_manager.getDataExcel(path);
        
        baris_excel = excel_dokumen.size()-1;
        kolom_excel = excel_dokumen.get(0).size();
        
        data_cuaca = new ArrayList<>();
        
        for (int i = 0; i < baris_excel; i++) {
            cuaca = new Cuaca();
            
            cuaca.setNo(Double.parseDouble(excel_dokumen.get(i+1).get(0).toString()));
            cuaca.setTanggal(excel_dokumen.get(i+1).get(1).toString());
            cuaca.setSuhu(Double.parseDouble(excel_dokumen.get(i+1).get(2).toString()));
            cuaca.setKelembaban(Double.parseDouble(excel_dokumen.get(i+1).get(3).toString()));
            cuaca.setTekanan_udara(Double.parseDouble(excel_dokumen.get(i+1).get(4).toString()));
            cuaca.setKecepatan_angin(Double.parseDouble(excel_dokumen.get(i+1).get(5).toString()));
            cuaca.setKeadaan_cuaca(excel_dokumen.get(i+1).get(6).toString());
            data_cuaca.add(cuaca);
        }
        return data_cuaca;
        
        
    }
    
    public ArrayList<ArrayList> muat_rules(){
        ArrayList<ArrayList> dokumen;
        ArrayList<String> kolom_list;
        
        int baris_excel, kolom_excel;
        String path = "E:\\rulescuaca.xlsx";
        
        excel_manager = new DokumenManager();
        dokumen = excel_manager.getDataExcel(path);
        rules_dokumen = new ArrayList<>();
        
        baris_excel = dokumen.size();
        kolom_excel = dokumen.get(0).size();
        
        for (int i = 0; i < baris_excel; i++) {
            kolom_list = new ArrayList<>();
            for (int j = 0; j < kolom_excel; j++) {
                kolom_list.add(dokumen.get(i).get(j).toString());
            }
            rules_dokumen.add(kolom_list);
        }
        return rules_dokumen;
    }
    
    public void do_pso(int jumlah_swarm, double c1, double c2, int jumlah_iterasi){
        muat_rules();
        Cuaca cuaca;
        
        TM = new TsukamotoManager(jumlah_swarm, c1, c2, jumlah_iterasi);
//        TM.bangkit_swarm(jumlah_swarm);
        TM.init_cuaca(data_cuaca);
//        TM.do_fuzzyfikasi();
        TM.init_rules(rules_dokumen);
//        TM.do_hitung_fuzzy_tsukamoto();
//        TM.agregasi();
        TM.pso_fuzzzifikasi();
    }


    public void dofuzzysaja() {
        muat_rules();
        Cuaca cuaca;
        
        F = new PSOTsukamotoManager();
        F.init_rules(rules_dokumen);
        F.init_cuaca(data_cuaca);
        F.do_fuzzyfikasi();
        F.do_hitung_fuzzy_tsukamoto();
        F.agregasi();
    }
}    

