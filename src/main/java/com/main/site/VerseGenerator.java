package com.main.site;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jakarta.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class VerseGenerator {
    private final List<VerseReference> verseRefMasterList = new CopyOnWriteArrayList<>();
    private final Gson gson = new Gson();
    private final File file = new File("src/main/resources/static/init_verse_refs.json");
    Logger logger = LogManager.getLogger(VerseGenerator.class);

    @PostConstruct
    public void loadFromFile() {
        try {
            if (file.exists()) {
                Type listType = new TypeToken<List<VerseReference>>(){}.getType();
                List<VerseReference> loaded = gson.fromJson(new FileReader(file), listType);
                if (loaded != null) {
                    verseRefMasterList.addAll(loaded);
                }
                logger.info("Initial Verse References Loaded, Size: {}", verseRefMasterList.size());
            }
        } catch (IOException e) {
            logger.error("Failed to load verse references: {}", e.getMessage());
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
        saveToFile();
    }

    public void removeVerseReference(VerseReference reference) {
        verseRefMasterList.remove(reference);
        saveToFile();
    }

    public List<VerseReference> getAllVerseReferences() {
        return List.copyOf(verseRefMasterList);
    }

    private void saveToFile() {
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(verseRefMasterList, writer);
        } catch (IOException e) {
            logger.error("Failed to save verse references: {}", e.getMessage());
        }
    }
}