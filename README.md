Rest API calls

http://localhost:8080/auth/login
Method Type = POST

Sample JSON Input
{
	"email": "username@domain.com",
	"password": "secret"
}


http://localhost:8080/user/me
Method Type = GET

Sample JSON Output

{
    "id": 1,
    "name": "YourName",
    "email": "username@domain.com",
    "imageUrl": null,
    "emailVerified": false,
    "provider": "local",
    "providerId": null,
    "roles": [
        {
            "id": 1,
            "name": "ROLE_USER"
        },
        {
            "id": 2,
            "name": "ROLE_ADMIN"
        }
    ]
}


http://localhost:8080/item/{itemid}
Method Type = GET
Authorization Type= Bearer Token

Sample JSON Output

{
    "price": 213,
    "available": "No",
    "image": "table2.jpg",
    "createdBy": "ADMIN",
    "creationDate": "2019-04-13T16:59:49.778+0000",
    "itemName": "Dining Table",
    "itemId": 33
}


http://localhost:8080/items?page={pagenumber}
Method Type = GET
Authorization Type= Bearer Token

Sample JSON Output

{
    "price": 213,
    "available": "No",
    "image": "table2.jpg",
    "createdBy": "ADMIN",
    "creationDate": "2019-04-13T16:59:49.778+0000",
    "itemName": "Dining Table",
    "itemId": 33
}


http://localhost:8080/delete/24
Method Type = DELETE
Authorization Type= Bearer Token

Sample Output

true


http://localhost:8080/add
Method Type = PUT

Sample JSON Input
{
    "itemname": "Big table",
    "price": 888,
    "available": "No",
    "image": "table2.jpg"
}

Sample JSON Output

{
    "itemname": "Big table",
    "price": 888,
    "available": "No",
    "image": "table2.jpg"
}
