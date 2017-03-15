package be.imaginelab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dries on 22/02/2017.
 */
@org.springframework.stereotype.Controller
public class Controller {
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
