package xyz.mon0mon.todolistbackend.item.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ItemController {
    @GetMapping("/item")
    public String index() {
        return "item";
    }
}
