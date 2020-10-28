package pl.grzesk075.sandbox.systemdesign;

/**
 * Sensors [value, unit, timestamp].
 * Concentrators [asking sensors, short term accumulation, aggregation e.g. 4 average measurements per hour].
 * DataCenters [wearhouse, dashboards, forecasts, reports, analytics].
 * Pull model (DataCenters ask Concentrators ask Sensors). List of threads sending requests with timeouts.
 * Health Check module to eliminate broken sensors and concentrators.
 * Redundancy.
 */
public class WeatherMeasurementSystem {
}
