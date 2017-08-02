package be.imaginelab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dries on 22/02/2017.
 */
@Controller
public class RequestController {
    @RequestMapping({"/"})
    public String showHome(ModelMap model)
    {
        return "home";
    }

    @RequestMapping({"/asteroids"})
    public String showAsteroids(ModelMap model)
    {
        return "Asteroids";
    }

    @RequestMapping({"/munchkin"})
    public String showMunchkin(ModelMap model)
    {
        return "Munchkin";
    }

}
