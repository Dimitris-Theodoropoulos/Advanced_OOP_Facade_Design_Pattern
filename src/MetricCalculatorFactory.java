import java.io.File;

public final class MetricCalculatorFactory {

	public static MetricCalculator createMetricCalculator(File javaFile,
			MetricsCalculatorStrategy metricsCalculatorStrategy) {
		if (metricsCalculatorStrategy == MetricsCalculatorStrategy.REGEX_COMPARISON)
			return new MetricCalculatorRegEx(javaFile);
		else if (metricsCalculatorStrategy == MetricsCalculatorStrategy.STRING_COMPARISON)
			return new MetricCalculatorString(javaFile);
		return null;
	}
}