
         The program first reads the enrollees from the CSV file and stores them in a map (enrolleesByInsurance), 
where the key is the insurance company name and enrollees as list of Enrollee objects. Once Map object created.
Extracted keySet and valueSet from Map(enrolleesByInsurance) for further.
KeySet is used for preparing seperat CSV file based company name.
ValueSet used for sorting withing the companies enrollments.
Next step started filtering unique enrollee entires into  LinkedHashMap(uniqueEnrollees), during this process evaluated if any duplicate entry found based on User ID, then considered the enrollee who has highst version number.
Finally started writting this data into CSV files.


Prerrquisets: 
  ==> Need a CSV file with sample data which containsBelow columns and respective sample data
		-> User ID (String)
		-> First And Last Name (String)
		-> Version (INteger)
		-> COmpany Name (String)
  ==> Directory Name where you want store generated csv files 

Excetion:
Below is the command to execute run the jar file.

java -jar D:\Enrollees\EnrolleesByCompany.jar D:\Enrollees\Enrollees.csv D:\Enrollees\EnrolleesByCompany

First argument is jar Name (D:\Enrollees\EnrolleesByCompany.jar) 
Second argument is path of the directory where files will be stored (D:\Enrollees\Enrollees.csv D:\Enrollees\EnrolleesByCompany)

