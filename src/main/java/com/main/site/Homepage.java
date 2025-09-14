package com.main.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;

@Controller
@SpringBootApplication
public class Homepage {

    @Autowired
    private VerseAPIService vAPIs;

    @Autowired
    private VerseGenerator vGen;

    @Value("${api.bible.url}")
    private String apiUrl;
    @Value("${api.bible.key}")
    private String apiKey;

    public static void main(String[] args)
    {
        SpringApplication.run(Homepage.class, args);
    }

    @GetMapping("/")
    public String hello(Model model)
    {
        VerseReference demo = vGen.randomVerse();

        String text = vAPIs.callEsvVerseAPI(demo,apiUrl, apiKey);

        model.addAllAttributes(
                java.util.Map.of(
                        "book", demo.getBook(),
                        "chapter", demo.getChapter(),
                        "verse", demo.getVerse(),
                        "text", text
                )
        );

        return "index";
    }

    @GetMapping("/fetchNewVerse")
    public String writeNewVerseToHomepage(Model model)
    {
        VerseReference newVerse = vGen.randomVerse();

        String text = vAPIs.callEsvVerseAPI(newVerse,apiUrl,apiKey);

        model.addAllAttributes(
                java.util.Map.of(
                        "book", newVerse.getBook(),
                        "chapter", newVerse.getChapter(),
                        "verse", newVerse.getVerse(),
                        "text", text
                )
        );

        return "index :: verse-details";
    }

    @GetMapping("/modal/copyright")
    public String showCopyrightModal() {
        return "/copyright-modal :: copyright-modal-active";
    }

    @PatchMapping("/modal/close")
    public String closeCopyrightModal() {
        return "/copyright-modal :: copyright-modal-inactive";
    }

}
