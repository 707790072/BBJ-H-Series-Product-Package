package com.ekko;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExcelExport {

    String path = null;

    public void ExcelWrite(String[][] deviceArr,String[][] resultArr)  throws Exception {

        //创建工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建工作表
        Sheet sheet1 = workbook.createSheet("Device");
        Sheet sheet2 = workbook.createSheet("Result");

        //路径选择框获取路径
        JFileChooser fileChooser = new JFileChooser();
        //获取桌面路径
        FileSystemView fsv = FileSystemView.getFileSystemView();
        fileChooser.setCurrentDirectory(fsv.getHomeDirectory());

        fileChooser.setDialogTitle("Please choose a save path");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(null);

        //选中确认键
        if (JFileChooser.APPROVE_OPTION == result) {
            path = fileChooser.getSelectedFile().getPath();

            if(path != null && !path.equals("")) {}else{
                path = String.valueOf(fsv.getHomeDirectory());
            }

            //创建Device单元格
            for (int i = 0; i < deviceArr.length; i++) {
                Row row = sheet1.createRow(i);
                for (int r = 0; r < 7; r++) {
                    row.createCell(r).setCellValue(deviceArr[i][r]);
                }
            }
            //创建Result单元格
            for (int i = 0; i < resultArr.length; i++) {
                Row row2 = sheet2.createRow(i);
                for (int r = 0; r < 2; r++) {
                    row2.createCell(r).setCellValue(resultArr[i][r]);
                }
            }


            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = new Date();
            String dateFormat = simpleDateFormat.format(date);

            //生成表(IO流)
            System.out.println("path: " + path + "\\H-Series Package_" + dateFormat + ".xls");
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(path + "\\H-SeriesPackage_" + dateFormat + ".xls");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Creation failed, the file with the same name has been opened", "Error", JOptionPane.CLOSED_OPTION);
                e.printStackTrace();
            }
            workbook.write(fileOutputStream);

            //关闭流
            fileOutputStream.close();
            JOptionPane.showMessageDialog(null, "<html><body>" + "Created successfully<br>"
                            + "Path：" + path + "<html><body>", "SUCCESS", JOptionPane.CLOSED_OPTION);

        }
    }

}
