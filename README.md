# SalaryCalculatorFromCSV
Takes a CSV file and calculation type as arguments from the command line. 
Parses the csv file for relevant employee information and calculates:

all) Employee salaries in dollars.

or 

group) Total salaries grouped by employee roles.

# Running the app: 
Download the technicalAssesmentEvident.jar

Run the following commands in the terminal: 

java -jar technicalAssesmentEvident.jar "csv file" all

or 

java -jar technicalAssesmentEvident.jar "csv file" group

Will need to provide the full path to a CSV file with no quotes.

CSV Schema: Name|Rate|Hours|Role

Works for regular comma separated values as well

Splits values on commas and pipes 


