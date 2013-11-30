/*
 *Given a dictionary, find all of the longest words in the dictionary.

Example
Given

{
  "dog",
  "google",
  "facebook",
  "internationalization",
  "blabla"
}
the longest words are(is) ["internationalization"].

Given

{
  "like",
  "love",
  "hate",
  "yes"
}
the longest words are ["like", "love", "hate"].

Challenge
It's easy to solve it in two passes, can you do it in one pass?
 */
public class LongestWords {

    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> result = new ArrayList<String>();
        int maxLength = 0;
        for (String s : dictionary) {
            if (s.length() >= maxLength) {
                if (s.length() > maxLength) {
                    result.clear();
                    maxLength = s.length();
                }
                result.add(s);
            }
        }
        return result;
    }

}
