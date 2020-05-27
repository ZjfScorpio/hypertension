package cau.zjf.hypertension.controller;

import cau.zjf.hypertension.bean.Person;
import cau.zjf.hypertension.bean.Test;
import cau.zjf.hypertension.service.ExcelService;
import cau.zjf.hypertension.service.PersonService;
import cau.zjf.hypertension.util.PageBean;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/back")
public class BackendController {
    private static String basePath = "..//tmp//";

    @Autowired
    private PersonService personService;

    @Autowired
    private ExcelService excelService;

    @RequestMapping(method = {RequestMethod.GET})
    public String login(){
        return "admin/login";
    }

    @RequestMapping("/loginAction")
    @ResponseBody
    public int loginAction(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password){
        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)){
            if(username.equals("admin") && password.equals("123qwe"))
                return 0;
        }
        return 1;
    }

    @RequestMapping("/index")
    public String index(){
        return "admin/index";
    }


    @RequestMapping("/person_list")
    @ResponseBody
    public PageBean<Test> index(@RequestParam(value = "start", defaultValue = "1") int start,
                        @RequestParam(value = "length", defaultValue = "10") int pageSize){

        List<Person> personList = personService.selectPersons();
        List<Test> testList = new ArrayList<>();
        for(Person person:personList){
            long id = person.getId();
            String sex = person.getSex();
            int age = person.getAge();
            double times = person.getTimes();
            double rate = person.getRate();
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
            String date = sdf.format(person.getDate());
            String parents = person.getParents();
            String grandparents = person.getGrandparents();
            String brothers = person.getBrothers();
            testList.add(new Test(id,sex,age,times,rate,date,parents,grandparents,brothers));
        }
        PageInfo<Test> pageInfo = new PageInfo<>(testList);
        return new PageBean<>(pageInfo);
    }

    @RequestMapping("select_result")
    @ResponseBody
    public void selectAndResultData(HttpServletResponse response) {
        InputStream inputStream = null;
        try {
            excelService.createSelectAndResult();
            response.reset();
            response.setContentType("bin");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String("select_result.xls".getBytes(), "UTF-8"));

            ServletOutputStream outputStream = response.getOutputStream();

            //inputStream = new FileInputStream(new File(ResourceUtils.getURL("classpath:").getPath() + "datafile/select_result.xls"));
            inputStream = new FileInputStream(new File(basePath + "select_result.xls"));
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, length);
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {

                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}









/*
    @RequestMapping("select")
    @ResponseBody
    public void selectData(HttpServletResponse response) {
        InputStream inputStream = null;
        try {
//            RestResult restResult=new RestResult();
//            restResult.setSuccess(false);
            excelService.createSelect();
            response.reset();
            response.setContentType("bin");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String("select.xls".getBytes(), "UTF-8"));

            ServletOutputStream outputStream = response.getOutputStream();

            inputStream = new FileInputStream(new File(basePath + "select.xls"));
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, length);
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {

                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @RequestMapping("result")
    @ResponseBody
    public void resultData(HttpServletResponse response) {
        InputStream inputStream = null;
        try {
//            RestResult restResult=new RestResult();
//            restResult.setSuccess(false);
            excelService.createResult();
            response.reset();
            response.setContentType("bin");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String("result.xls".getBytes(), "UTF-8"));

            ServletOutputStream outputStream = response.getOutputStream();

            inputStream = new FileInputStream(new File(basePath + "result.xls"));
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, length);
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {

                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

 */
