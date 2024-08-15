package ru.nsu.gunko;

import java.net.URL;
import java.util.*;

public class Analyzer {
    public static Vector<Vector<URL>> fullAnalysis(PageStates pageStates) {
        Map<URL, String> yesterdaysPages = pageStates.getYesterdaysPages();
        Set<URL> urlsYesterday = yesterdaysPages.keySet();

        Map<URL, String> todaysPages = pageStates.getTodaysPages();
        Set<URL> urlsToday = todaysPages.keySet();

        Vector<Vector<URL>> fullAnalysis = new Vector<>(3);
        // 0 - disappeared pages, 1 - new pages, 2 - changed pages

        for (int i = 0; i < 3; ++i) {
            fullAnalysis.add(new Vector<>());
        }

        for (URL url : urlsYesterday) {
            if (!todaysPages.containsKey(url)) {
                fullAnalysis.get(0).add(url);
            } else if (!yesterdaysPages.get(url).equals(todaysPages.get(url))) {
                fullAnalysis.get(2).add(url);
            }
        }

        for (URL url : urlsToday) {
            if (!yesterdaysPages.containsKey(url)) {
                fullAnalysis.get(1).add(url);
            }
        }

        return fullAnalysis;
    }

    public static Vector<URL> disappearedPages(PageStates pageStates) {
        Map<URL, String> todaysPages = pageStates.getTodaysPages();
        Set<URL> urls = pageStates.getYesterdaysPages().keySet();

        Vector<URL> disappearedPages = new Vector<>();

        for (URL url : urls) {
            if (!todaysPages.containsKey(url)) {
                disappearedPages.add(url);
            }
        }

        return disappearedPages;
    }

    public static Vector<URL> newPages(PageStates pageStates) {
        Map<URL, String> yesterdaysPages = pageStates.getYesterdaysPages();
        Set<URL> urls = pageStates.getTodaysPages().keySet();

        Vector<URL> newPages = new Vector<>();

        for (URL url : urls) {
            if (!yesterdaysPages.containsKey(url)) {
                newPages.add(url);
            }
        }

        return newPages;
    }

    public static Vector<URL> changedPages(PageStates pageStates) {
        Map<URL, String> yesterdaysPages = pageStates.getYesterdaysPages();
        Map<URL, String> todaysPages = pageStates.getTodaysPages();
        Set<URL> urls = yesterdaysPages.keySet();

        Vector<URL> changedPages = new Vector<>();

        for (URL url : urls) {
            if (todaysPages.containsKey(url) &&
                    !yesterdaysPages.get(url).equals(todaysPages.get(url))) {
                changedPages.add(url);
            }
        }

        return changedPages;
    }
}
