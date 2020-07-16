public class SubtractN extends SimpleCriteria {
    private Integer pointsToSubtract;

    public SubtractN(Integer pointsToSubtract) {
        this.pointsToSubtract = pointsToSubtract;
    }

    @Override
    protected Double calculateNote(Double scoreObtained, Double totalScore) {
        return scoreObtained - pointsToSubtract;
    }
}
