import java.util.ArrayList;
import java.util.List;

public abstract class CompositeCriteria implements Criteria {
    protected List<Criteria> criteriaList;

    protected CompositeCriteria(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public Double calculateTotalNote(Double scoreObtained, Double totalScore) {
        List<Double> notes = new ArrayList<>();
        for (Criteria criteria : criteriaList) {
            notes.add(criteria.calculateTotalNote(scoreObtained, totalScore));
        }
        return getFinalNote(notes);
    }

    abstract protected Double getFinalNote(List<Double> notes);
}
