package com.buit.cis.op.dctwork.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ClassUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportUtil {
    static final Logger logger = LoggerFactory.getLogger(ReportUtil.class);
    public ReportUtil() {
    }

    public static File getFile(String fileName) {
        if (fileName.contains("/") || fileName.contains("\\")) {
            return new File(fileName);
        }
        String folder = System.getProperty("java.io.tmpdir");
        //String folder = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"jrxml/";
        File jasperFile = new File(folder + File.separator + fileName);
        try {
            jasperFile.createNewFile();
            ClassPathResource classPathResource = new ClassPathResource("jrxml/" + fileName);
            FileUtils.copyInputStreamToFile(classPathResource.getInputStream(), jasperFile);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return jasperFile;
    }
    public  InputStream getFileInputStream(String fileName) {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        return this.getClass().getClassLoader().getResourceAsStream(fileName);
    }
    public static void reportHtmlForStream(Map<String, Object> params, String jasperName, HttpServletResponse response) {
        List<Map<String, Object>> list = new ArrayList();
        list.add(new HashMap());
        reportHtmlForStream(list, params, jasperName, response);
    }
    public static void reportHtmlForStream(List<Map<String, Object>> list, Map<String, Object> params, String jasperName, HttpServletResponse response) {
        JRDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(list);
        response.setContentType("text/html;charset=UTF-8");

        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getFile(jasperName));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, jrBeanCollectionDataSource);
            HtmlExporter exporter = new HtmlExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getOutputStream()));
            exporter.exportReport();
        } catch (IOException | JRException var9) {
            logger.error(var9.getMessage(), var9);
        }

    }



}
