In ParkingRepo.class noOfSlots integer is set as 5, so while each restart the slots will be created randomly and it will be printed in console.
For the vehicle company and type, we provide with vehicle, a slot should be present. if not then we have change the request body data to the data for which the slot is created.


Exposed apis 
url: http://localhost:8080/park
method: post
request body: 
{
"number":"TN01AP0081",
"type":"car",
"company":"ust"
}

url: http://localhost:8080/leave
method: post
request body: 
{
"number":"TN01AP0081",
"type":"car",
"company":"ust"
}
