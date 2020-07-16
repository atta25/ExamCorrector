
public class Point {
    protected Integer specificWeight;
    protected String statement;
    protected String response;
    protected String expectedResponse;

    public Point(Integer specificWeight, String statement, String expectedResponse, String response) {
        this.specificWeight = specificWeight;
        this.statement = statement;
        this.expectedResponse = expectedResponse;
        this.response = response;
    }

    public Double score() {
        return checkResponse() ? specificWeight : 0.0;
    }

    private Boolean checkResponse() {
        return expectedResponse.equals(response);
    }
}
