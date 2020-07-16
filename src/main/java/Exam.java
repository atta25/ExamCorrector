import java.util.List;

public class Exam {
    private List<Point> points;
    private Criteria criteria;
    private Double totalScore;
    private Integer minimumPassingScore;

    public Exam(List<Point> points, Criteria criteria, Double totalScore, Integer minimumPassingScore) {
        this.points = points;
        this.criteria = criteria;
        this.totalScore = totalScore;
        this.minimumPassingScore = minimumPassingScore;
    }

    public Boolean approved() {
        Double scoreObtained = 0.0;
        for (Point point : points) {
            scoreObtained += point.score();
        }

        return criteria.calculateTotalNote(scoreObtained, totalScore) >= minimumPassingScore;
    }
}
