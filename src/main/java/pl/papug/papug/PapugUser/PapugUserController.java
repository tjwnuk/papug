package pl.papug.papug.PapugUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PapugUserController {

    private final PapugUserService papugUserService;

    @Autowired
    public PapugUserController(PapugUserService papugUserService) {
        this.papugUserService = papugUserService;
    }

    @GetMapping("/users")
    @ResponseBody
    public String users() {
        String header = "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Strona z kodowaniem UTF-8</title>\n" +
                "</head>";
        String response = "Lista użytkowników<br>";

        response = header.concat(response);
        for (PapugUser papugUser : papugUserService.getAllUsers()) {
            response = response.concat(papugUser.getFullname() + " : " + papugUser.getAccountType() + " <br>");
        }

        return response;
    }
}
