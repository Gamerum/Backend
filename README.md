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
    - [Community Members](#community-member)
        - [Add Community Member](#add-community-member)
        - [Get Community Member](#get-community-members)
        - [Update Community Member](#update-community-member)
        - [Delete Community Member](#delete-community-member)
    - [Posts](#posts)
        - [Create Post](#create-post)
        - [Get Post](#get-post)
        - [Update Post](#update-post)
        - [Delete Post](#delete-post)
    - [Comments](#comments)
        - [Add Comment](#add-comment)
        - [Get Comments](#get-comments)
        - [Update Comment](#update-comment)
        - [Delete Comment](#delete-comment)
    - [Replies](#replies)
        - [Add Reply](#add-reply)
        - [Get Replies](#get-replies)
        - [Update Reply](#update-reply)
        - [Delete Reply](#delete-reply)
    - [Profiles](#profiles)
        - [Get Profile](#get-profile)
        - [Update Profile](#update-profile)
        - [Get Profile Communities](#get-profile-communities)
        - [Get Profile Posts](#get-profile-posts)
    - [User](#user)
        - [Change Email](#change-email)
        - [Change Password](#change-password)
    - [Popular](#popular)
        - [Get Popular Communities](#get-popular-communities)
        - [Get Popular Posts](#get-popular-posts)
        - [Get Community Popular Posts](#get-community-popular-posts)
        - [Get Popular Games](#get-popular-games)
    


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
| ERR-8      | Already Participated Exception    |
| ERR-9      | Not Participated Exception        |
| ERR-10     | Incorrect Password Pattern        |
| ERR-11     | Field Not Blank                   |
| ERR-12     | Field Not Null                    |
| ERR-13     | Incorrect Email Pattern           |
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to add participants.
- `404 Not Found` if the chat or profile does not exist.
- `409 Conflict` if the user is already a participant of the chat.

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
- `401 Unauthorized` if not logged in or could not send the JWT token.
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to update the community.
- `404 Not Found` if the community does not exist.

### Delete Community

**Endpoint**: `DELETE /api/communities/{communityId}`

**Description**: Delete a specific community.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community to delete.

**Response**:
- `204 No Content` if the community is successfully deleted.
- `401 Unauthorized` if not logged in or could not send the JWT token.
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the community does not exist.
- `404 Not Found` if the user does not have permission to update the community tags.

## Community Member

### Add Community Member

**Endpoint**: `POST /api/communities/{communityId}/members`

**Description**: Add a new member to a community.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community to add the member to.

**Request Body**:
```json
{
  "profileId": "number"
}
```

**Response**:
- `201 Created` with a JSON object representing the created community member.
```json
{
  "id": "number",
  "nickname": "string",
  "role": "string"
}
```
- `400 Bad Request` if the request body is invalid.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to add a member to the community.
- `404 Not Found` if the community or profile does not exist.
- `409 Conflict` if the user is already a member of the community.

### Get Community Members

**Endpoint**: `GET /api/communities/{communityId}/members`

**Description**: Retrieve a list of members for a specific community.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community.
- `page` (query parameter): The page number for pagination.

**Response**:
- `200 OK` with a JSON array of community member objects.
```json
[
  {
    "id": "number",
    "nickname": "string",
    "role": "string"
  }
]
```
- `404 Not Found` if the community does not exist.

### Update Community Member

**Endpoint**: `PUT /api/communities/{communityId}/members`

**Description**: Update the role of a community member.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community.
- `profileId` (query parameter): The ID of the member's profile.

**Request Body**:
```json
{
  "role": "number"
}
```

**Response**:
- `200 OK` with a JSON object representing the updated community member.
```json
{
  "id": "number",
  "nickname": "string",
  "role": "string"
}
```
- `400 Bad Request` if the request body is invalid.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to update the member's role.
- `404 Not Found` if the community member does not exist.


### Delete Community Member

**Endpoint**: `DELETE /api/communities/{communityId}/members`

**Description**: Remove a member from a community.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community.
- `profileId` (query parameter): The ID of the profile to remove.

**Response**:
- `204 No Content` if the member is successfully removed.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to delete the member.
- `404 Not Found` if the community or member does not exist.

## Posts

### Create Post

**Endpoint**: `POST /api/communities/{communityId}/posts`

**Description**: Create a new post in a specified community.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community where the post will be created.

**Request Body**:
```json
{
  "title": "string (6-30 characters)",
  "tag": "string",
  "text": "string (1-255 characters)"
}
```

**Response**:
- `201 Created` with a JSON object representing the created post.
```json
{
  "id": "number",
  "title": "string",
  "tag": "string",
  "text": "string",
  "writerId": "string",
  "writerNickname": "string",
  "createdDate": "string (ISO 8601 format)",
  "lastModifiedDate": "string (ISO 8601 format)",
  "communityId": "number",
  "communityName": "string",
  "firstPageComments": []
}
```
- `400 Bad Request` if the request body is invalid.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to create a post in the community.
- `404 Not Found` if the community does not exist.

### Get Post

**Endpoint**: `GET /api/communities/{communityId}/posts/{postId}`

**Description**: Retrieve a specific post by its ID.

**Request Parameters**:
- `postId` (path parameter): The ID of the post to retrieve.

**Response**:
- `200 OK` with a JSON object representing the post.
```json
{
  "id": "number",
  "title": "string",
  "tag": "string",
  "text": "string",
  "writerId": "string",
  "writerNickname": "string",
  "createdDate": "string (ISO 8601 format)",
  "lastModifiedDate": "string (ISO 8601 format)",
  "communityId": "number",
  "communityName": "string",
  "firstPageComments": [
    {
      "id": "number",
      "text": "string",
      "writerId": "number",
      "writerNickname": "string",
      "createdDate": "string (ISO 8601 format)",
      "lastModifiedDate": "string (ISO 8601 format)"
    }
  ]
}
```
- `404 Not Found`  if the post does not exist.

### Update Post

**Endpoint**: `PUT /api/communities/{communityId}/posts`

**Description**: Update an existing post.

**Request Parameters**:
- `postId` (query parameter): The ID of the post to be updated.

**Request Body**:
```json
{
  "title": "string (6-30 characters)",
  "tag": "string",
  "text": "string (1-255 characters)"
}
```

**Response**:
- `200 OK` with a JSON object representing the updated post.
```json
{
  "id": "number",
  "title": "string",
  "tag": "string",
  "text": "string",
  "writerId": "string",
  "writerNickname": "string",
  "createdDate": "string (ISO 8601 format)",
  "lastModifiedDate": "string (ISO 8601 format)",
  "communityId": "number",
  "communityName": "string",
  "firstPageComments": [
    {
      "id": "number",
      "text": "string",
      "writerId": "number",
      "writerNickname": "string",
      "createdDate": "string (ISO 8601 format)",
      "lastModifiedDate": "string (ISO 8601 format)"
    }
  ]
}
```
- `400 Bad Request` if the request body is invalid.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to update the post.
- `404 Not Found`  if the post does not exist.

### Delete Post

**Endpoint**: `DELETE /api/communities/{communityId}/posts`

**Description**: Delete an existing post.

**Request Parameters**:
- `postId` (query parameter): The ID of the post to be deleted.

**Response**:
- `204 No Content` if the post is successfully deleted.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to delete the post.
- `404 Not Found` if the post does not exist.

## Comments

### Add Comment

**Endpoint**: `POST /api/posts/{postId}/comments`

**Description**: Create a new comment on a specific post.

**Request Parameters**:
- `postId` (path parameter): The ID of the post to which the comment will be added.

**Request Body**:
```json
{
  "text": "string (1-255 characters)"
}
```

**Response**:
- `201 Created` with a JSON object representing the created comment.
```json
{
  "id": "number",
  "text": "string",
  "writerId": "number",
  "writerNickname": "string",
  "createdDate": "string (ISO 8601 format)",
  "lastModifiedDate": "string (ISO 8601 format)"
}
```
- `400 Bad Request` if the request body is invalid.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to comment.
- `404 Not Found` if the post does not exist or the user is not part of the community.

### Get Comments

**Endpoint**: `GET /api/posts/{postId}/comments`

**Description**: Retrieve a list of comments for a specific post.

**Request Parameters**:
- `postId` (path parameter): The ID of the post.
- `page` (query parameter, optional): The page number for pagination. The default is `0`.

**Response**:
- `200 OK` with a JSON array of comments.
```json
[
  {
    "id": "number",
    "text": "string",
    "writerId": "number",
    "writerNickname": "string",
    "createdDate": "string (ISO 8601 format)",
    "lastModifiedDate": "string (ISO 8601 format)"
  }
]
```
- `404 Not Found` if the post does not exist.

### Update Comment

**Endpoint**: `PUT /api/posts/{postId}/comments`

**Description**: Update an existing comment.

**Request Parameters**:
- `commentId` (query parameter): The ID of the comment to be updated.

**Request Body**:
```json
{
  "text": "string (1-255 characters)"
}
```
**Response**:
- `200 OK` with a JSON object representing the updated comment.
```json
{
  "id": "number",
  "text": "string",
  "writerId": "number",
  "writerNickname": "string",
  "createdDate": "string (ISO 8601 format)",
  "lastModifiedDate": "string (ISO 8601 format)"
}
```
- `400 Bad Request` if the request body is invalid.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to update the comment.
- `404 Not Found` if the comment does not exist.

### Delete Comment

**Endpoint**: `DELETE /api/posts/{postId}/comments`

**Description**: Delete an existing comment.

**Request Parameters**:
- `commentId` (query parameter): The ID of the comment to be deleted.

**Response**:
- `204 No Content` if the comment is successfully deleted.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to delete the comment.
- `404 Not Found` if the comment does not exist.

## Replies

### Add Reply

**Endpoint**: `POST /api/comments/{commentId}/reply`

**Description**: Create a new reply to a specific comment.

**Request Parameters**:
- `commentId` (path parameter): The ID of the comment to which the reply will be added.

**Request Body**:
```json
{
  "text": "string (1-255 characters)"
}
```

**Response**:
- `201 Created` with a JSON object representing the created reply.
```json
{
  "id": "number",
  "text": "string",
  "commentId": "number",
  "writerId": "number",
  "writerNickname": "string",
  "createdDate": "string (ISO 8601 format)",
  "lastModifiedDate": "string (ISO 8601 format)"
}
```
- `400 Bad Request` if the request body is invalid.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to reply.
- `404 Not Found` if the comment does not exist.

### Get Replies

**Endpoint**: `GET /api/comments/{commentId}/reply`

**Description**: Retrieve a list of replies for a specific comment.

**Request Parameters**:
- `commentId` (path parameter): The ID of the comment.
- `page` (query parameter, optional): The page number for pagination (default is 0).

**Response**:
- `200 OK` with a JSON array of replies.
```json
[
  {
    "id": "number",
    "text": "string",
    "commentId": "number",
    "writerId": "number",
    "writerNickname": "string",
    "createdDate": "string (ISO 8601 format)",
    "lastModifiedDate": "string (ISO 8601 format)"
  }
]
```
- `404 Not Found` if the comment does not exist.

### Update Reply

**Endpoint**: `PUT /api/comments/{commentId}/reply`

**Description**: Update an existing reply.

**Request Parameters**:
- `replyId` (query parameter): The ID of the reply.

**Request Body**:
```json
{
  "text": "string (1-255 characters)"
}
```

**Response**:
- `200 OK` with a JSON object representing the updated reply.
```json
{
  "id": "number",
  "text": "string",
  "commentId": "number",
  "writerId": "number",
  "writerNickname": "string",
  "createdDate": "string (ISO 8601 format)",
  "lastModifiedDate": "string (ISO 8601 format)"
}
```
- `400 Bad Request` if the request body is invalid.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to update the reply.
- `404 Not Found` if the reply does not exist.

### Delete Reply

**Endpoint**: `DELETE /api/comments/{commentId}/reply`

**Description**: Delete an existing reply.

**Request Parameters**:
- `replyId` (query parameter): The ID of the reply to be deleted.

**Response**:
- `204 No Content` if the reply is successfully deleted.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to delete the reply.
- `404 Not Found` if the reply does not exist.

## Profiles

### Get Profile

**Endpoint**: `GET /api/profiles/{profileId}`

**Description**: Retrieve profile details by ID.

**Request Parameters**:
- `profileId` (path parameter): The ID of the profile to be retrieved.

**Response**:
- `200 OK` with a JSON object representing the profile.
```json
{
  "id": "number",
  "nickname": "string",
  "firstPageCommunities": [
    {
      "id": "string",
      "title": "string",
      "description": "string",
      "memberCount": "number",
      "clickCount": "number",
      "game": {
        "id": "string",
        "name": "string"
      }
    }
  ],
  "firstPagePosts": [
    {
      "id": "string",
      "title": "string",
      "text": "string",
      "tag": "string",
      "clickCount": "number",
      "profile": {
        "id": "string",
        "nickname": "string"
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
- `404 Not Found` if the comment does not exist.

### Update Profile

**Endpoint**: `PUT /api/profiles/{profileId}`

**Description**: Update the profile.

**Request Parameters**:
- `profileId` (path parameter): The ID of the profile to be updated.

**Request Body**:
```json
{
  "nickname": "string (6-30 characters)"
}
```
**Response**:
- `200 OK` with a JSON object representing the updated profile.
```json
{
  "id": "number",
  "nickname": "string",
  "firstPageCommunities": [
    {
      "id": "string",
      "title": "string",
      "description": "string",
      "memberCount": "number",
      "clickCount": "number",
      "game": {
        "id": "string",
        "name": "string"
      }
    }
  ],
  "firstPagePosts": [
    {
      "id": "string",
      "title": "string",
      "text": "string",
      "tag": "string",
      "clickCount": "number",
      "profile": {
        "id": "string",
        "nickname": "string"
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
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to update the profile.
- `404 Not Found` if the profile does not exist.

### Get Profile Communities

**Endpoint**: `GET /api/profiles/{profileId}/communities`

**Description**: Retrieve a list of communities associated with the profile.

**Request Parameters**:
- `profileId` (path parameter): The ID of the profile.
- `page` (query parameter, optional): The page number for pagination. The default is `0`.

**Response**:
- `200 OK` with a JSON array of community documents.
```json
[
  {
    "id": "string",
    "title": "string",
    "description": "string",
    "memberCount": "number",
    "clickCount": "number",
    "game": {
      "id": "string",
      "name": "string"
    }
  }
]
```
- `404 Not Found` if the profile does not exist.

### Get Profile Posts

**Endpoint**: `GET /api/profiles/{profileId}/posts`

**Description**: Retrieve a list of posts created by the profile.

**Request Parameters**:
- `profileId` (path parameter): The ID of the profile.
- `page` (query parameter, optional): The page number for pagination. The default is `0`.

**Response**:
- `200 OK` with a JSON array of post documents.
```json
[
  {
    "id": "string",
    "title": "string",
    "text": "string",
    "tag": "string",
    "clickCount": "number",
    "profile": {
      "id": "string",
      "nickname": "string"
    },
    "community": {
      "id": "string",
      "title": "string"
    },
    "createdDate": "string (ISO 8601 format)"
  }
]
```
- `404 Not Found` if the profile does not exist.

## User

### Change Email

**Endpoint**: `PUT /api/user/{userId}/change_email`

**Description**: Change the email address of a user.

**Request Parameters**:
- `userId` (path parameter): The ID of the user whose email is to be changed.

**Request Body**:
```json
{
  "newEmail": "string (valid email address)"
}
```

**Response**:
- `200 OK` with a JSON string representing the new email.
```json
  "newEmail@example.com"
```
- `400 Bad Request` if the request body is invalid.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to change the email.
- `404 Not Found`  if the user does not exist.

### Change Password

**Endpoint**: `PUT /api/user/{userId}/change_password`

**Description**: Change the password of a user.

**Request Parameters**:
- `userId` (path parameter): The ID of the user whose password is to be changed.

**Request Body**:
```json
{
  "currentPassword": "string (8-30 characters, alphanumeric and @$!%?&)",
  "newPassword": "string (8-30 characters, alphanumeric and @$!%?&)"
}
```

**Response**:
- `200 OK` if the password is successfully changed.
- `400 Bad Request`  if the request body is invalid.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to change the password.
- `404 Not Found`  if the user does not exist.

## Popular

### Get Popular Communities

**Endpoint**: `GET /api/popular/communities`

**Description**: Retrieve a list of the most popular communities based on click count.

**Response**:
- `200 OK` with a JSON array of popular communities.
```json
[
  {
    "id": "string",
    "title": "string",
    "description": "string",
    "memberCount": "number",
    "clickCount": "number",
    "game": {
      "id": "string",
      "name": "string",
      "alternativeNames": [
        "string"
      ],
      "genreIds": [
        "number"
      ],
      "popularity": "number"
    }
  }
]
```

### Get Popular Posts

**Endpoint**: `GET /api/popular/posts`

**Description**: Retrieve a list of the most popular posts based on click count and creation date.

**Request Parameters**:
- `page` (query parameter, optional): The page number for pagination. The default is `0`.

**Response**:
- `200 OK`  with a JSON array of popular posts.
```json
[
  {
    "id": "string",
    "title": "string",
    "text": "string",
    "tag": "string",
    "clickCount": "number",
    "profile": {
      "id": "string",
      "nickname": "string"
    },
    "community": {
      "id": "string",
      "title": "string",
      "description": "string",
      "memberCount": "number",
      "clickCount": "number",
      "game": {
        "id": "string",
        "name": "string",
        "alternativeNames": [
          "string"
        ],
        "genreIds": [
          "number"
        ],
        "popularity": "number"
      }
    },
    "createdDate": "string (ISO 8601 format)"
  }
]
```

### Get Community Popular Posts

**Endpoint**: `GET /api/popular/communities/{communityId}/posts`

**Description**: Retrieve a list of the most popular posts within a specific community based on click count and creation date.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community.
- `page` (query parameter, optional): The page number for pagination. The default is `0`.

**Response**:
- `200 OK` with a JSON array of popular posts within the specified community.
```json
[
  {
    "id": "string",
    "title": "string",
    "text": "string",
    "tag": "string",
    "clickCount": "number",
    "profile": {
      "id": "string",
      "nickname": "string"
    },
    "community": {
      "id": "string",
      "title": "string",
      "description": "string",
      "memberCount": "number",
      "clickCount": "number",
      "game": {
        "id": "string",
        "name": "string",
        "alternativeNames": [
          "string"
        ],
        "genreIds": [
          "number"
        ],
        "popularity": "number"
      }
    },
    "createdDate": "string (ISO 8601 format)"
  }
]
```
### Get Popular Games

**Endpoint**: `GET /api/popular/games`

**Description**: Retrieve a list of the most popular games based on popularity.

**Response**:
- `200 OK` with a JSON array of popular games.
```json
[
  {
    "id": "string",
    "name": "string",
    "alternativeNames": [
      "string"
    ],
    "genreIds": [
      "number"
    ],
    "popularity": "number"
  }
]
```

## Search

### Search Games

**Endpoint**: `POST /api/search/games`

**Description**: Search for games based on name, alternative names, and genre IDs.

**Request Body**:
```json
{
  "keyword": "string (search keyword for game names and alternative names)",
  "page": "integer (page number for pagination)",
  "size": "integer (number of results per page)",
  "genreIds": [
    "integer (list of genre IDs to filter games)"
  ]
}
```

**Response**:
- `200 OK` with a JSON array of game documents.
```json
[
  {
    "id": "string",
    "name": "string",
    "alternativeNames": [
      "string"
    ],
    "genreIds": [
      "integer"
    ],
    "popularity": "number"
  }
]
```

### Search Communities

**Endpoint**: `POST /api/search/communities`

**Description**: Search for communities based on title and associated game ID.

**Request Body**:
```json
{
  "keyword": "string (search keyword for community titles)",
  "page": "integer (page number for pagination)",
  "size": "integer (number of results per page)",
  "gameId": "string (optional game ID to filter communities)"
}
```

**Response**:
- `200 OK` with a JSON array of community documents.
```json
[
  {
    "id": "string",
    "title": "string",
    "description": "string",
    "memberCount": "number",
    "clickCount": "number",
    "game": {
      "id": "string",
      "name": "string",
      "alternativeNames": [
        "string"
      ],
      "genreIds": [
        "integer"
      ],
      "popularity": "number"
    }
  }
]
```

### Search Profiles

**Endpoint**: `POST /api/search/profiles`

**Description**: Search for user profiles based on nickname.

**Request Body**:
```json
{
  "keyword": "string (search keyword for profile nicknames)",
  "page": "integer (page number for pagination)",
  "size": "integer (number of results per page)"
}
```

**Response**:
- `200 OK` with a JSON array of profile documents.
```json
[
  {
    "id": "string",
    "nickname": "string",
    "communityIds": [
      "string"
    ]
  }
]
```

### Search Posts

**Endpoint**: `POST /api/search/posts`

**Description**: Search for posts based on title, community ID, and tag.

**Request Body**:
```json
{
  "keyword": "string (search keyword for post titles)",
  "page": "integer (page number for pagination)",
  "size": "integer (number of results per page)",
  "communityId": "string (optional community ID to filter posts)",
  "tag": "string (optional tag to filter posts)"
}
```

**Response**:
- `200 OK` with a JSON array of post documents.
```json
[
  {
    "id": "string",
    "title": "string",
    "text": "string",
    "tag": "string",
    "clickCount": "number",
    "profile": {
      "id": "string",
      "nickname": "string"
    },
    "community": {
      "id": "string",
      "title": "string",
      "description": "string",
      "memberCount": "number",
      "clickCount": "number",
      "game": {
        "id": "string",
        "name": "string",
        "alternativeNames": [
          "string"
        ],
        "genreIds": [
          "integer"
        ],
        "popularity": "number"
      }
    },
    "createdDate": "string (ISO 8601 format)"
  }
]
```