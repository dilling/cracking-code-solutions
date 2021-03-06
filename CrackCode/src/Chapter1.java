import java.util.Random;

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
		
		// 1.6 rotate90
		byte[][][] image = chapter1.randomImage(5);
		chapter1.printByteArray(image);
		chapter1.rotate90(image);
		chapter1.printByteArray(image);
		
		// 1.7 propigateZeros
		int[][] intArray = chapter1.randomIntArray(5, 6);
		chapter1.printIntArray(intArray);
		chapter1.propigateZeros(intArray);
		chapter1.printIntArray(intArray);
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
	
	// 1.5 Write a method to replace all spaces in a string with �%20�.
	public String replaceSpaces(String s){
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)==' '){
				s = s.substring(0, i) + "%20" + s.substring(i+1);
				i = i+2;
			}
		}
		return s;
	}
	
	// 1.6 Given an image represented by an NxN matrix, where each pixel in the 
	// image is 4 bytes, write a method to rotate the image by 90 degrees	
	public void rotate90(byte[][][] image){
		byte[] temp;
		int length = image[0].length - 1;
		int middle = (int) (length+2)/2;
		for(int i=0; i<middle; i++){
			for(int j=0; j<middle-1; j++){
				temp = image[i][j];
				image[i][j] = image[j][length-i];
				image[j][length-i] = image[length-i][length-j];
				image[length-i][length-j] = image[length-j][i];
				image[length-j][i] = temp;
			}
		}
	}
	
	// 1.7 Write an algorithm such that if an element in an MxN matrix is 0, 
	//	   its entire row and column is set to 0.
	public void propigateZeros(int[][] inputMatrix){
		int length = inputMatrix.length;
		int width = inputMatrix[0].length;
		boolean[] zerosAtI = new boolean[length];
		boolean[] zerosAtJ = new boolean[width];
		
		// finds zeros
		for(int i=0; i<length; i++){
			for(int j=0; j<width; j++){
				if(inputMatrix[i][j]==0){
					zerosAtI[i]=true;
					zerosAtJ[j]=true;
				}
			}
		}
		
		// sets zeros
		for(int n=0; n<length; n++){
			if(zerosAtI[n]){
				for(int w=0; w<width; w++) 
					inputMatrix[n][w]=0;
			}
		}
		for(int n=0; n<width; n++){
			if(zerosAtJ[n]){
				for(int l=0; l<length; l++) 
					inputMatrix[l][n]=0;
			}
		}
	}
	
	/************************************* HELPER METHODS ************************************************************/
	
	private byte[][][] randomImage(int n){
		byte[][][] image = new byte[n][n][4];
		Random rand = new Random();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				rand.nextBytes(image[i][j]);
			}
		}
		return image;
	}
	
	private void printByteArray(byte[][][] byteArray){
		int length = byteArray[0].length;
		int size = byteArray[0][0].length;
		
		for(int i=0; i<length; i++){
			for(int j=0; j<size; j++){
				for(int k=0; k<length; k++){
					System.out.format("%5d", byteArray[i][k][j]);
				}
				System.out.print("    ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private int[][] randomIntArray(int n, int m){
		int[][] intArray = new int[n][m];
		Random rand = new Random();
		
		for(int i=0;i<n; i++){
			for(int j=0; j<m; j++){
				intArray[i][j] = rand.nextInt(10);
			}
		}
		return intArray;
	}
	
	private void printIntArray(int[][] intArray){
		int length = intArray.length;
		int width = intArray[0].length;
		
		for(int i=0;i<length; i++){
			for(int j=0; j<width; j++){
				System.out.print(intArray[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

