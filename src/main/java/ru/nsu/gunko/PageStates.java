package ru.nsu.gunko;

import java.net.URL;
import java.util.*;

public class PageStates {
    private Map<URL, String> yesterdaysPages;
    private Map<URL, String> todaysPages;

    public PageStates(Map<URL, String> yesterdaysPages, Map<URL, String> todaysPages) {
        Objects.requireNonNull(yesterdaysPages, "yesterdaysPages must not be null");
        this.yesterdaysPages = yesterdaysPages;

        Objects.requireNonNull(todaysPages, "todaysPages must not be null");
        this.todaysPages = todaysPages;
    }

    public void setYesterdaysPages(Map<URL, String> yesterdaysPages) {
        Objects.requireNonNull(yesterdaysPages, "yesterdaysPages must not be null");
        this.yesterdaysPages = yesterdaysPages;
    }

    public void setTodaysPages(Map<URL, String> todaysPages) {
        Objects.requireNonNull(todaysPages, "todaysPages must not be null");
        this.todaysPages = todaysPages;
    }

    public Map<URL, String> getYesterdaysPages() {
        return yesterdaysPages;
    }

    public Map<URL, String> getTodaysPages() {
        return todaysPages;
    }
}
