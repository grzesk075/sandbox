package pl.grzesk075.sandbox.systemdesign;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Sensors [value, unit, timestamp].
 * Concentrators [asking sensors, short term accumulation, aggregation e.g. 4 average measurements per hour].
 * DataCenters [wearhouse, dashboards, forecasts, reports, analytics].
 * Pull model (DataCenters ask Concentrators ask Sensors). List of threads sending requests with timeouts.
 * Health Check module to eliminate broken sensors and concentrators.
 * Redundancy.
 */
public class WeatherMeasurementSystem {

    enum Unit {
        PREASURE,
        HUMIDITY,
        TEMPERATURE;
    }

    class Measurement {
        long id;
        long sensorId;
        Unit unit;
        Float value;
        ZonedDateTime zonedDateTime;
    }

    class Sensor {
        List<Measurement> measurements; //size is limited

        List<Measurement> getMeasurements(long lastMeasurementId) {
            return measurements; //newer should be filtered
        }
    }

    class Concentrator {
        List<Sensor> sensors;

        List<Measurement> shortTermMeasurements;

        void getNewerMeasurements() {
            for (Sensor s : sensors) {
                //s.getMeasurements();
            }
        } //runs periodically
    }

    class DataCenter {
        List<Concentrator> concentrators;
        Database db; //relational
        //dashboards, prognosis, analysis, reports, warnings, health check for broken sensors and connections
    }

    class Database {
        List<Measurement> shortTermMeasurements; //higher density of measurements in time
        List<Measurement> longTermMeasurements;
    }
}
