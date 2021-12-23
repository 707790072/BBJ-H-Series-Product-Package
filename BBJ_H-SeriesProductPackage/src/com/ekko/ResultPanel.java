package com.ekko;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPanel extends JPanel{

    //设置字体
    Font TitlFont = new Font("Times New Roman",Font.BOLD,17);
    Color titilColor = new Color(139,126,102);
    //背景颜色
    Color bcakGround = new Color(255,250,205);

    //添加显示面板 网格布局
    GridLayout gridLayout = new GridLayout(1,4);
    //底部Panel
    JPanel rootPanel = new JPanel(gridLayout);

    //显示结果按钮
    //basic套餐
    JButton basicButton = new JButton();
    //advanced套餐
    JButton advancedButton = new JButton();
    //luxury套餐
    JButton luxuryButton = new JButton();

    //结果二维数组
    String[][] resultArr = new String[7][2];

    public ResultPanel(String packageType, int totalRetedPower, int totalDayPower, int totalNightPower,
                       int NEPADayTime, int NEPANightTime, int genPower, int panleNumb, double solarFactor, String[][] deviceArr) {
        super();

        rootPanel.add(basicButton);
        rootPanel.add(advancedButton);
        rootPanel.add(luxuryButton);
        //设置颜色
        basicButton.setBackground(bcakGround);
        advancedButton.setBackground(bcakGround);
        luxuryButton.setBackground(bcakGround);


        //接受结果的字符串
        MianProduct mianProduct = new MianProduct();
        //设置产品类型得到基础套餐包
        mianProduct.setpackageType(packageType);


        //升级套餐增加光伏板数量
        int addAdvancPanle = mianProduct.additionalPanel(packageType,totalDayPower,totalNightPower,NEPADayTime,NEPANightTime,solarFactor);
        //升级套餐增加电池数量
        int addAdvancBattery = mianProduct.additionalBattery(packageType,totalDayPower,NEPADayTime,totalNightPower,NEPANightTime,addAdvancPanle);


        //豪华套餐电池数量
        int luxuryPanel = mianProduct.luxuryPanel(packageType,totalDayPower,totalNightPower,solarFactor);
        int luxuryBattry = mianProduct.luxuryBattry(packageType,totalDayPower,totalNightPower,luxuryPanel);

        //Base套餐的显示
        String baseResultStr =
                "<html><body>" +
                        "<div style=\"font-size:13px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "BASIC PACKAGE" + "&nbsp;&nbsp;</div><br>" +
                        "<div style=\"font-size:15px;color:#000000\">-----------&nbsp;&nbsp;" + packageType + "&nbsp;&nbsp;-----------</div><br><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;Inverter&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        mianProduct.getInverter() + "</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;2.5kwh Battery&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        mianProduct.getBattery_3KWH() + "</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;5kwh Battery&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        mianProduct.getBattery_5KWH() + "</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;Solar Panels&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        mianProduct.getSolarPanel() + "</div><br><br><br><br><br><br><br><br>" +
                "<html><body>";

        //advanced套餐的显示
        String advancedResultStr =
                "<html><body>" +
                        "<div style=\"font-size:13px;\">&nbsp;&nbsp;&nbsp;" + "ADVANCED PACKAGE" + "&nbsp;&nbsp;</div><br>" +
                        "<div style=\"font-size:15px;color:#000000\">-----------&nbsp;&nbsp;" + packageType + "&nbsp;&nbsp;-----------</div><br><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;Inverter&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        mianProduct.getInverter() + "</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;2.5kwh Battery&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        mianProduct.getBattery_3KWH() + "</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;5kwh Battery&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        mianProduct.getBattery_5KWH() + "</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;Solar Panels&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        mianProduct.getSolarPanel() + "</div><br>" +


                        "<div style=\"font-size:15px;color:#000000\">----&nbsp;ADDITIONAL&nbsp;----</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;5kwh Battery&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        addAdvancBattery + "</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;Solar Panels&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        addAdvancPanle + "</div><br>" +

                        "<body><html>";

        //luxury套餐的显示
        String luxuryResultStr =
                "<html><body>" +
                        "<div style=\"font-size:13px;\">&nbsp;&nbsp;" + "LUXURIOUS PACKAGE" + "&nbsp;&nbsp;</div><br>" +
                        "<div style=\"font-size:15px;color:#000000\">-----------&nbsp;&nbsp;" + packageType + "&nbsp;&nbsp;-----------</div><br><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;Inverter&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        mianProduct.getInverter() + "</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;2.5kwh Battery&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        mianProduct.getBattery_3KWH() + "</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;5kwh Battery&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        mianProduct.getBattery_5KWH() + "</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;Solar Panels&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        mianProduct.getSolarPanel() + "</div><br>" +


                        "<div style=\"font-size:15px;color:#000000\">----&nbsp;ADDITIONAL&nbsp;----</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;5kwh Battery&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        luxuryBattry + "</div><br>" +

                        "<div style=\"width:50px;height:25px;border:1px solid black;\">" +
                        "&nbsp;Solar Panels&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        luxuryPanel + "</div><br>" +

                        "<body><html>";


        //结果显示在Button的Text内部
        basicButton.setText(baseResultStr);
        advancedButton.setText(advancedResultStr);
        luxuryButton.setText(luxuryResultStr);

        basicButton.setFont(TitlFont);
        advancedButton.setFont(TitlFont);
        luxuryButton.setFont(TitlFont);

        basicButton.setForeground(titilColor);
        advancedButton.setForeground(titilColor);
        luxuryButton.setForeground(titilColor);

        basicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //标题赋值
                String[] productName = {"packageTypeName","Inverter","Battery_3KWH"
                ,"Battery_5KWH","SolarPanel","AdditionalBattery","AdditionalSolarPanel"};
                for(int i = 0;i < 7;i++){
                    resultArr[i][0] = productName[i];
                }

                //结果数据赋值
                resultArr[0][1] = packageType;
                resultArr[1][1] = String.valueOf(mianProduct.getInverter());
                resultArr[2][1] = String.valueOf(mianProduct.getBattery_3KWH());
                resultArr[3][1] = String.valueOf(mianProduct.getBattery_5KWH());
                resultArr[4][1] = String.valueOf(mianProduct.getSolarPanel());
                resultArr[5][1] = "0";
                resultArr[6][1] = "0";

                try {
                    new ExcelExport().ExcelWrite(deviceArr,resultArr);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        advancedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //标题赋值
                String[] productName = {"packageTypeName","Inverter","Battery_3KWH"
                        ,"Battery_5KWH","SolarPanel","AdditionalBattery","AdditionalSolarPanel"};
                for(int i = 0;i < 7;i++){
                    resultArr[i][0] = productName[i];
                }

                //结果数据赋值
                resultArr[0][1] = packageType;
                resultArr[1][1] = String.valueOf(mianProduct.getInverter());
                resultArr[2][1] = String.valueOf(mianProduct.getBattery_3KWH());
                resultArr[3][1] = String.valueOf(mianProduct.getBattery_5KWH());
                resultArr[4][1] = String.valueOf(mianProduct.getSolarPanel());
                resultArr[5][1] = String.valueOf(addAdvancBattery);
                resultArr[6][1] = String.valueOf(addAdvancPanle);

                try {
                    new ExcelExport().ExcelWrite(deviceArr,resultArr);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        luxuryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //标题赋值
                String[] productName = {"packageTypeName","Inverter","Battery_3KWH"
                        ,"Battery_5KWH","SolarPanel","AdditionalBattery","AdditionalSolarPanel"};
                for(int i = 0;i < 7;i++){
                    resultArr[i][0] = productName[i];
                }

                //结果数据赋值
                resultArr[0][1] = packageType;
                resultArr[1][1] = String.valueOf(mianProduct.getInverter());
                resultArr[2][1] = String.valueOf(mianProduct.getBattery_3KWH());
                resultArr[3][1] = String.valueOf(mianProduct.getBattery_5KWH());
                resultArr[4][1] = String.valueOf(mianProduct.getSolarPanel());
                resultArr[5][1] = String.valueOf(luxuryBattry);
                resultArr[6][1] = String.valueOf(luxuryPanel);

                try {
                    new ExcelExport().ExcelWrite(deviceArr,resultArr);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

    }

}
