import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExamTest {
    @Test
    public void simpleCriteriaTest() {
        Point vf = new Point(2, "Argentina ganó 2 mundiales", "true", "true");
        Point multipleChoice = new Point(4, "El resultado de 1 + 1 es: 1 | 2", "2", "2");
        Point concreteQuestion = new Point(4, "Cuál es la capital de  Brasil?", "Brasilia", "Río de Janeiro");

        List<Point> points = Arrays.asList(vf, multipleChoice, concreteQuestion);

        Exam examWithMinimumNote4 = new Exam(points, new SubtractN(1), 10.0, 4);
        assertTrue(examWithMinimumNote4.approved());
        Exam examWithMinimumNote6 = new Exam(points, new SubtractN(1), 10.0, 6);
        assertFalse(examWithMinimumNote6.approved());
    }

    @Test
    public void compositeCriteriaTest() {
        Point vf = new Point(2, "Argentina ganó 2 mundiales", "true", "false");
        Point multipleChoice = new Point(4, "El resultado de 1 + 1 es: 1 | 2", "2", "2");
        Point concreteQuestion = new Point(4, "Cuál es la capital de  Brasil?", "Brasilia", "Río de Janeiro");

        List<Point> points = Arrays.asList(vf, multipleChoice, concreteQuestion);

        HighestNote highestNote = new HighestNote(Arrays.asList(new SubtractN(1), new SimpleRuleOf3()));
        Exam examWithHighestNoteCriteria = new Exam(points, highestNote, 10.0, 4);
        assertTrue(examWithHighestNoteCriteria.approved());

        Average average = new Average(Arrays.asList(new SubtractN(2), new SimpleRuleOf3()));
        Exam examWithAverageCriteria = new Exam(points, average, 10.0, 4);
        assertFalse(examWithAverageCriteria.approved());
    }
}
