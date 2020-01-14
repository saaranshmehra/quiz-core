package fr.epita.quiz.test;

import java.io.IOException;
import java.util.List;

import fr.epita.quiz.datamodel.MCQuestion;
import fr.epita.quiz.datamodel.MCQuestionDAO;

public class TestMCQQuestionCSVDAO {

	public static void main(String[] args) throws IOException {
		MCQuestionDAO dao = new MCQuestionDAO();

		MCQuestion mcqQuestion = new MCQuestion();
		mcqQuestion.setDifficulty(3);
		mcqQuestion.setQuestion("What can we do with JDK?");
		mcqQuestion.setTopics(new String[] { "java", "compilation", "environments" });
		mcqQuestion.setId(1l);

		dao.create(mcqQuestion);

		List<MCQuestion> allQuestions = dao.readAll();
	}

}
