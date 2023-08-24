package pl.papug.papug;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import pl.papug.papug.Posts.PapugPostEntity;
import pl.papug.papug.Posts.PapugPostRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private PapugPostRepository papugPostRepository = null;

    HomeController(PapugPostRepository papugPostRepository) {
        this.papugPostRepository = papugPostRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<PapugPostEntity> postsList = papugPostRepository.findAll();
        model.addAttribute("posts", postsList);
        return "home/index";
    }

    @GetMapping("/post/{id}")
    public String postById(@PathVariable Long id, Model model) {
        Optional<PapugPostEntity> post = this.papugPostRepository.findById(id);

        if(post.isEmpty()) {
            return "redirect:/error/";
        }

        model.addAttribute("post", post.get());
        return "posts/viewPost";
    }

    // redirect emtpy post requests
    @GetMapping("/post/")
    public String redirectEmptyPost() {
        return "redirect:/";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello world!";
    }
}
