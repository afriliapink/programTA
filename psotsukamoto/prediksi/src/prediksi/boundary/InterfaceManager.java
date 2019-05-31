/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prediksi.boundary;

import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
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
    ArrayList<String> newList;
    String[][] rule;
    TsukamotoManager TM;
    PSOTsukamotoManager F;

    public void Load_Data(JTable tbl_data, JLabel Namafile) {
        ArrayList<Cuaca> data_cuaca;
        data_cuaca = new ArrayList();
        String path;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel FILES", "xlsx", "Excel");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new java.io.File("."));
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            Namafile.setText(selectedFile.getName());
            data_cuaca = muat_data_excel(path);

            DefaultTableModel cuaca_model = (DefaultTableModel) tbl_data.getModel();

            String[] data = new String[7];
            for (int i = tbl_data.getRowCount() - 1; i >= 0; i--) {
                cuaca_model.removeRow(i);
            }

            for (int i = 0; i < data_cuaca.size(); i++) {
                data[0] = String.valueOf((int) data_cuaca.get(i).getNo());
                data[1] = data_cuaca.get(i).getTanggal();
                data[2] = String.valueOf((int) data_cuaca.get(i).getSuhu());
                data[3] = String.valueOf((int) data_cuaca.get(i).getKelembaban());
                data[4] = String.valueOf((int) data_cuaca.get(i).getTekanan_udara());
                data[5] = String.valueOf(data_cuaca.get(i).getKecepatan_angin());
                data[6] = data_cuaca.get(i).getKeadaan_cuaca();

                cuaca_model.addRow(data);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Muat Data Gagal");
        }
    }

    public ArrayList<Cuaca> muat_data_excel(String path) {
        int baris_excel, kolom_excel;
        Cuaca cuaca;

        excel_manager = new DokumenManager();
        excel_dokumen = excel_manager.getDataExcel(path);

        baris_excel = excel_dokumen.size() - 1;
        kolom_excel = excel_dokumen.get(0).size();

        data_cuaca = new ArrayList<>();

        for (int i = 0; i < baris_excel; i++) {
            cuaca = new Cuaca();

            cuaca.setNo(Double.parseDouble(excel_dokumen.get(i + 1).get(0).toString()));
            cuaca.setTanggal(excel_dokumen.get(i + 1).get(1).toString());
            cuaca.setSuhu(Double.parseDouble(excel_dokumen.get(i + 1).get(2).toString()));
            cuaca.setKelembaban(Double.parseDouble(excel_dokumen.get(i + 1).get(3).toString()));
            cuaca.setTekanan_udara(Double.parseDouble(excel_dokumen.get(i + 1).get(4).toString()));
            cuaca.setKecepatan_angin(Double.parseDouble(excel_dokumen.get(i + 1).get(5).toString()));
            cuaca.setKeadaan_cuaca(excel_dokumen.get(i + 1).get(6).toString());
            data_cuaca.add(cuaca);
        }
        return data_cuaca;

    }

    public ArrayList<ArrayList> muat_rules() {
        ArrayList<ArrayList> dokumen;
        ArrayList<String> kolom_list;

        int baris_excel, kolom_excel;

        String path = System.getProperty("user.dir") + "\\data\\rulescuaca.xlsx";
        System.out.println(path);
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

    public void do_pso(int jumlah_swarm, double c1, double c2, int jumlah_iterasi, JLabel persentase, JTable tbl_data) {
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
        persentase.setText(String.valueOf(TM.get_akurasi() + " %"));
    }

    public void dofuzzysaja(JLabel persentase, JTable tbl_data) {

        muat_rules();
        Cuaca cuaca;

        F = new PSOTsukamotoManager();
        F.init_rules(rules_dokumen);
        F.init_cuaca(data_cuaca);
        F.do_fuzzyfikasi();
        F.do_hitung_fuzzy_tsukamoto();
        F.agregasi();
        persentase.setText(String.valueOf(F.agregasi() + " %"));
        String[] hasilcuaca = F.get_hasil_cuaca();
        //show to table
        DefaultTableModel cuaca_model = (DefaultTableModel) tbl_data.getModel();
        String[] data = new String[8];

        for (int i = 0; i < hasilcuaca.length; i++) {
            System.out.println(hasilcuaca[i]);
        }
    }

}
