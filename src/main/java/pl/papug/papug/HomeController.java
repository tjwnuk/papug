package pl.papug.papug;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @RequestMapping(value={"/", "/page", "/page/{page}"}, method = RequestMethod.GET)
    public String index(Model model, @PathVariable(required = false) Integer page) {
        if (page == null) {
            page = 0;
        }
        Pageable pageable;
//        Sort descending
        Sort sort = Sort.by(Sort.Order.desc("id"));

        pageable = PageRequest.of(page, 5, sort);

        int pageNumber = pageable.getPageNumber();
        int numberOfAllPages = pageable.getPageSize();

        Page pageContent = papugPostRepository.findAll(pageable);
        List<PapugPostEntity> posts = pageContent.toList();

        model.addAttribute("posts", posts);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("numberOfAllPages", numberOfAllPages);
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

}
