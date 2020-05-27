package cau.zjf.hypertension.controller;

import cau.zjf.hypertension.bean.Person;
import cau.zjf.hypertension.service.PersonService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = {RequestMethod.GET})
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Person addPerson(@RequestBody JSONObject jsonObject) {
        Person person = computeRate(jsonObject);
        personService.addPerson(person);
        return person;
    }

    @RequestMapping("/result")
    public String result(@RequestParam("times") double times,@RequestParam("rate") double rate,Model model){
        Person person = new Person("man",30,times, rate,"father","one","many");
        model.addAttribute("person",person);
        return "result";
    }

    /*
    计算高血压的概率
     */
    public static Person computeRate(JSONObject jsonObject) {
        double times = 1.00;
        double rate = 0.147;
        String sex = jsonObject.getString("sex");
        int age = jsonObject.getInteger("age");
        String parents = jsonObject.getString("parents");
        String grandparents = jsonObject.getString("grandparents");
        String brothers = jsonObject.getString("brothers");
        if (parents != null && parents.equals("father")) {//1.父母中只有父亲
            times = 1.39;
            rate = 0.204;
        } else if (parents != null && parents.equals("mother")) {//2.父母中只有母亲
            times = 1.27;
            rate = 0.187;
            if (brothers != null)
                if (brothers.equals("one") || brothers.equals("many")) {
                    times = 1.82;
                    rate = 0.268;
                }
            if (grandparents != null)
                if (grandparents.equals("one") || grandparents.equals("many")) {
                    times = 1.98;
                    rate = 0.291;
                }
        } else if (parents != null && parents.equals("both")) {//3.父母都有
            times = 1.49;
            rate = 0.219;
            if (brothers != null)
                if (brothers.equals("one") || brothers.equals("many")) {
                    times = 2.06;
                    rate = 0.303;
                }
            if (grandparents != null)
                if (grandparents.equals("one") || grandparents.equals("many")) {
                    times = 3.05;
                    rate = 0.448;
                }

        } else {//4.父母有没有
            if (brothers != null)
                if (brothers.equals("one") || brothers.equals("many")) {
                    times = 1.88;
                    rate = 0.276;
                }
        }
        return new Person(sex,age,times, rate,parents,grandparents,brothers);
    }
}
