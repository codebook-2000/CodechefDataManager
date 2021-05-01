package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodechefApplication {
    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Codechef User id:-");
        String user_id = buf.readLine();

        CodechefAppManager data = new CodechefAppManager(user_id);

        System.out.println("User Rating = " + data.getUserCurrentRating());
        System.out.println("User Name = " + data.getUserName());
        System.out.println("Global Rank of User = " + data.getGlobalRank());
        System.out.println("Country Rank of User = " + data.getCountryRank());
        System.out.println("No of Fully Solved Questions = " + data.getFullySolvedCount());
        System.out.println("No of Partially Solved Questions = " + data.getPartiallySolvedCount());
    }
}
