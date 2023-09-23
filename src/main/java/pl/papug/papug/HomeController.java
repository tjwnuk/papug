package pl.papug.papug;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

//    @GetMapping("/page/{page}")
    @RequestMapping(value={"/page", "/page/{page}"}, method = RequestMethod.GET)
    public ResponseEntity<Page<PapugPostEntity>> page(Model model, @PageableDefault(page=0, size = 5)
                               @SortDefault.SortDefaults({
                               @SortDefault(sort = "id", direction = Sort.Direction.DESC),
                       })
                       Pageable pageable) {
        Page pageContent = papugPostRepository.findAll(pageable);
        return ResponseEntity.ok(pageContent);
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
