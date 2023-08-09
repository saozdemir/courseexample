package com.sao.jasperreports;

import com.sao.jasperreports.data.ReportData;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author saozd
 * @project com.sao.jasperreports courseexample
 * 1.06.2023 Haz 2023
 */
public class JasperApp {
    public static void main(String[] args) {
        try {
            String path = "E:\\IdeaProjects\\courseexample\\hibernateexamples\\jasperreports\\src\\main\\reports\\first_report.jasper";
            List<ReportData> dataList = new ArrayList<>();
            dataList.add(new ReportData("Data1 "));

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ReportTitle", "Örnek Rapor");

            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path);

            // Raporu doldurun
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Raporu PDF olarak dışa aktarın
            String outputFilePath = "E:\\IdeaProjects\\courseexample\\hibernateexamples\\jasperreports\\src\\main\\reports\\first_report.jasper\\report.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputFilePath);

            System.out.println("Rapor oluşturuldu ve dışa aktarıldı: " + outputFilePath);
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
}
