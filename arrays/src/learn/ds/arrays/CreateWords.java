package learn.ds.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Write an algorithm to justify text. Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.

More specifically, you should have as many words as possible in each line. There should be at least one space between each word. Pad extra spaces when necessary so that each line has exactly length k. Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.

If you can only fit one word on a line, then you should pad the right-hand side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:

["the  quick brown", # 1 extra space on the left
"fox  jumps  over", # 2 extra spaces distributed evenly
"the   lazy   dog"] # 4 extra spaces distributed evenly


 * @author manoj
 *
 */
public class CreateWords {

	public static void main(String[] args) {

		String[] words = {"the", "quick", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
		System.out.println(createWords(words, 16));
		
	}

	public static List<String> createWords(String[] words, int k) {
		

		String word = words[0];
		List<String> newWords = new ArrayList<>();
		for(int i=1; i<words.length; i++) {
			
			if(word.length() < k) {
				word = word + " " + words[i];
			}
			else if(word.length() == k) {
				newWords.add(word);
				word = words[i];
			} else {
				String newWord = word.trim();
				newWord = word.substring(0, newWord.length() - words[i-1].length()).trim();
				
				word = words[i-1] + " " + words[i];
				
				int extraLength = k - newWord.length();
				String[] newTempWords = newWord.split(" "); 
				int numberOfSpaces = newTempWords.length-1;
				
				int numberOfSpaceTobeAdded = extraLength/numberOfSpaces;
				int numberOfSpaceTobeAddedFromFirstWord = extraLength%numberOfSpaces;
				if(numberOfSpaceTobeAdded > 0 || numberOfSpaceTobeAddedFromFirstWord > 0) {
					
					StringBuilder newSpaces = new StringBuilder(" ");
					for(int space = 0; space < numberOfSpaceTobeAdded; space++) {
						newSpaces.append(" ");
					}
					String bigWord = "";
					for(int l =0; l <   newTempWords.length; l++) {
						
						String tempWord = newTempWords[l];
						bigWord = bigWord + tempWord ;
						if(l < newTempWords.length - 1)
						bigWord = bigWord + newSpaces.toString();
						if(l < numberOfSpaceTobeAddedFromFirstWord) {
							bigWord = bigWord + " ";
						}
					}	
					if(bigWord != null) {
						newWords.add(bigWord);
					}
				} else {
					newWords.add(newWord);
				}
				
				
			}
			
			
		}
		
		if(word.length() > 0) {
			int extraLength = k - word.length();
			String[] newTempWords = word.split(" "); 
			int numberOfSpaces = newTempWords.length-1;
			
			int numberOfSpaceTobeAdded = extraLength/numberOfSpaces;
			int numberOfSpaceTobeAddedFromFirstWord = extraLength%numberOfSpaces;
			if(numberOfSpaceTobeAdded > 0 || numberOfSpaceTobeAddedFromFirstWord > 0) {
				
				StringBuilder newSpaces = new StringBuilder(" ");
				for(int space = 0; space < numberOfSpaceTobeAdded; space++) {
					newSpaces.append(" ");
				}
				String bigWord = "";
				for(int l =0; l <   newTempWords.length; l++) {
					
					String tempWord = newTempWords[l];
					bigWord = bigWord + tempWord ;
					if(l < newTempWords.length - 1)
					bigWord = bigWord + newSpaces.toString();
					if(l < numberOfSpaceTobeAddedFromFirstWord) {
						bigWord = bigWord + " ";
					}
				}	
				if(bigWord != null) {
					newWords.add(bigWord);
				}
			} else {
				newWords.add(word);
			}
		
		}
		
		return newWords;
	}
}
