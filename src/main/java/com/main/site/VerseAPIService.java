package com.main.site;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Objects;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Service
public class VerseAPIService {
    Logger logger = LogManager.getLogger(VerseAPIService.class);

    public String callEsvVerseAPI(VerseReference ref, String apiUrl, String apiKey) {
        String query = ref.toString();
        String modifiers = "include-passage-references=false&include-verse-numbers=false&include-footnotes=false&include-headings=false&include-short-copyright=false";
        String url = apiUrl + "?" + modifiers +"&q=" + query;

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", apiKey);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<ESVApiResponseDTO> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    ESVApiResponseDTO.class
            );

            return Objects.requireNonNull(response.getBody()).getPassages().getFirst().trim();
        } catch (Exception e) {
            logger.error("Error calling the ESV verse API: {}", e.getMessage());
            return "Looks like there was an error fetching the verse. Please try again later. :(";
        }
    }

    public String callNltVerseAPI(VerseReference ref, String apiUrl, String apiKey, String version) {
        String query = ref.toString();
        String vc = "version=" + version;
        String url = apiUrl + "?" + vc +"&key="+apiKey+ "&ref=" + query;

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<>(new HttpHeaders());

            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            // Parse HTML and extract verse text
            Document doc = Jsoup.parse(Objects.requireNonNull(response.getBody()));
            Element bibleTextDiv = doc.getElementById("bibletext");

            Objects.requireNonNull(bibleTextDiv).select("a.a-tn, span.tn, span.vn, h2").remove();
            return bibleTextDiv.text().trim();

        } catch (Exception e) {
            logger.error("Error calling the NLT verse API: {}", e.getMessage());
            return "Looks like there was an error fetching the verse. Please try again later. :(";
        }
    }



}