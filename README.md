# Gamerum

Gamerum is a Reddit-like application that lets people create communities specifically for games. Users can join, create, and manage game-related communities, share posts, and engage with other gamers. The application leverages data from the IGDB API to provide game information.

## Features
- Create and manage game-specific communities.
- Join and participate in various gaming communities.

## Table of Contents

- [Error Handling](#error-handling)
- [API Endpoints](#api-endpoints)
    - [Authentication](#authentication)
        - [Register](#register)
        - [Login](#login)
    - [Chats](#chats)
        - [Create Chat](#create-chat)
        - [Get Chat](#get-chat)
        - [Get Chats](#get-chats)
        - [Delete Chat](#delete-chat)


## Error Handling

Gamerum uses a global exception handler to manage and respond to errors in a consistent manner. Below is a list of error codes that the API may return:

### List of Error Codes

**Response**: Returns an error code.
```json
{
  "errorCode": "string"
}
```

*--- Error codes are temporary. ---*

| Error Code                | Description                       |
|---------------------------|-----------------------------------|
| ERR-0                     | Socket Timeout Exception          |
| ERR-1                     | Unknown Host Exception            |
| ERR-2                     | SSL Exception                     |
| ERR-3                     | IO Exception                      |
| ERR-4                     | Not Found Exception               |
| ERR-5                     | General Exception                 |
| ERR-6                     | Forbidden Exception               |
| ERR-7                     | Participated Exception            |
| ERR-8                     | Incorrect Password Pattern        |
| ERR-9                     | Field Not Blank                   |
| ERR-10                    | Field Not Null                    |
| ERR-11                    | Incorrect Email Pattern           |
| ERR-6-30                  | Size Exception (6-30 characters)  |
| ERR-1-255                 | Size Exception (1-255 characters) |

When an error occurs, the client will receive a response containing the appropriate error code from the list above.

# API Endpoints

## Authentication

### Register: 

**Endpoint**: `POST /api/auth/register`

**Description**: Register a new user.

**Request Body**:
```json
{
  "username": "string (6-30 characters)",
  "nickname": "string (6-30 characters)",
  "email": "string (valid email format)",
  "password": "string (8-30 characters, alphanumeric and @$!%?&)"
}
```

**Request Body**:
- `201 Created` if registration is successful.
- `400 Bad Request` if validation fails with appropriate error codes.

### Login:

**Endpoint**: `POST /api/auth/login`

**Description**: Login a user and return a JWT token.

**Request Body**:

```json
{
  "username": "string (6-30 characters)",
  "password": "string (8-30 characters, alphanumeric and @$!%?&)"
}
```

**Response**:

- `200 OK` with a JSON object containing the JWT token.
```json
{
  "token_type": "Bearer",
  "token": "string"
}
```
- `400 Bad Request` if validation fails with appropriate error codes.
- `401 Unauthorized` if authentication fails.

## Chats

### Create Chat

**Endpoint**: `POST /api/chats`

**Description**: Create a new chat.

**Request Body**:
```json
{
  "participantProfileIds": [
    "number"
  ]
}
```
**Notes**: The list of participantProfileIds should not include the ID of the chat creator.

**Response**:

- `201 Created` with a JSON object representing the created chat.
```json
{
  "id": "number",
  "firstPageParticipants": [
    {
      "id": "number",
      "nickname": "string",
      "isMod": "boolean"
    }
  ],
  "firstPageMessages": [
    {
      "senderProfileId": "number",
      "senderName": "string",
      "text": "string",
      "sendDate": "string (ISO 8601 format)",
      "isSent": "boolean"
    }
  ]
}
```
- `400 Bad Request` if the request body is invalid or contains errors.
- `401 Unauthorized` if not logged in yet or could not send the JWT token.
- `404 Not Found` if the requester has no profile.

### Get Chat

**Endpoint**: `GET /api/chats/{chatId}`

**Description**: Retrieve a specific chat by its ID.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat to retrieve.

**Response**:

- `200 OK` with a JSON object representing the chat.
```json
{
  "id": "number",
  "firstPageParticipants": [
    {
      "id": "number",
      "nickname": "string",
      "isMod": "boolean"
    }
  ],
  "firstPageMessages": [
    {
      "senderProfileId": "number",
      "senderName": "string",
      "text": "string",
      "sendDate": "string (ISO 8601 format)",
      "isSent": "boolean"
    }
  ]
}
```
- `401 Unauthorized` if not logged in yet or could not send the JWT token.
- `403 Forbidden` if not a participant of the chat
- `404 Not Found` if the chat does not exist.

### Get Chats

**Endpoint**: `GET /api/chats`

**Description**: Retrieve a list of chats with optional pagination.

**Request Parameters**:
- `page` (query  parameter): The page number for pagination. Default is `0`.
- `profileId` (query  parameter):  The ID of the profile whose chats to retrieve. Default is `0`.

**Response**:

- `200 OK` with a JSON array of chat objects.
```json
[
  {
    "id": "number",
    "firstPageParticipants": [
      {
        "id": "number",
        "nickname": "string",
        "isMod": "boolean"
      }
    ],
    "firstPageMessages": [
      {
        "senderProfileId": "number",
        "senderName": "string",
        "text": "string",
        "sendDate": "string (ISO 8601 format)",
        "isSent": "boolean"
      }
    ]
  }
]
```
- `400 Bad Request` if query parameters are invalid.

