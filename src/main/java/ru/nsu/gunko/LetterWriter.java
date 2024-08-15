package ru.nsu.gunko;

import java.net.URL;
import java.util.Vector;

public class LetterWriter {
    public static String writeLetter(PageStates pageStates, String fullName) {
        StringBuilder letter = new StringBuilder();

        Vector<Vector<URL>> fullAnalysis = Analyzer.fullAnalysis(pageStates);
        // 0 - disappeared pages, 1 - new pages, 2 - changed pages

        letter.append("Здравствуйте, дорогая(ой) ").append(fullName).append("\n\n");
        letter.append("За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n\n");

        letter.append("Исчезли следующие страницы: ").append(writeList(fullAnalysis.get(0))).append("\n");
        letter.append("Появились следующие новые страницы: ").append(writeList(fullAnalysis.get(1))).append("\n");
        letter.append("Изменились следующие страницы: ").append(writeList(fullAnalysis.get(2))).append("\n\n");

        letter.append("С уважением, автоматизированная система мониторинга.\n");

        return letter.toString();
    }

    private static String writeList(Vector<URL> urls) {
        StringBuilder list = new StringBuilder();

        for (URL url : urls) {
            list.append(url).append(", ");
        }

        if (!list.isEmpty()) {
            list.delete(list.length() - 2, list.length());
        }

        return list.toString();
    }
}
