package com.main.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SpringBootApplication
public class Homepage {

    @Autowired
    private VerseAPIService vAPIs;

    @Autowired
    private VerseGenerator vGen;

    @Value("${api.esvbible.url}")
    private String esvapiUrl;
    @Value("${api.esvbible.key}")
    private String esvapiKey;
    @Value("${api.nltbible.url}")
    private String nltApiUrl;
    @Value("${api.nltbible.key}")
    private String nltApiKey;

    public static void main(String[] args)
    {
        SpringApplication.run(Homepage.class, args);
    }

    @GetMapping("/")
    public String hello(Model model)
    {
        VerseReference demo = vGen.randomVerse();

        String text = vAPIs.callEsvVerseAPI(demo,esvapiUrl, esvapiKey);

        model.addAllAttributes(
                java.util.Map.of(
                        "book", demo.getBook(),
                        "chapter", demo.getChapter(),
                        "verse", demo.getVerse(),
                        "text", text,
                        "versions", java.util.List.of("ESV", "NLT", "KJV"),
                        "selectedVersion", "ESV"

                )
        );

        return "index";
    }

    @GetMapping("/fetchNewVerse")
    public String writeNewVerseToHomepage(@RequestParam(defaultValue = "ESV") String version, Model model)
    {
        VerseReference newVerse = vGen.randomVerse();
        String text;

        if ("ESV".equals(version)) {
            text = vAPIs.callEsvVerseAPI(newVerse, esvapiUrl, esvapiKey);
        } else if ("NLT".equals(version) || "KJV".equals(version)) {
            text = vAPIs.callNltVerseAPI(newVerse, nltApiUrl, nltApiKey, version);
        } else {
            text = vAPIs.callEsvVerseAPI(newVerse, esvapiUrl, esvapiKey);
        }

        model.addAllAttributes(
                java.util.Map.of(
                        "book", newVerse.getBook(),
                        "chapter", newVerse.getChapter(),
                        "verse", newVerse.getVerse(),
                        "text", text,
                        "versions", java.util.List.of("ESV", "NLT", "KJV"),
                        "selectedVersion", version
                )
        );

        return "index :: verse-details";
    }

}
