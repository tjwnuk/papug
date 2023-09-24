package pl.papug.papug.About;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String aboutController() {
        return "about/aboutPage";
    }
}
