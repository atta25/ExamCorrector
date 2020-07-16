public class SimpleRuleOf3 extends SimpleCriteria {
    @Override
    protected Double calculateNote(Double scoreObtained, Double totalScore) {
        return Math.ceil((scoreObtained * 10) / totalScore);
    }
}
