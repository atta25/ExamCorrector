public abstract class SimpleCriteria implements Criteria {
    @Override
    public Double calculateTotalNote(Double scoreObtained, Double totalScore) {
        return calculateNote(scoreObtained, totalScore);
    }

    abstract protected Double calculateNote(Double scoreObtained, Double totalScore);
}
