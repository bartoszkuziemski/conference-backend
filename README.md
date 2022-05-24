GET localhost:8080/rooms - wyświetlenie planu konferencji

GET localhost:8080/users - wyświetlenie wszystkich użytkowników wraz z adresami email, dostępne tylko dla organizatora: nazwa:admin, hasło: admin

POST localhost:8080/users - dodanie nowego użytkownika:
{
    "username": "User_1",
    "email": "Email_1"
}

GET localhost:8080/users/User_1 - wyświetlenie wykładów do jakich użytkownik "User_1" się zapisał

PUT localhost:8080/users/User_1 - edycja maila użytkownika "User_1"
{
    "username": "User_1",
    "email": "NewEmail_1"
}

DELETE localhost:8080/users/User_1 - usunięcie użytkownika "User_1"

PUT localhost:8080/users/User_1/lectures/1/register - zarejestrowanie użytkownika "User_1" do wykładu o id = 1

DELETE localhost:8080/users/User_1/lectures/1/register - anulowanie rejestracji użytkownika "User_1" w wykładzie o id = 1



Narzędzia do uruchomienia projektu: IntelliJ IDEA, dodatkowo Postman ( do zapytań usług REST )
