package pl.papug.papug.About;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String aboutController(Model model) {

        String currentPage = "about";
        model.addAttribute("currentPage", currentPage);
        return "about/aboutPage";
    }
}
