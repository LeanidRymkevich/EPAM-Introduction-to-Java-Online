package by.epam.javaonline.task4_2_1;

import java.util.Objects;

public class Sentence {
	
	private String sentence;
	
	public Sentence() {
		sentence = "";
	}
	
	public Sentence(String sentence) {
		this.sentence = sentence;
		
	}
	
	public Sentence(Word...words) {
		sentence = wordsToSentence(words);
	}
	
	private String wordsToSentence(Word...words) {
		
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < words.length; i++) {
			result.append(words[i].getWord() + " ");
		}
		result.deleteCharAt(result.length()-1).append('.');
		return result.toString();
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sentence);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sentence other = (Sentence) obj;
		return Objects.equals(sentence, other.sentence);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[sentence=" + sentence + "]";
	}
	
	
}
