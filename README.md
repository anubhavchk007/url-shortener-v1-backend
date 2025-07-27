## Submission to Url Shortening Service from roadmap.sh
Project Link: https://roadmap.sh/projects/url-shortening-service

# Endpoints:

## 1. Create Short URL:

POST `/shorten`
```
{
    "url": "www.urlthatyouwanttoshorten.com"
}
```
Response:
```
{
    "id": "6885e5dcd4d435f9b3a8609d",
    "shortCode": "9fcZ9l",
    "longURL": "www.urlyouwanttoshorten.com",
    "createdAt": "2025-07-27T14:09:56.4941826",
    "updatedAt": "2025-07-27T14:09:56.4941826"
}
```
## 2. Retrieve Original URL:

GET `/shorten/9fcZ9l`

Response:
```
{
    "id": "6885e5dcd4d435f9b3a8609d",
    "shortCode": "9fcZ9l",
    "longURL": "www.urlyouwanttoshorten.com",
    "createdAt": "2025-07-27T14:09:56.494",
    "updatedAt": "2025-07-27T14:09:56.494"
}
```
## 3. Update Short URL:

PUT `/shorten/9fcZ9l`
```
{
    "url": "www.thisisanupdatedurl.com"
}
```
Response:
```
{
    "id": "6885e5dcd4d435f9b3a8609d",
    "shortCode": "9fcZ9l",
    "longURL": "www.thisisanupdatedurl.com",
    "createdAt": "2025-07-27T14:09:56.494",
    "updatedAt": "2025-07-27T14:21:53.7322957"
}
```

## 4. Delete Short URL:

DELETE `/shorten/9fcZ9l`

Response:
`204 No Content`

## 5. Get URL Statistics:

GET `/shorten/NuoDrN/stats`

Response:
```
{
    "id": "68851ae7d4d435f9b3a8609b",
    "shortCode": "NuoDrN",
    "longURL": "https://www.reddit.com/",
    "createdAt": "2025-07-26T23:43:59.532",
    "updatedAt": "2025-07-26T23:43:59.532",
    "accessCount": 3
}
```




This is my first submission to roadmap.sh please don't be mean :)
