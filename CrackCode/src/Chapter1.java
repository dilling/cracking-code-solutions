
public class Chapter1 {

	public static void main(String[] args) {

		String s = "testing";
		Chapter1 chapter1 = new Chapter1();
		
		// 1.1 hasUniqueCharacters
		System.out.println(Boolean.toString(chapter1.hasUniqueCharacters(s)));
		
		// 1.2 reverseString
		System.out.println(chapter1.reverseString(s));
		
		// 1.3 removeDublicates
		System.out.println(chapter1.removeDuplicates(s));
		
		// 1.3 Test Cases
		String[] cases = {"oompaloompa", "ubiquitous", "uncopyrightables"};
		for(String test: cases)
			System.out.println(chapter1.removeDuplicates(test));
		
		// 1.4 isAnagram
		String s1 = "this", s2 = "sith";
		System.out.println(Boolean.toString(chapter1.isAnagram(s1,s2)));
		
		// 1.5 replaceSpaces
		s = "THIS IS NOT A TEST";
		System.out.println(chapter1.replaceSpaces(s));
		
	}
	
	// 1.1 Implement an algorithm to determine if a string has all unique characters.
	public boolean hasUniqueCharacters(String s) {
		
		int i = 0;
		char c;
		
		while(i<s.length()-1) {
			c = s.charAt(i);
			for(int j = i+1; j<s.length(); j++){
				if(c == s.charAt(j)) return false;
			}
			i++;
		}
		return true;
	}
	
	// 1.2 Write code to reverse a C-Style String
	public String reverseString (String s) {
		StringBuilder builder = new StringBuilder();
		
		for (int i = s.length()-1; i>=0; i--){
			builder.append(s.charAt(i));
		}
		
		return builder.toString();
	}
	
	 // 1.3 Design an algorithm and write code to remove the duplicate characters 
	 // 	in a string without using any additional buffer
	public String removeDuplicates(String s){
		for(int i=0; i<s.length(); i++){
			for(int j=i+1; j<s.length(); j++){
				if(s.charAt(i)==s.charAt(j)){
					s = s.substring(0, j) + s.substring(j+1);
					j--;
				}
			}
		}
		return s;
	}
	
	// 1.4 Write a method to decide if two strings are anagrams or not.
	public boolean isAnagram(String s1, String s2){
		if(s1.length()!=s2.length()) return false;
		
		int[] index = new int[26];
		for(int i=0; i<s1.length(); i++){
			index[Character.toLowerCase(s1.charAt(i))-'a']++;
			index[Character.toLowerCase(s2.charAt(i))-'a']--;
		}
		for(int i:index) if(i!=0) return false;
		return true;
	}
	
	// 1.5 Write a method to replace all spaces in a string with ‘%20’.
	public String replaceSpaces(String s){
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)==' '){
				s = s.substring(0, i) + "%20" + s.substring(i+1);
				i = i+2;
			}
		}
		return s;
	}
}
