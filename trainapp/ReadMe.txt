Book ticket:
POST URL :http://localhost:8080/trainapp/book-ticket

body :

{
    "user" : {
        "firstName" : "Sunil",
        "lastName" : "kulkarni",
        "email" : "sunilk@gmail.com"
    },
    "trainNo" : "12345",
    "trainName" : "Train 1",
    "section" : "Section A",
    "fair"  : 20
}

Get All ticket for train (get)
http://localhost:8080/trainapp/train/{train No}/all-booking

Show Booked ticket get, delete, update
http://localhost:8080/trainapp/ticket/{ticketNo}
