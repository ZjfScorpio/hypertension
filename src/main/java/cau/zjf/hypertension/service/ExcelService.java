package cau.zjf.hypertension.service;

import cau.zjf.hypertension.bean.Person;
import cau.zjf.hypertension.dao.PersonDao;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ExcelService {
    private static String basePath = "..//tmp//";

    @Autowired
    private PersonDao personDao;

    public String createSelectAndResult(){
        try {
            WritableWorkbook wwb = null;
            // 创建可写入的Excel工作簿
            String fileName = basePath+"select_result.xls";
            //String fileName = "..//hypertension//src//main//resources//datafile//select_result.xls";
            File file=new File(fileName);
            if (!file.exists()) {
                if(!file.getParentFile().exists())
                    file.getParentFile().mkdirs();
                file.createNewFile();
            }
            //以fileName为文件名来创建一个Workbook
            wwb = Workbook.createWorkbook(file);

            // 创建工作表
            WritableSheet ws = wwb.createSheet("Test Shee 1", 0);

            //查询数据库中所有的数据
            List<Person> list= personDao.selectPersons();
            //要插入到的Excel表格的行号，默认从0开始
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
            String time = sdf.format(new Date());
            Label labelTime = new Label(0,0,"数据统计截止于"+time);
            Label labelId= new Label(0, 1, "编号");
            Label labelSex= new Label(1, 1, "性别");
            Label labelAge= new Label(2, 1, "年龄");
            Label labelParents= new Label(3, 1, "父母");
            Label labelGrandparents= new Label(4, 1, "祖父母");
            Label labelBrothers= new Label(5, 1, "兄弟姐妹");
            Label labelTimes= new Label(6, 1, "倍数");
            Label labelRate= new Label(7, 1, "概率");
            Label labelDate= new Label(8, 1, "测试时间");
            ws.addCell(labelTime);
            ws.addCell(labelId);
            ws.addCell(labelSex);
            ws.addCell(labelAge);
            ws.addCell(labelParents);
            ws.addCell(labelGrandparents);
            ws.addCell(labelBrothers);
            ws.addCell(labelTimes);
            ws.addCell(labelRate);
            ws.addCell(labelDate);
            for (int i = 0; i < list.size(); i++) {
                String date = sdf.format(list.get(i).getDate());
                Label labelId_i= new Label(0, i+2, list.get(i).getId()+"");
                Label labelSex_i= new Label(1, i+2, list.get(i).getSex()+"");
                Label labelAge_i= new Label(2, i+2, list.get(i).getAge()+"");
                Label labelParents_i= new Label(3, i+2, list.get(i).getParents()+"");
                Label labelGrandparents_i= new Label(4, i+2, list.get(i).getGrandparents()+"");
                Label labelBrothers_i= new Label(5, i+2, list.get(i).getBrothers()+"");
                Label labelTimes_i= new Label(6, i+2, list.get(i).getTimes()+"");
                Label labelRate_i= new Label(7, i+2, list.get(i).getRate()+"");
                Label labelDate_i= new Label(8, i+2, date+"");
                ws.addCell(labelId_i);
                ws.addCell(labelSex_i);
                ws.addCell(labelAge_i);
                ws.addCell(labelParents_i);
                ws.addCell(labelGrandparents_i);
                ws.addCell(labelBrothers_i);
                ws.addCell(labelTimes_i);
                ws.addCell(labelRate_i);
                ws.addCell(labelDate_i);
            }

            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            wwb.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "0";
    }
}


    /*
    public String createSelect(){
        try {
            WritableWorkbook wwb = null;
            // 创建可写入的Excel工作簿
            String fileName = basePath+"select.xls";
            //String fileName = "..//hypertension//src//main//resources//datafile//select_result.xls";
            File file=new File(fileName);
            if (!file.exists()) {
                if(!file.getParentFile().exists())
                    file.getParentFile().mkdirs();
                file.createNewFile();
            }
            //以fileName为文件名来创建一个Workbook
            wwb = Workbook.createWorkbook(file);

            // 创建工作表
            WritableSheet ws = wwb.createSheet("Test Shee 1", 0);

            //查询数据库中所有的数据
            List<Person> list= personDao.selectPersons();
            //要插入到的Excel表格的行号，默认从0开始
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
            String time = sdf.format(new Date());
            Label labelTime = new Label(0,0,"数据统计截止于"+time);
            Label labelId= new Label(0, 1, "编号(id)");
            Label labelDate= new Label(1, 1, "测试时间");
            Label labelParents= new Label(2, 1, "父母");
            Label labelGrandparents= new Label(3, 1, "祖父母");
            Label labelBrothers= new Label(4, 1, "兄弟姐妹");

            ws.addCell(labelTime);
            ws.addCell(labelId);
            ws.addCell(labelDate);
            ws.addCell(labelParents);
            ws.addCell(labelGrandparents);
            ws.addCell(labelBrothers);
            for (int i = 0; i < list.size(); i++) {
                String date = sdf.format(list.get(i).getDate());
                Label labelId_i= new Label(0, i+2, list.get(i).getId()+"");
                Label labelDate_i= new Label(1, i+2, date+"");
                Label labelParents_i= new Label(2, i+2, list.get(i).getParents()+"");
                Label labelGrandparents_i= new Label(3, i+2, list.get(i).getGrandparents()+"");
                Label labelBrothers_i= new Label(4, i+2, list.get(i).getBrothers()+"");
                ws.addCell(labelId_i);
                ws.addCell(labelDate_i);
                ws.addCell(labelParents_i);
                ws.addCell(labelGrandparents_i);
                ws.addCell(labelBrothers_i);
            }

            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            wwb.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "0";
    }

    public String createResult(){
        try {
            WritableWorkbook wwb = null;
            // 创建可写入的Excel工作簿
            String fileName = basePath+"result.xls";
            //String fileName = "..//hypertension//src//main//resources//datafile//select_result.xls";
            File file=new File(fileName);
            if (!file.exists()) {
                if(!file.getParentFile().exists())
                    file.getParentFile().mkdirs();
                file.createNewFile();
            }
            //以fileName为文件名来创建一个Workbook
            wwb = Workbook.createWorkbook(file);

            // 创建工作表
            WritableSheet ws = wwb.createSheet("Test Shee 1", 0);

            //查询数据库中所有的数据
            List<Person> list= personDao.selectPersons();
            //要插入到的Excel表格的行号，默认从0开始
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
            String time = sdf.format(new Date());
            Label labelTime = new Label(0,0,"数据统计截止于"+time);
            Label labelId= new Label(0, 1, "编号(id)");
            Label labelTimes= new Label(1, 1, "倍数");
            Label labelRate= new Label(2, 1, "概率");
            Label labelDate= new Label(3, 1, "测试时间");

            ws.addCell(labelTime);
            ws.addCell(labelId);
            ws.addCell(labelTimes);
            ws.addCell(labelRate);
            ws.addCell(labelDate);
            for (int i = 0; i < list.size(); i++) {
                String date = sdf.format(list.get(i).getDate());
                Label labelId_i= new Label(0, i+2, list.get(i).getId()+"");
                Label labelTimes_i= new Label(1, i+2, list.get(i).getTimes()+"");
                Label labelRate_i= new Label(2, i+2, list.get(i).getRate()+"");
                Label labelDate_i= new Label(3, i+2, date+"");
                ws.addCell(labelId_i);
                ws.addCell(labelTimes_i);
                ws.addCell(labelRate_i);
                ws.addCell(labelDate_i);
            }

            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            wwb.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "0";
    }

     */

