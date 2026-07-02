package controllers;

import models.Potion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.PotionRepository;

import java.util.List;

@RestController
@RequestMapping("/potions")
public class PotionController {

 private final PotionRepository potionRepository;

 @Autowired
 public PotionController(PotionRepository potionRepository) {
     this.potionRepository = potionRepository;
 }

@GetMapping
public List<Potion> getPotion() {return potionRepository.findAll();}

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
    public String handleForm (@RequestBody Potion potion){
        potionRepository.save(potion);
        return "Thanks for adding" + potion.getName() + "!";
    }

}
