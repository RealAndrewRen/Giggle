import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
	private String myURL;
	private Map<String, List<String>> myIndex;
	public SearchEngine(String url) {
		myURL = url;
		myIndex = new HashMap<String, List<String>>(20000);
	}
	public String getURL() {
		return myURL;
	}
	public void add(String line) {
		Set<String> words = parseWords(line);
		for (String str : words) {
			if (myIndex.get(str) == null) {
				myIndex.put(str, new LinkedList<String>());
				myIndex.get(str).add(line);
			}
			else {
				myIndex.get(str).add(line);
			}
		}
	}
	public List<String> getHits(String word){
		return myIndex.get(word);
	}
	private Set<String> parseWords(String line){
		String[] words = line.split("\\W+");
		Set<String> result = new TreeSet<String>();
		for (String str : words) {
			if (!str.isEmpty()) {
				result.add(str.toLowerCase());
			}
		}
		return result;
	}
}
