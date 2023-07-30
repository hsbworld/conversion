# Metrics to Imperial Conversion and Vice Versa

## Overview

This Spring Boot application empowers users to seamlessly convert temperatures between different units, enabling metrics to imperial conversion and vice versa. The application is designed to be extensible, allowing the dynamic addition of new conversion types via the database tables.

## Getting Started

### Via Source Code

1. Clone the project from the GitHub repository.
2. Ensure that Java (version 17) and Maven (version 3.8) are installed on your system.
3. Build the project using Maven: `mvn clean install`
4. Run the application using Maven: `mvn spring-boot:run`
5. Access the application at: [http://localhost:8080](http://localhost:8080)

### Via Docker

1. Ensure that Docker is installed on your machine.
2. Pull the Docker container using the command: `docker pull haseebxp/conversion`
3. Run the container using the command: `docker run -p 8080:8080 -d haseebxp/conversion:latest`

## Configuration

The conversion configurations are stored in the database table `EXPRESSIONS`, which includes the following fields:

- `conversion_type`: Specifies the type of temperature conversion.
- `formula`: Stores the formula used for temperature conversion.
- `minimum_value_allowed`: Represents the minimum value allowed for the input temperature. This prevents users from entering invalid values, such as temperatures below absolute zero. To deactivate this constraint, enter the value as 0.
- `maximum_value_allowed`: Represents the maximum value allowed for the input temperature. Although there may not be a specific use case currently, this field is included for future extensibility. To deactivate this constraint, enter the value as 0.
- `input_unit`: Defines the unit of the input temperature.
- `output_unit`: Defines the unit of the output temperature after conversion.

## API Documentation

### URL: `api/convert/{conversion_type}/{value}`

**Parameters**:

- `conversion_type` (String, Required): Specifies the type of conversion to apply, corresponding to the entry in the `EXPRESSIONS` table.
- `value` (String, Required): Represents the value to be converted.

**Example**:

Request: `api/convert/CELSIUS_TO_FAHRENHEIT/15`

Response:
```json
{
  "inputValue": "15",
  "inputUnit": "Celsius",
  "outputValue": "59.0",
  "outputUnit": "Fahrenheit"
}
```

## To Do

- Implement JUnit tests to ensure the application's correctness and robustness.
- Improve the Docker file to eliminate hard coding of the JAR file
