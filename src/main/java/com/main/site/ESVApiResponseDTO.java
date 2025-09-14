package com.main.site;

import java.util.List;

public class ESVApiResponseDTO {
    private String query;
    private String canonical;
    private List<List<Integer>> parsed;
    private List<PassageMeta> passage_meta;
    private List<String> passages;

    // Getters and setters
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getCanonical() {
        return canonical;
    }

    public void setCanonical(String canonical) {
        this.canonical = canonical;
    }

    public List<List<Integer>> getParsed() {
        return parsed;
    }

    public void setParsed(List<List<Integer>> parsed) {
        this.parsed = parsed;
    }

    public List<PassageMeta> getPassage_meta() {
        return passage_meta;
    }

    public void setPassage_meta(List<PassageMeta> passage_meta) {
        this.passage_meta = passage_meta;
    }

    public List<String> getPassages() {
        return passages;
    }

    public void setPassages(List<String> passages) {
        this.passages = passages;
    }

    public static class PassageMeta {
        private String canonical;
        private List<Integer> chapter_start;
        private List<Integer> chapter_end;
        private Integer prev_verse;
        private Integer next_verse;
        private List<Integer> prev_chapter;
        private List<Integer> next_chapter;

        // Getters and setters
        public String getCanonical() {
            return canonical;
        }

        public void setCanonical(String canonical) {
            this.canonical = canonical;
        }

        public List<Integer> getChapter_start() {
            return chapter_start;
        }

        public void setChapter_start(List<Integer> chapter_start) {
            this.chapter_start = chapter_start;
        }

        public List<Integer> getChapter_end() {
            return chapter_end;
        }

        public void setChapter_end(List<Integer> chapter_end) {
            this.chapter_end = chapter_end;
        }

        public Integer getPrev_verse() {
            return prev_verse;
        }

        public void setPrev_verse(Integer prev_verse) {
            this.prev_verse = prev_verse;
        }

        public Integer getNext_verse() {
            return next_verse;
        }

        public void setNext_verse(Integer next_verse) {
            this.next_verse = next_verse;
        }

        public List<Integer> getPrev_chapter() {
            return prev_chapter;
        }

        public void setPrev_chapter(List<Integer> prev_chapter) {
            this.prev_chapter = prev_chapter;
        }

        public List<Integer> getNext_chapter() {
            return next_chapter;
        }

        public void setNext_chapter(List<Integer> next_chapter) {
            this.next_chapter = next_chapter;
        }
    }
}