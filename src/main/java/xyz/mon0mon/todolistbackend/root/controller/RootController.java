package xyz.mon0mon.todolistbackend.root.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class RootController {
    @Autowired
    private BuildProperties buildProperties;

    @GetMapping("/")
    public String index() {
        return "main";
    }

    @GetMapping("/version")
    public String version() {
        return buildProperties.get("version");
    }
}
