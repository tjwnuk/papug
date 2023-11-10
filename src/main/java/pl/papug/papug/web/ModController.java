package pl.papug.papug.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.papug.papug.model.UserAccount;
import pl.papug.papug.repository.PapugPostRepository;
import pl.papug.papug.repository.UserRepository;
import pl.papug.papug.service.AuthService;
import pl.papug.papug.service.UserService;

import java.util.List;

@Controller
public class ModController {
    @Autowired
    AuthService authService;
    @Autowired
    PapugPostRepository papugPostRepository;
    @Autowired
    UserService userService;

    @GetMapping("/mod/users")
    public String listAllUsers(Model model) {

        String currentPage = "mod";
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("user", this.authService.getUser());
        model.addAttribute("userIsLogged", this.authService.isLogged());

//        if (this.authService.isLogged()) {
//            boolean isMod = this.authService.getUser().isMod();
//            model.addAttribute("userIsMod", isMod);
//        }

        List<UserAccount> allUsers = userService.findAll();

        model.addAttribute("users", allUsers);

        return "mod/users";
    }

    @GetMapping("/mod/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        this.userService.deleteById(id);

        return "redirect:/mod/users";
    }
    @GetMapping("/mod/users/setmod/{username}")
    public String setMod(@PathVariable String username) {
        this.userService.setMod(username);

        return "redirect:/mod/users";
    }

    @GetMapping("/mod/users/unsetmod/{username}")
    public String unsetMod(@PathVariable String username) {
        this.userService.unsetMod(username);

        return "redirect:/mod/users";
    }

    @GetMapping("/mod/post/{id}/delete")
    public String deletePost(Model model,
                             @PathVariable Long id) {
        this.papugPostRepository.deleteById(id);
        return "redirect:/";
//        return "delete post " + id.toString();
    }

}
