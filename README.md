GET localhost:8080/rooms - wyświetlenie planu konferencji
GET localhost:8080/users - wyświetlenie wszystkich użytkowników
POST localhost:8080/users - dodanie nowego użytkownika:
{
    "username": "User_1",
    "email": "Email_1"
}

GET localhost:8080/users/User_1 - wyświetlenie wykładów do jakich użytkownik się zapisał
PUT localhost:8080/users/User_1 - edycja maila
{
    "username": "User_1",
    "email": "NewEmail_1"
}

DELETE localhost:8080/users/User_1 - usunięcie użytkownika
