package dev.ihm.options;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import dev.exception.PlatException;

@Controller
@Order(30)
public class OptionTerminer implements IOptionMenu {
    @Override
    public String getTitre() {
        return "Terminer";
    }

    @Override
    public void executer() {
        throw new PlatException("Aurevoir");
    }
}
