import java.util.List;

public class HighestNote extends CompositeCriteria {
    protected HighestNote(List<Criteria> criteriaList) {
        super(criteriaList);
    }

    @Override
    protected Double getFinalNote(List<Double> notes) {
        return notes.stream().mapToDouble(note -> note).max().getAsDouble();
    }
}
