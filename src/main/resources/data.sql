INSERT INTO EXPRESSIONS (conversion_type, formula, maximum_value_allowed, minimum_value_allowed, input_unit, output_unit) VALUES ('CELSIUS_TO_FAHRENHEIT', 'input * 9.0 / 5.0 + 32', '0', '-273.15', 'Celsius', 'Fahrenheit');
INSERT INTO EXPRESSIONS (conversion_type, formula, maximum_value_allowed, minimum_value_allowed, input_unit, output_unit) VALUES ('FAHRENHEIT_TO_CELSIUS', '(input - 32) * (5.0 / 9.0)', '0', '-459.67', 'Fahrenheit', 'Celsius');
INSERT INTO EXPRESSIONS (conversion_type, formula, maximum_value_allowed, minimum_value_allowed, input_unit, output_unit) VALUES ('KILOMETERS_TO_MILES', 'input * 0.621371', '0', '0', 'Kilometers', 'Miles');
INSERT INTO EXPRESSIONS (conversion_type, formula, maximum_value_allowed, minimum_value_allowed, input_unit, output_unit) VALUES ('MILES_TO_KILOMETERS', 'input * 1.609344', '0', '0', 'Miles', 'Kilometers');
INSERT INTO EXPRESSIONS (conversion_type, formula, maximum_value_allowed, minimum_value_allowed, input_unit, output_unit) VALUES ('KILOGRAMS_TO_POUNDS', 'input * 2.204622', '0', '0', 'Kilograms', 'Pounds');
INSERT INTO EXPRESSIONS (conversion_type, formula, maximum_value_allowed, minimum_value_allowed, input_unit, output_unit) VALUES ('POUNDS_TO_KILOGRAMS', 'input * 0.453592', '0', '0', 'Pounds', 'Kilograms');

COMMIT;