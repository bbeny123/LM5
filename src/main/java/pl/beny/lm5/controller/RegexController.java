package pl.beny.lm5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.beny.lm5.dto.Result;

import java.util.LinkedList;

@Controller
public class RegexController {

    private final LinkedList<Result> history = new LinkedList<>();

    @GetMapping("/")
    public String index(Model model) {
        history.clear();
        model.addAttribute("history", history);
        return "index";
    }

    @PostMapping("/")
    public String checkExpression(String expression, Model model) {
        String regex = "^[0-9]+(\\.[0-9]+)?([\\^*/+-][0-9]+(\\.[0-9]+)?)*$";
        history.addFirst(new Result(expression, expression.matches(regex)));
        model.addAttribute("history", history);
        return "index";
    }

}
