package pl.papug.papug.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.papug.papug.model.PapugPostEntity;
import pl.papug.papug.model.UserAccount;
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
    public String addNewPost(Model model,
                             HttpServletRequest request,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content) {

        UserAccount user = this.authService.getUser();
        model.addAttribute("userIsLogged", this.authService.isLogged());
        model.addAttribute("user", user);

        String username = user.getUsername();

        String currentPage = "new-post";
        model.addAttribute("currentPage", currentPage);

        PapugPostEntity newPost = new PapugPostEntity(title, content, username);
        newPost = papugPostRepository.save(newPost);

        Long id = newPost.getId();

        return "redirect:/post/" + id;
    }

}
