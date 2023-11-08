package pl.papug.papug.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.papug.papug.repository.PapugPostRepository;
import pl.papug.papug.service.AuthService;

@Controller
public class NewPostController {
    @Autowired
    PapugPostRepository papugPostRepository;
    @Autowired
    AuthService authService;

    @GetMapping("/new-post")
    public String newPost(Model model, HttpServletRequest request) {
        model.addAttribute("userIsLogged", this.authService.isLogged());
        model.addAttribute("user", this.authService.getUser());
        String currentPage = "new-post";
        model.addAttribute("currentPage", currentPage);

        return "posts/newPost";
    }
    @PostMapping("/new-post")
    @ResponseBody
    public String addNewPost(Model model,
                             HttpServletRequest request,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content) {
        model.addAttribute("userIsLogged", this.authService.isLogged());
        model.addAttribute("user", this.authService.getUser());

        String currentPage = "new-post";
        model.addAttribute("currentPage", currentPage);

        return title + " - " + content;
    }

}
