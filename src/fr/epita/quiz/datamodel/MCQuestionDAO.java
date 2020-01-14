
package fr.epita.quiz.datamodel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MCQuestionDAO {

	private static final String TOPIC_DELIMITER = "|||";
	private static final String COLUMN_DELIMITER = "@@@@";

	public void create(MCQuestion mcqQuestion) throws IOException {
		String formatted = String.valueOf(mcqQuestion.getId()) + COLUMN_DELIMITER;
		formatted += String.valueOf(mcqQuestion.getDifficulty()) + COLUMN_DELIMITER;
		formatted += mcqQuestion.getQuestion() + COLUMN_DELIMITER;
		String[] topics = mcqQuestion.getTopics();
		for (int i = 0; i < topics.length; i++) {
			formatted += topics[i] + TOPIC_DELIMITER;
		}
		FileWriter fw=new FileWriter("output.csv"); 
		 
        for (int i = 0; i < formatted.length(); i++) 
            {
        	fw.write(formatted.charAt(i)); 
            }
        fw.close(); 

		System.out.println("formatted");
		System.out.println(formatted);

		// TODO write the formatted string in a file

	}

	public List<MCQuestion> readAll() throws IOException {

		List<MCQuestion> results = new ArrayList<MCQuestion>();
		// TODO read all the "line" values from the file
		int str; 
		String dataToRead = "";
        FileReader fr=null; 
        try
        { 
            fr = new FileReader("text"); 
        } 
        catch (FileNotFoundException fe) 
        { 
            System.out.println("File not found"); 
        } 
 
        while ((str=fr.read())!=-1) 
			dataToRead+= String.valueOf((char)str);    

        fr.close(); 

		String[] parts = dataToRead.split(COLUMN_DELIMITER);
		System.out.println(Arrays.asList(parts));
		Long id = Long.valueOf(parts[0]);
		Integer difficulty = Integer.valueOf(parts[1]);
		String question = parts[2];
		String[] readTopics = parts[3].split(TOPIC_DELIMITER);

		MCQuestion reconstructed = new MCQuestion();
		reconstructed.setDifficulty(difficulty);
		reconstructed.setId(id);
		reconstructed.setQuestion(question);
		reconstructed.setTopics(readTopics);

		return results;
	}

}
