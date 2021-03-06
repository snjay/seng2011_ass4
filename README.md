read me:
lets get to work boiz

***(still under development)***

###Customer Requirements (in order of priority):
	1. Efficiency - Fast Response Time
	2. Correct


###Steps:
	1. Get Flights that which can be taken from '*flightdata-filename*' input file.
	2. Get Query from: '*query-filename*'.
	3. Find flights according to preferences from query
	4. 

###Running:
travelplan flightdata-filename query-filename


## Format

### Flights
![alt text](http://i.imgur.com/TCDGskU.png "Logo Title Text 1")
### Query
![alt text](http://i.imgur.com/DXe8EyX.png "Logo Title Text 1")
### QueryAnswerList
![alt text](http://i.imgur.com/8r2FULa.png "Logo Title Text 1")

##Queries Notes:
 - **NO DIRECT flights** between two cities (In general)
   - e.g. Query: *Sydney->Melb* might be offered as: 
      - *Sydney->Darwin*,
      - *Darwin->Auckland*,
      - *Auckland->Perth*, 
      - *Perth->Melbourne*.
 - **minimum 1 hour transit time.** between arrival and next departure
 

##Quick Notes:
 - **total cost** of the travel plan = the sum of the costs of the individual flights in the sequence.
 - **total duration** = dep. time @ origin -> latest arrival time @ dest. (i.e. arrival - departure)
   - note: **arrival may be on a different day**.
 - **frequent flier value** = total number of hours in the plan that are on flights belonging to airline A.

##Output
Needs to be completely usable from command line using:
 
`travelplan flightdate-filename query-filename`

Results **sorted** so that the customer’s preferred travel plan is listed first, then the next most preferred, etc, up to the number N of flight plans requested by the customer. (Flight plans past position N in the ranking on possible answers are not to be shown.) 
 - **Customer preferences**
   - (minimal) cost
   - (minimal) total travel time 
   - (maximal) frequent flier value (with given airline A)
 - should be sorted using *lexicographic ordering.* (a.k.a dictionary order)
 	- e.g. The words a1a2.....ak will be appearing before the words d1d2....dk in the dictionary.
