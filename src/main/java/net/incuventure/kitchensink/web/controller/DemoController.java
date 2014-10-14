package net.incuventure.kitchensink.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(value="params", method = RequestMethod.GET)
    public String index(HttpServletRequest request,  ModelMap model) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
        }


        model.addAttribute("message", "show accounting stuff");
        System.out.println("accounting controller");

        return "/demo/index";
    }

    @RequestMapping("target")
    public String redirectTarget() {
        System.out.println("got the redirect");

        return "index";
    }

    @RequestMapping("/redirect")
    public String redirectSource() {
        return "redirect: /demo/target";
    }

}
