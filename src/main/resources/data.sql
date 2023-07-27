INSERT INTO EXPRESSIONS (conversion_type, expression) VALUES ('DEGREES_TO_FAHRENHEIT', 'input * 9.0 / 5.0 + 32');
INSERT INTO EXPRESSIONS (conversion_type, expression) VALUES ('FAHRENHEIT_TO_DEGREES', '(input - 32) * (5.0 / 9.0)');
INSERT INTO EXPRESSIONS (conversion_type, expression) VALUES ('KILOMETERS_TO_MILES', 'input * 0.621371');
INSERT INTO EXPRESSIONS (conversion_type, expression) VALUES ('MILES_TO_KILOMETERS', 'input * 1.609344');
INSERT INTO EXPRESSIONS (conversion_type, expression) VALUES ('KILOGRAMS_TO_POUNDS', 'input * 2.204622');
INSERT INTO EXPRESSIONS (conversion_type, expression) VALUES ('POUNDS_TO_KILOGRAMS', 'input * 0.453592');

COMMIT;