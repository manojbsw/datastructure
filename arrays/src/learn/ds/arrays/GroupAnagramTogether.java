package learn.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.techiedelight.com/group-anagrams-together-given-list-words/
 * @author manoj
 *
 */
public class GroupAnagramTogether {

	public static void main(String[] args) {
		String[] words = {
				"CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE",
				"PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
				"SUED", "LEAN", "SCAR", "DESIGN"
			};

		groupAnagrams(words);
	}

	
	public static void groupAnagrams(String words[]) {
		
		List<String> wordList = Arrays.stream(words).
				              map(word -> Stream.of(word.split("")).sorted().collect(Collectors.joining())).collect(Collectors.toList());
		

		Map<String, List<Integer>> word_count_map = new HashMap();
		
		for(int i=0; i<wordList.size(); i++) {
			
			word_count_map.putIfAbsent(wordList.get(i), new ArrayList<Integer>());
			word_count_map.get(wordList.get(i)).add(i);
			
		}
		
		for(Entry<String, List<Integer>> entry : word_count_map.entrySet())  {
			
			entry.getValue().stream().forEach(val -> System.out.println(words[val] + ""));
			System.out.println("");
			
		}
			

	}
}
