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
    - [Chat Participants](#chat-participants)
        - [Add Chat Participant](#add-chat-participant)
        - [Get Chat Participants](#get-chat-participants)
        - [Update Chat Participant](#update-chat-participant)
        - [Delete Chat Participant](#delete-chat-participant)
    - [Messages](#messages)
        - [Add Message](#add-message)
        - [Get All Messages](#get-all-messages)
        - [Update Message](#update-message)
        - [Delete Message](#delete-message)
    - [Communities](#communities)
        - [Create Community](#create-community)
        - [Get Community](#get-community)
        - [Update Community](#update-community)
        - [Delete Community](#delete-community)
        - [Update Community Tags](#update-community-tags)


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

| Error Code | Description                       |
|------------|-----------------------------------|
| ERR-0      | Socket Timeout Exception          |
| ERR-1      | Unknown Host Exception            |
| ERR-2      | SSL Exception                     |
| ERR-3      | IO Exception                      |
| ERR-4      | Not Found Exception               |
| ERR-5      | General Exception                 |
| ERR-6      | Unauthorized Exception            |
| ERR-7      | Forbidden Exception               |
| ERR-8      | Participated Exception            |
| ERR-9      | Incorrect Password Pattern        |
| ERR-10     | Field Not Blank                   |
| ERR-11     | Field Not Null                    |
| ERR-12     | Incorrect Email Pattern           |
| ERR-6-30   | Size Exception (6-30 characters)  |
| ERR-1-255  | Size Exception (1-255 characters) |

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

### Delete Chat

**Endpoint**: `DELETE /api/chats/{chatId}`

**Description**: Delete a specific chat by its ID.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat to delete.

**Response**:
- `204 No Content` if the chat is successfully deleted.
- `403 Forbidden` if has no right to delete the chat.
- `404 Not Found` if the chat does not exist.

## Chat Participants

### Add Chat Participant

**Endpoint**: `POST /api/chat/{chatId}/participants`

**Description**: Add a participant to a chat.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat to which the participant will be added.

**Request Body**:
```json
{
  "profileId": "number"
}
```

**Response**:
- `201 Created` with a JSON object representing the added chat participant.
```json
{
  "id": "number",
  "nickname": "string",
  "isMod": "boolean"
}
```
- `400 Bad Request` if the request body is invalid or contains errors.
- `403 Forbidden` if the user does not have permission to add participants.
- `404 Not Found` if the chat or profile does not exist.

### Get Chat Participants

**Endpoint**: `GET /api/chat/{chatId}/participants`

**Description**: Retrieve a list of participants in a chat with optional pagination.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat to which the participant will be added.
- `page` (path parameter): he page number for pagination. Default is `0`.

**Response**:
- `201 Created` with a JSON array of chat participant objects.
```json
[
  {
    "id": "number",
    "nickname": "string",
    "isMod": "boolean"
  }
]
```
- `404 Not Found`  if the chat does not exist.

### Update Chat Participant

**Endpoint**: `PUT /api/chat/{chatId}/participants`

**Description**: Update a chat participant's details.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat containing the participant.

**Request Body**:
```json
{
  "id": "number",
  "isMod": "boolean"
}
```

**Response**:
- `200 OK` with a JSON object representing the updated chat participant.
```json
{
  "id": "number",
  "nickname": "string",
  "isMod": "boolean"
}
```
- `400 Bad Request` if the request body is invalid or contains errors.
- `403 Forbidden` if the user does not have permission to update the participant.
- `404 Not Found` if the chat or participant does not exist.

### Delete Chat Participant

**Endpoint**: `DELETE /api/chat/{chatId}/participants`

**Description**: Remove a participant from a chat.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat from which the participant will be removed.
- `chatParticipantId` (query parameter): The ID of the participant to remove.

**Response**:
- `204 No Content` if the participant is successfully removed.
- `403 Forbidden` if the user does not have permission to remove the participant.
- `404 Not Found` if the chat or participant does not exist.

## Messages

### Add Message

**Endpoint**: `POST /api/chat/{chatId}/messages`

**Description**: Add a new message to a chat.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat to which the message will be added.

**Request Body**:
```json
{
  "text": "string (1-255 characters)",
  "isSent": "boolean"
}
```

**Response**:
- `201 Created` with a JSON object representing the added message.
```json
{
  "senderProfileId": "number",
  "senderName": "string",
  "text": "string",
  "sendDate": "string (ISO 8601 format)",
  "isSent": "boolean"
}
```
- `400 Bad Request` if the request body is invalid or contains errors.
- `403 Forbidden` if the user does not have permission to add messages.
- `404 Not Found` if the chat does not exist.

### Get All Messages

**Endpoint**: `GET /api/chat/{chatId}/messages`

**Description**: Retrieve a list of messages from a chat with optional pagination.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat to which the message will be added.
- `page` (path parameter):  The page number for pagination. Default is `0`.

**Response**:
- `200 OK` with a JSON array of message objects.
```json
[
  {
    "senderProfileId": "number",
    "senderName": "string",
    "text": "string",
    "sendDate": "string (ISO 8601 format)",
    "isSent": "boolean"
  }
]
```
- `403 Forbidden` if the user does not have permission to view the messages.
- `404 Not Found` if the chat does not exist.

### Update Message

**Endpoint**: `PUT /api/chat/{chatId}/messages`

**Description**: Update the details of a message in a chat.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat containing the message to update.

**Request Body**:
```json
{
  "id": "number",
  "text": "string (1-255 characters)"
}
```

**Response**:
- `200 OK` with a JSON object representing the updated message.
```json
{
  "senderProfileId": "number",
  "senderName": "string",
  "text": "string",
  "sendDate": "string (ISO 8601 format)",
  "isSent": "boolean"
}
```
- `400 Bad Request` if the request body is invalid or contains errors.
- `403 Forbidden` if the user does not have permission to update the message.
- `404 Not Found` if the chat or message does not exist.

### Delete Message

**Endpoint**: `DELETE /api/chat/{chatId}/messages`

**Description**: Remove a message from a chat.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat from which the message will be deleted.
- `messageId` (query parameter): The ID of the message to delete.

**Response**:
- `204 No Content` if the message is successfully deleted.
- `403 Forbidden` if the user does not have permission to delete the message.
- `404 Not Found` if the chat or message does not exist.

## Communities

### Create Community

**Endpoint**: `POST /api/communities`

**Description**: Create a new community.

**Request Body**:
```json
{
  "title": "string (6-30 characters)",
  "description": "string (1-255 characters)",
  "gameId": "string"
}
```

**Response**:
- `201 Created` with a JSON object representing the created community.
```json
{
  "id": "number",
  "title": "string",
  "description": "string",
  "game": {
    "id": "string",
    "name": "string",
    "alternativeNames": ["string"],
    "genreIds": ["number"],
    "popularity": "number"
  },
  "tags": ["string"],
  "firstPageMembers": [
    {
      "id": "number",
      "nickname": "string",
      "role": "string"
    }
  ],
  "firstPagePopularPosts": []
}
```
- `400 Bad Request` if the request body is invalid.
- `403 Forbidden` if the user does not have permission to create a community.

### Get Community

**Endpoint**: `GET /api/communities/{communityId}`

**Description**: Retrieve details of a specific community.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community to retrieve.

**Response**:
- `200 OK` with a JSON object representing the community.
```json
{
  "id": "number",
  "title": "string",
  "description": "string",
  "game": {
    "id": "string",
    "name": "string",
    "alternativeNames": ["string"],
    "genreIds": ["number"],
    "popularity": "number"
  },
  "tags": ["string"],
  "firstPageMembers": [
    {
      "id": "number",
      "nickname": "string",
      "role": "string"
    }
  ],
  "firstPagePopularPosts": [
    {
      "id": "string",
      "title": "string",
      "text": "string",
      "tag": "string",
      "clickCount": "number",
      "profile": {
        "id": "string",
        "name": "string"
      },
      "community": {
        "id": "string",
        "title": "string"
      },
      "createdDate": "string (ISO 8601 format)"
    }
  ]
}
```
- `404 Not Found` if the community does not exist.

### Update Community

**Endpoint**: `PUT /api/communities/{communityId}`

**Description**: Update the details of a specific community.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community to update.

**Request Body**:
```json
{
  "title": "string (6-30 characters)",
  "description": "string (1-255 characters)"
}
```

**Response**:
- `200 OK` with a JSON object representing the updated community.
```json
{
  "id": "number",
  "title": "string",
  "description": "string",
  "game": {
    "id": "string",
    "name": "string",
    "alternativeNames": ["string"],
    "genreIds": ["number"],
    "popularity": "number"
  },
  "tags": ["string"],
  "firstPageMembers": [
    {
      "id": "number",
      "nickname": "string",
      "role": "string"
    }
  ],
  "firstPagePopularPosts": [
    {
      "id": "string",
      "title": "string",
      "text": "string",
      "tag": "string",
      "clickCount": "number",
      "profile": {
        "id": "string",
        "name": "string"
      },
      "community": {
        "id": "string",
        "title": "string"
      },
      "createdDate": "string (ISO 8601 format)"
    }
  ]
}
```
- `400 Bad Request` if the request body is invalid.
- `404 Not Found` if the community does not exist.

### Delete Community

**Endpoint**: `DELETE /api/communities/{communityId}`

**Description**: Delete a specific community.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community to delete.

**Response**:
- `204 No Content` if the community is successfully deleted.
- `403 Forbidden` if the user does not have permission to delete the community.
- `404 Not Found` if the community does not exist.

### Update Community Tags

**Endpoint**: `PUT /api/communities/{communityId}/tags`

**Description**: Update the tags associated with a community.

**Request Body**:
```json
{
  "tags": ["string"],
  "remove": "boolean"
}
```

**Response**:
- `200 OK` with a JSON array of updated tags.
```json
["string"]
```
- `400 Bad Reques` if the request body is invalid.
- `403 Forbidden` if the community does not exist.
- `404 Not Found` if the user does not have permission to update the community tags.
