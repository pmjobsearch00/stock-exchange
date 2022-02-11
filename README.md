
## Sample Practice

** Requirements **

Question 1:

Below is an extract from two classes used with in a pricing system. The first class ‘InterestPayment’ contains some business logic; 
the second class Payment is a POJO that represents a payment. The specification of business logic in InterestPayment.updatePayment() is 
to update the payment if the date is within 5 days of the existing date and return true if it was updated (otherwise a new payment would be 
created and the existing payment would remain). There is a bug in the updatePayment method. Write a Junit test case to expose the bug.


Question 2:

Below are classes from a program that receive, parse and store messages from European stock exchanges. The program uses JPA, to persist the POJO
objects. The persistence code already exists. Complete the TradeParser.parse method class so the unit tests pass, add any other unit tests you feel 
would be appropriate. The TradeParser.parse() method is passed a message at a time. It shall parse each message returning a Trade object where possible; 
otherwise an exception is to be thrown. Each message consists of a number of fields delimited by a semi-colon. A field is identified by a single character, 
followed by the field value. In this application the code is only interested in three fields from the message.

Field Code Description

I ISIN code, 12 characters


P Trade price, decimal


T Trade number, integer


So the following


iIT0004158397;p123.45;t1

is a message for message for ISIN IT0004158397, price 123.45, type 1;



** Testing **

If you have git installed and configured in the path then use below command to checkout source code into your system,

git clone https://pmjobsearch00@bitbucket.org/pmjobsearch00/iexchange.git

If you have maven installed and in the path then use below command to build and run junit test cases that proves the core functions,

Go to the folder where the code is checked-out (you should see the pom.xml in your current folder)

Two test cases will fail as part of assignment-1 and it is expected, rather the aim of the assignment-1.

mvn clean install

mvn test

** Build **

mvn clean install


