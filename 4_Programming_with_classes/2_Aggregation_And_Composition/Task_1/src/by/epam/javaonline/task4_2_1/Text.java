package by.epam.javaonline.task4_2_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Text {
	
	private String headline;
	private final List<Sentence> content;
	
	public Text() {
		content = new ArrayList<>();
		headline = "";
	}
	
	public Text(String headline) {
		this.headline = headline;
		this.content = new ArrayList<>();
	}
	
	public Text(Sentence...sentences) {
		headline = "";
		this.content = new ArrayList<>();
		this.content.addAll(Arrays.asList(sentences));
	}
	
	public Text(String headline, Sentence...sentences) {
		this.headline = headline;
		this.content = new ArrayList<>();
		this.content.addAll(Arrays.asList(sentences));
	}

	public String getHeadline() {
		return headline;
	}

	public List<Sentence> getSentences() {
		return content;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	public void addSentence(Sentence sentence) {
		content.add(sentence);
	}
	
	public void printHeadline() {
		System.out.println(headline);
	}
	
	public void printContent() {
		for(Sentence sentence: content) {
			System.out.print(sentence.getSentence() + " ");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, headline);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Text other = (Text) obj;
		return Objects.equals(content, other.content) && Objects.equals(headline, other.headline);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	
}
