package by.epam.javaonline.string.stringbuilder;

// Проверить, является ли заданное слово палиндромом.

public class Task3 {

	public static void main(String[] args) {
		
		String[] words = {"Tenet", "Reviver", "Palindrome", "Анна", "String"};
		
		isPalindrome(words);	
	}
	
	public static void isPalindrome(String[] words) {
		
		for(String word: words) {
			
			String reverseWord;
			boolean isPalindrome;
			
			reverseWord = (new StringBuilder(word)).reverse().toString();
			isPalindrome = word.equalsIgnoreCase(reverseWord);
			
			if(isPalindrome) {
				System.out.printf("Слово '%s' является полиндромом.\n", word);
			} else {
				System.out.printf("Слово '%s' не является полиндромом.\n", word);
			}	
		}
	}

}
