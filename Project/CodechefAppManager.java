package com.codechef;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CodechefAppManager {
    private final Document doc;
    private final String user_id;

    public CodechefAppManager(String user_id) throws Exception {
        this.user_id = user_id;
        doc = Jsoup.connect("https://www.codechef.com/users/" + user_id).timeout(5000).get();
        if (doc.baseUri().equals("https://www.codechef.com/"))
            throw new Exception("Wrong userId");
    }

    public int getUserCurrentRating() {
        Elements userRating = doc.select("div.rating-number");
        return Integer.parseInt(userRating.html());
    }

    public String getUserName() {
        Elements userName = doc.select("div.user-details-container.plr10 header h2");
        return userName.html();
    }

    public int getGlobalRank() {
        Element global_rank = doc.select("div.rating-ranks ul.inline-list li a strong").get(0);
        return Integer.parseInt(global_rank.html());
    }

    public int getCountryRank() {
        Element country_rank = doc.select("div.rating-ranks ul.inline-list li a strong").get(1);
        return Integer.parseInt(country_rank.html());
    }

    public int getFullySolvedCount() {
        Element count = doc.select("section.rating-data-section.problems-solved div.content h5").get(0);
        return Integer.parseInt(extractNumber(count.html()));
    }

    public int getPartiallySolvedCount() {
        Element count = doc.select("section.rating-data-section.problems-solved div.content h5").get(1);
        return Integer.parseInt(extractNumber(count.html()));
    }

    public String extractNumber(String s) {
        char[] ch = s.toCharArray();
        int index = -1;
        String st = "";
        for (int j = 0; j < ch.length; j++) {
            if (ch[j] == '(') {
                index = j;
                break;
            }
        }
        for (int j = index + 1; j < ch.length; j++) {
            if (ch[j] == ')')
                break;
            st += ch[j];
        }
        return st;
    }
}
