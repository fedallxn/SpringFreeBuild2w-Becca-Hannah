package controllers;

import models.Potion;
import org.springframework.web.bind.annotation.*;
import repositories.potionRepository;

import java.util.List;

@RestController
@RequestMapping("/potions")
public class PotionController {
//    private final List<Potion> potions = List.of(
//            new Potion (001, "Felix Felicis", 10, "boon"),
//            new Potion (002, "Fortuna Magnus", 3000, "boon"),
//            new Potion (003, "Inconvenience Minora", 15, "hex")
//    );
//
//    @GetMapping
//    public List<Potion> getPotion() {return potionRepository.findAll();}

    @GetMapping("form")
    public String renderForm() {
        return "<form method = 'post'>" +
                "<label>Enter potion name:" +
                "<input type = 'text' name = 'name'>" +
                "<label> Enter potion potency:" +
                "<input type = 'text' name = 'potency'>" +
                "<label> Select potion type:" +
                "<select name = 'type' id = 'type'>" +
                "<option value = 'hex'> Hex </option>" +
                "<option value = 'curse'> Curse </option>" +
                "<option value = 'boon'> Boon </option>" +
                "<input type = 'submit'>" +
                "</form>";
    }

    @PostMapping("form")
    public String handleForm (Potion potion){
        potionRepository.save(potion);
        return "Thanks for adding" + potion.getName() + "!";
    }

}
