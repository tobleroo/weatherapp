package model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

public class GetSearchHistory {
    
    public static List<SearchHistoryObject> createHistoryList(Cookie[] searchCookie){

        List<SearchHistoryObject> history = new ArrayList<>();


        for(Cookie cookie : searchCookie){
            //if the right cookie exists
            if(cookie.getName().equals("searchHistory")){

                // splits into each pair, example malmo/sweden
                String[] searchPairs = cookie.getValue().split("-");
                // if search history has more than 5 searches
                if(searchPairs.length >= 5){
                    
                    //run through the list in reverse to get 5 latest searches
                    for(int i = searchPairs.length; i > searchPairs.length-5; i--){
                        String [] divided = searchPairs[i-1].split("/");
                        System.out.println(divided);
                        SearchHistoryObject searchObj = new SearchHistoryObject(divided[0] , divided[1]);
                        history.add(searchObj);
                    }

                }else{
                    //if there is less than 5 searches, add all to list
                    for(String cityCountry : searchPairs){
                        String [] divided = cityCountry.split("/");
    
                        SearchHistoryObject searchObj = new SearchHistoryObject(divided[0] , divided[1]);
                        history.add(searchObj);
                    }

                }



            }
        }

        return history;
    }
}
