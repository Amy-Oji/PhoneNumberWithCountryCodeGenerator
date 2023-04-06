# PhoneNumberWithCountryCodeGenerator

This project is my [solution](https://github.com/Amy-Oji/PhoneNumberWithCountryCodeGenerator/blob/master/src/main/java/PhoneNumber.java) to a HackerRank Coding challenge.

Here is the description of the task:

Given a country name and a phone number, query the API
at ```https://jsonmock.hackerrank.com/api/countries?name=country``` to get the country's calling
codes. 

Prepend the calling code to the phone
number and return the string. 

If the data array is empty, return the string -1. 

If there are multiple calling codes, use the one at the highest index.

The format of the number should be: Calling Code +  "space" + Phone Number.
**_Example:
+234 8012345678_**

The response from the API call is a JSON object with 5 fields. 

The essential field is data.

data: Either an empty array or an array with a
single object that contains the country's record.

In the data array, the country has the following schema:

name; The name of the country (String),

callingCodes: An array of the country's calling codes (String Array)

A number of fields that are not of interest:
page, per_page, total, total pages, etc. are not
required for this task.

If the country is found, the data array contains exactly 1 element. 

If not, it is empty and the function should return '-1!

If the country name is 'Nigeria', for example, 

query  https;//jsonmock.hackerrank.com/api/countries?name=Nigeria

A portion of the country record for Nigeria looks like this:
```
{ 
    "data": [
        {
            "name": "Nigeria",
            "nativeName": "Nigeria",
            "topLevelDomain": [
            ".ng"
            ],
            "alpha2Code": "NG",
            "numericCode": "566",
            "alpha3Code": "NGA",
            "currencies": [
            "NGN"
            ],
            "callingCodes": [
            "234"
            ],
            "capital": "Abuja"
        }
    ]
}
```


Function Description 
Write a getPhoneNumbers function in the
editor.

getPhoneNumbers should have the following parameters:

* string country: the country to query 
* string phoneNumber: the phone number

Returns
string: the completed phone number or -1

Constraints
The returned JSON object contains either 0 or 1
record in data.

The country name may contain uppercase and
lowercase English letters and <space> (ascii 32)

#### Sample Case
Sample Input For Custom Testing

country: Nigeria

phoneNumber: 8012345678

Sample Output
+234 8012345678

#### Explanation:

A call is made to the API ``` https://jsonmock.hackerrank.com/api/countries?name=Nigeria ```

The calling code for the inputted country is then extracted from the callingCodes array in the API response 

The calling code is then prepended to the phone number and returned.




