public class TestClient {

	public static void main(String[] args) {

		//randomly pick the String comparison strategy
		FacadeMetrics facadeMetrics = new FacadeMetrics(MetricsCalculatorStrategy.STRING_COMPARISON);
		facadeMetrics.analyseJavaFile("Test.java", "Metrics.csv");
	}
}