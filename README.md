## Database

Student

-id

-first_name

-last_name

-gender

-create_time

-update_time

-isActive

-isDelete

## Api

### /student

GET : 

- http://localhost:8080/student
  - get all student data in the employee table
- http://localhost:8080/student/{id}
  - get employee information based on the studnet id

POST

- http://localhost:8080/employee

Request Body:

```json
{
    "firstName": "Steve",
    "lastName": "Rogers",
    "gender":"0",
}
```

PATCH

- http://localhost:8080/student

Request Body:

"id" is the only required field for this endpoint, PATCH method would update other fields to the database

```json
{
    "id": 3,
    "gender":"1",
    "isActive" : "0"
}
```

DELETE

- http://localhost:8080/student/{id}
  - Delete student by id



