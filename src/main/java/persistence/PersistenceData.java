package persistence;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import models.Admin;
import models.Driver;
import models.Shipment;
import models.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import utils.Utils;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class PersistenceData {


    public static String recordPdf(Shipment shipment, User user) {
        String nameFile = shipment.getId() + "" + user.getId() + ".pdf";
        try {
            File file = new File(Config.rutaRelativa() + "/" + Config.getPathFile() + "/" + nameFile);
            PdfWriter pdfWriter = new PdfWriter(file);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            Paragraph paragraph = new Paragraph(shipment.resume());
            document.add(paragraph);
            document.close();
            pdfWriter.close();
            return nameFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean recordExcel(ArrayList<Shipment> shipments) {
        String filePath = Config.rutaRelativa() + "/" + Config.getPathFile() + "/listadoEnvios.xls";
        Workbook workbook = new HSSFWorkbook();

        // Crear una hoja en el libro de trabajo
        Sheet sheet = workbook.createSheet("Envíos");

        // Crear algunas filas y celdas
        int rowNum = 0;
        for (Shipment shipment : shipments) {
            if (shipment != null) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(shipment.getId());
                row.createCell(1).setCellValue(Utils.fechaAString(shipment.getCreateDate()));
                row.createCell(2).setCellValue(Utils.fechaAString(shipment.getExpectDate()));
                row.createCell(3).setCellValue(Utils.fechaAString(shipment.getDeliveryDate()));
                row.createCell(4).setCellValue(shipment.getAlternativeAddress());
                row.createCell(5).setCellValue(shipment.getAlternativeCity());
                row.createCell(6).setCellValue(shipment.getAlternativePostalCode());
                row.createCell(7).setCellValue(shipment.getStatus());
                row.createCell(8).setCellValue(shipment.getCost());
                row.createCell(9).setCellValue(shipment.getEmailUserNoRegister());
                row.createCell(10).setCellValue(shipment.getIdSender());
                row.createCell(11).setCellValue(shipment.getNameUserNoRegister());
            }
        }
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(filePath);
            // Escribir el libro de trabajo en un archivo
            workbook.write(fos);
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
