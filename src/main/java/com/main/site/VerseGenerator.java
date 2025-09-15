package com.main.site;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jakarta.annotation.PostConstruct;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class VerseGenerator {
    private final List<VerseReference> verseRefMasterList = new CopyOnWriteArrayList<>();
    private final Gson gson = new Gson();
    Logger logger = LogManager.getLogger(VerseGenerator.class);

    @PostConstruct
    private void loadFromResource() {
        String resourcePath = "/static/init_verse_refs.json";
        try (InputStream is = getClass().getResourceAsStream(resourcePath)) {
            if (is != null) {
                Type listType = new TypeToken<List<VerseReference>>(){}.getType();
                List<VerseReference> loaded = gson.fromJson(new InputStreamReader(is), listType);
                if (loaded != null) {
                    verseRefMasterList.addAll(loaded);
                }
                logger.info("Initial Verse References Loaded from resource, Size: {}", verseRefMasterList.size());
            }
        } catch (IOException e) {
            logger.error("Failed to load verse references from resource: {}", e.getMessage());
        }
    }

    public VerseReference randomVerse() {
        if (!verseRefMasterList.isEmpty()) {
            int idx = ThreadLocalRandom.current().nextInt(verseRefMasterList.size());
            return verseRefMasterList.get(idx);
        }
        return null;
    }

    public void addVerseReference(VerseReference reference) {
        verseRefMasterList.add(reference);
    }

    public void removeVerseReference(VerseReference reference) {
        verseRefMasterList.remove(reference);
    }

    public List<VerseReference> getAllVerseReferences() {
        return List.copyOf(verseRefMasterList);
    }

}