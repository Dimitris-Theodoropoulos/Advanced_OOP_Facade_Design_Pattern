import java.io.File;

public class FacadeMetrics {

	private MetricsCalculatorStrategy metricsCalculatorStrategy;
	private MetricCalculator metricCalculator;

	public FacadeMetrics(MetricsCalculatorStrategy metricsCalculatorStrategy) {
		this.metricsCalculatorStrategy = metricsCalculatorStrategy;
	}

	public void setMetricCalculatorType(MetricsCalculatorStrategy metricsCalculatorStrategy) {
		this.metricsCalculatorStrategy = metricsCalculatorStrategy;
	}

	public MetricsCalculatorStrategy getMetricsCalculatorStrategy() {
		return this.metricsCalculatorStrategy;
	}

	public void analyseJavaFile(String inputFile, String outputFile) {
		File readFile = new File(inputFile);
		File writeFile = new File(outputFile);

		calculateMetrics(readFile, this.metricsCalculatorStrategy);

		writeCsvFile(writeFile, metricCalculator.getCsv());
	}

	private void calculateMetrics(File readFile, MetricsCalculatorStrategy metricsCalculatorStrategy) {
		metricCalculator.calculateAll(FileHandler.readFile(readFile));
		this.metricCalculator = MetricCalculatorFactory.createMetricCalculator(readFile, metricsCalculatorStrategy);
	}

	private void writeCsvFile(File writeFile, String metricsText) {
		FileHandler.writeFile(writeFile, metricsText);
	}
}