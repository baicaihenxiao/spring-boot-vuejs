package de.jonashackt.springbootvuejs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// https://github.com/jonashackt/spring-boot-vuejs/pull/154
@Controller
public class VueForwardController {

    private static final Logger LOG = LoggerFactory.getLogger(VueForwardController.class);

    // Forwards all routes to FrontEnd except: '/', '/index.html', '/api', '/api/**'
    // Required because of 'mode: history' usage in frontend routing, see README for further details
    @RequestMapping(value = "{_:^(?!index\\.html|api).*$}")
//    @RequestMapping({"/{path:[^\\.]*}", "/**/{path:^(?!index\\.html|api|actuator).*}/{path:[^\\.]*}"})
    public String redirectApi() {
        LOG.info("URL entered directly into the Browser, so we need to redirect...");
        // https://stackoverflow.com/questions/28697681/spring-mvc-controller-what-is-the-difference-between-return-forward-return
        return "forward:/";
    }

}