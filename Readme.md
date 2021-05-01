# CodechefDataRetriever
A *java web scraping project* (using jsoup) to fetch all important user data just by typing the user id from codechef.com

---

#### CodechefAppManager
This is the main class which contains all of the functionalities


### List of functions and their short description

- **CodechefAppManager(String user_id)**
  - A constructor used to set the userId of the user for which we want to fetch details
- **int getUserCurrentRating()**
  - This function returns current rating of the user
- **String getUserName()**
  - returns Name of the user
- **int getGlobalRank()**
  - returns Global Rank of the user
- **int getCountryRank()**
  - returns Country Rank of the user
- **int getFullySolvedCount()**
  - returns number of problems solved (completely) by user
- **int getPartiallySolvedCount()**
  - returns number of problems solved (partially) by user
