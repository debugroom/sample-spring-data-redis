package org.debugroom.sample.spring.data.redis.app.web;

import org.debugroom.sample.spring.data.redis.app.web.model.SampleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Controller
public class SampleController {

    @Value("${app.host}")
    private String host;
    @Autowired
    private SampleModel sampleModel;

    @RequestMapping(method=RequestMethod.GET, value="/{containerId:[0-9]+}")
    public String sharedSession(Model model){
        sampleModel.setLastUpdatedHost(host);
        sampleModel.setLastUpdatedAt(new Date());
        model.addAttribute("sampleModel", sampleModel);
        return "sharedSession";
    }

    @RequestMapping(method=RequestMethod.GET, value="/invalidateSession")
    public String invalidateSession(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }

}
