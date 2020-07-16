import java.util.List;

public class Average extends CompositeCriteria {
    protected Average(List<Criteria> criteriaList) {
        super(criteriaList);
    }

    @Override
    protected Double getFinalNote(List<Double> notes) {
        return notes.stream().mapToDouble(note -> note).average().getAsDouble();
    }
}