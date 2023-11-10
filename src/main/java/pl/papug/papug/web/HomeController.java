package pl.papug.papug.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import pl.papug.papug.model.PapugPostEntity;
import pl.papug.papug.repository.PapugPostRepository;
import pl.papug.papug.service.AuthService;
import pl.papug.papug.service.PapugPostService;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private PapugPostRepository papugPostRepository = null;
    private PapugPostService papugPostService = null;
    private AuthService authService = null;

    HomeController(PapugPostRepository papugPostRepository,
                   PapugPostService papugPostService,
                   AuthService authService) {
        this.papugPostRepository = papugPostRepository;
        this.papugPostService = papugPostService;
        this.authService = authService;
    }

    @RequestMapping(value={"/", "/page", "/page/{page}"}, method = RequestMethod.GET)
    public String index(Model model, @PathVariable(required = false) Integer page) {
        if (page == null) {
            page = 0;
        }
        Pageable pageable;
        Sort sort = Sort.by(Sort.Order.desc("id"));  // Sort descending

        Integer pageSize = 10;

        pageable = PageRequest.of(page, pageSize, sort);

        int pageNumber = pageable.getPageNumber();
        int numberOfAllPages = papugPostService.getEntities(pageNumber, pageSize).getTotalPages() - 1;

        Page pageContent = papugPostRepository.findAll(pageable);
        List<PapugPostEntity> posts = pageContent.toList();

        model.addAttribute("userIsLogged", this.authService.isLogged());
        model.addAttribute("user", this.authService.getUser());


        model.addAttribute("posts", posts);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("numberOfAllPages", numberOfAllPages);

        String currentPage = "index";
        model.addAttribute("currentPage", currentPage);

        return "home/index";
    }

    @GetMapping("/post/{id}")
    public String postById(@PathVariable Long id, Model model) {
        Optional<PapugPostEntity> post = this.papugPostRepository.findById(id);

        if(post.isEmpty()) {
            return "redirect:/error/";
        }

        model.addAttribute("post", post.get());

        model.addAttribute("userIsLogged", this.authService.isLogged());
        model.addAttribute("user", this.authService.getUser());

        if (this.authService.getUser() != null) {
            model.addAttribute("userIsMod", this.authService.getUser().isMod());
            model.addAttribute("userIsAdmin", this.authService.getUser().isAdmin());
        }
        
        return "posts/viewPost";
    }

    // redirect emtpy post requests
    @GetMapping("/post/")
    public String redirectEmptyPost() {
        return "redirect:/";
    }

}
