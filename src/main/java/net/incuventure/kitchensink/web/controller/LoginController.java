package net.incuventure.kitchensink.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {

        Map mymap = new HashMap();
        mymap.put("username", "jett");
        mymap.put("password", "****");

        model.addAttribute("message", "show accounting stuff");
        model.addAttribute("mymap", mymap);

        return "login/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(HttpServletRequest req, ModelMap model, @RequestParam String userid, @RequestParam String pwd) {

        System.out.println(userid);
        System.out.println(pwd);

        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
        }

        Map mymap = new HashMap();
        mymap.put("username", "jettx");
        mymap.put("password", "****");

        model.addAttribute("message", "show accounting stuff");
        model.addAttribute("mymap", mymap);

        return "login/login";
    }

}
