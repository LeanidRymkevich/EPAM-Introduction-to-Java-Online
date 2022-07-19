package by.epam.javaonline.task4_2_1;

/* 1. Создать объект класса Текст, используя классы Предложение, Слово.
 * Методы: дополнить текст, вывести на консоль текст, заголовок текста.*/

public class Main {

	public static void main(String[] args) {
		
		String headline = "At the English Lesson";
		
		Word word1 = new Word("I");
		Word word2 = new Word("have");
		Word word3 = new Word("English");
		Word word4 = new Word("on");
		Word word5 = new Word("Mondays");
		
		Sentence sentence1 = new Sentence(word1, word2, word3, word4, word5);
		Sentence sentence2 = new Sentence("English is usually the second lesson.");
		Sentence sentence3 = new Sentence("At the English lesson we speak, read and write.");
		Sentence sentence4 = new Sentence("We speak about school, pupils and teachers, about lessons, animals and nature, about our friends, sports and games.");
		Sentence sentence5 = new Sentence("We read books and stories about children, nature, school life and so on.");
		
		Text text = new Text(headline, sentence1, sentence2, sentence3, sentence4);
		
		text.addSentence(sentence5);
		text.printHeadline();
		System.out.println();
		text.printContent();
	}

}
