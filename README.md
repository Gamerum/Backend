# Gamerum

Gamerum is a Reddit-like application that lets people create communities specifically for games. Users can join, create, and manage game-related communities, share posts, and engage with other gamers. The application leverages data from the IGDB API to provide game information.

## Features
- Create and manage game-specific communities.
- Join and participate in various gaming communities.

## Table of Contents

- [Error Handling](#error-handling)
- [API Endpoints](#api-endpoints)
    - **Authentication**
        - [Register](#register)
        - [Login](#login)
    - **Chats**
        - [Create Chat](#create-chat)
        - [Get Chat](#get-chat)
        - [Get Chats](#get-chats)
        - [Delete Chat](#delete-chat)
    - **Chat Participants**
        - [Add Chat Participant](#add-chat-participant)
        - [Get Chat Participants](#get-chat-participants)
        - [Update Chat Participant](#update-chat-participant)
        - [Delete Chat Participant](#delete-chat-participant)
    - **Messages**
        - [Add Message](#add-message)
        - [Get All Messages](#get-all-messages)
        - [Update Message](#update-message)
        - [Delete Message](#delete-message)
    - **Communities**
        - [Create Community](#create-community)
        - [Get Community](#get-community)
        - [Update Community](#update-community)
        - [Delete Community](#delete-community)
        - [Update Community Tags](#update-community-tags)
    - **Community Members**
        - [Add Community Member](#add-community-member)
        - [Get Community Member](#get-community-members)
        - [Update Community Member](#update-community-member)
        - [Delete Community Member](#delete-community-member)
    - **Posts**
        - [Create Post](#create-post)
        - [Get Post](#get-post)
        - [Update Post](#update-post)
        - [Delete Post](#delete-post)
    - **Comments**
        - [Add Comment](#add-comment)
        - [Get Comments](#get-comments)
        - [Update Comment](#update-comment)
        - [Delete Comment](#delete-comment)
    - **Replies**
        - [Add Reply](#add-reply)
        - [Get Replies](#get-replies)
        - [Update Reply](#update-reply)
        - [Delete Reply](#delete-reply)
    - **Profiles**
        - [Get Profile](#get-profile)
        - [Update Profile](#update-profile)
        - [Get Profile Communities](#get-profile-communities)
        - [Get Profile Posts](#get-profile-posts)
    - **User**
        - [Change Email](#change-email)
        - [Change Password](#change-password)
    - **Popular**
        - [Get Popular Communities](#get-popular-communities)
        - [Get Popular Posts](#get-popular-posts)
        - [Get Community Popular Posts](#get-community-popular-posts)
        - [Get Popular Games](#get-popular-games)
    - **Search**
        - [Search Games](#search-games)
        - [Search Communities](#search-communities)
        - [Search Profiles](#search-profiles)
        - [Search Posts](#search-posts)
    - **Like**
        - [Like Post](#like-post)
        - [Like Comment](#like-comment)
        - [Like Reply](#like-reply)
    - **Returned JSONs**
        - **Authentication**
            - [LoginRequestDTO](#LoginRequestDTO)
            - [RegisterRequestDTO](#registerrequestdto)
        - **Profile**
            - [ProfileGetDTO](#profilegetdto)
            - [ProfileUpdateDTO](#profileupdatedto)
        - **Community**
            - [CommunityCreateDTO](#communitycreatedto)
            - [CommunityGetDTO](#communitygetdto)
            - [CommunityUpdateDTO](#communityupdatedto)
            - [CommunitySearchFilter](#communitysearchfilter)
        - **Post**
            - [PostCreateDTO](#postcreatedto)
            - [PostGetDTO](#postgetdto)
            - [PostUpdateDTO](#postupdatedto)
            - [PostSearchFilter](#postsearchfilter)
        - **Comment**
            - [CommentCreateDTO](#commentcreatedto)
            - [CommentGetDTO](#commentgetdto)
            - [CommentUpdateDTO](#commentupdatedto)
        - **Reply**
            - [ReplyCreateDTO](#replycreatedto)
            - [ReplyGetDTO](#replygetdto)
            - [ReplyUpdateDTO](#replyupdatedto)
        - **Chat**
            - [ChatCreateDTO](#chatcreatedto)
            - [ChatGetDTO](#chatgetdto)
        - **Message**
            - [MessageCreateDTO](#messagecreatedto)
            - [MessageGetDTO](#messagegetdto)
        - **Chat Participant**
            - [ChatParticipantCreateDTO](#chatparticipantcreatedto)
            - [ChatParticipantGetDTO](#chatparticipantgetdto)
            - [ChatParticipantUpdateDTO](#chatparticipantupdatedto)
        - **Community Member**
            - [CommunityMemberCreateDTO](#communitymembercreatedto)
            - [CommunityMemberGetDTO](#communitymembergetdto)
            - [CommunityMemberUpdateDTO](#communitymemberupdatedto)
        - **Search Filters**
            - [SearchFilter](#searchfilter)
            - [CommunitySearchFilter](#communitysearchfilter)
            - [GameSearchFilter](#gamesearchfilter)
            - [PostSearchFilter](#postsearchfilter)
        - **Documents**
            - [CommunityDocument](#communitydocument)
            - [GameDocument](#gamedocument)
            - [PostDocument](#postdocument)
            - [ProfileDocument](#profiledocument)


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

**Request Body**: [RegisterRequestDTO](#registerrequestdto)

**Response**:
- `201 Created` if registration is successful.
- `400 Bad Request` if validation fails with appropriate error codes.

### Login:

**Endpoint**: `POST /api/auth/login`

**Description**: Login a user and return a JWT token.

**Request Body**:

**Request Body**: [LoginRequestDTO](#loginrequestdto)

**Response**:

- `200 OK` with a JSON object containing the JWT token:
    - `token_type`: `Bearer`
    - `token`: `string`


- `400 Bad Request` if validation fails with appropriate error codes.
- `401 Unauthorized` if authentication fails.

## Chats

### Create Chat

**Endpoint**: `POST /api/chats`

**Description**: Create a new chat.

**Request Body**: [ChatCreateDTO](#chatcreatedto)

**Notes**: The list of `participantProfileIds` should not include the ID of the chat creator.

**Response**:

- `201 Created` with a JSON object representing the created chat: [ChatGetDTO](#chatgetdto)
- `400 Bad Request` if the request body is invalid or contains errors.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `404 Not Found` if the requester has no profile.

### Get Chat

**Endpoint**: `GET /api/chats/{chatId}`

**Description**: Retrieve a specific chat by its ID.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat to retrieve.

**Response**:

- `200 OK` with a JSON object representing the chat: [ChatGetDTO](#chatgetdto)
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if not a participant of the chat.
- `404 Not Found` if the chat does not exist.

### Get Chats

**Endpoint**: `GET /api/chats`

**Description**: Retrieve a list of chats with optional pagination.

**Request Parameters**:
- `page` (query  parameter): The page number for pagination. Default is `0`.
- `profileId` (query  parameter):  The ID of the profile whose chats to retrieve. Default is `0`.

**Response**:

- `200 OK` with a JSON array of chat objects: [[ChatGetDTO](#chatgetdto)]
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

**Request Body**: [ChatParticipantCreateDTO](#chatparticipantcreatedto)

**Response**:
- `201 Created` with a JSON object representing the added chat participant: [ChatParticipantGetDTO](#chatparticipantgetdto)


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
- `201 Created` with a JSON array of chat participant objects: [[ChatParticipantGetDTO](#chatparticipantgetdto)]
- `404 Not Found`  if the chat does not exist.

### Update Chat Participant

**Endpoint**: `PUT /api/chat/{chatId}/participants`

**Description**: Update a chat participant's details.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat containing the participant.

**Request Body**: [ChatParticipantUpdateDTO](#chatparticipantupdatedto)

**Response**:
- `200 OK` with a JSON object representing the updated chat participant: [ChatParticipantGetDTO](#chatparticipantgetdto)
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

**Request Body**: [MessageCreateDTO](#messagecreatedto)

**Response**:
- `201 Created` with a JSON object representing the added message: [MessageGetDTO](#messagegetdto)
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
- `200 OK` with a JSON array of message objects: [[MessageGetDTO](#messagegetdto)]
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to view the messages.
- `404 Not Found` if the chat does not exist.

### Update Message

**Endpoint**: `PUT /api/chat/{chatId}/messages`

**Description**: Update the details of a message in a chat.

**Request Parameters**:
- `chatId` (path parameter): The ID of the chat containing the message to update.

**Request Body**: [MessageUpdateDTO](#messageupdatedto)

**Response**:
- `200 OK` with a JSON object representing the updated message: [MessageGetDTO](#messagegetdto)
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

**Request Body**: [CommunityCreateDTO](#communitycreatedto)

**Response**:
- `201 Created` with a JSON object representing the created community: [CommunityGetDTO](#communitygetdto)
- `400 Bad Request` if the request body is invalid.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to create a community.

### Get Community

**Endpoint**: `GET /api/communities/{communityId}`

**Description**: Retrieve details of a specific community.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community to retrieve.

**Response**:
- `200 OK` with a JSON object representing the community: [CommunityGetDTO](#communitygetdto)
- `404 Not Found` if the community does not exist.

### Update Community

**Endpoint**: `PUT /api/communities/{communityId}`

**Description**: Update the details of a specific community.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community to update.

**Request Body**: [CommunityUpdateDTO](#communityupdatedto)

**Response**:
- `200 OK` with a JSON object representing the updated community: [CommunityGetDTO](#communitygetdto)
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

**Endpoint**: `PATCH /api/communities/{communityId}/tags`

**Description**: Update the tags associated with a community.

**Request Body**: [CommunityUpdateTagsDTO](#communityupdatetagsdto)

**Response**:
- `200 OK` with a JSON array of updated tags: [`string`]
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

**Request Body**: [CommunityMemberCreateDTO](#communitymembercreatedto)

**Response**:
- `201 Created` with a JSON object representing the created community member: [CommunityMemberGetDTO](#communitymembergetdto)
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
- `200 OK` with a JSON array of community member objects: [[CommunityMemberGetDTO](#communitymembergetdto)]
- `404 Not Found` if the community does not exist.

### Update Community Member

**Endpoint**: `PUT /api/communities/{communityId}/members`

**Description**: Update the role of a community member.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community.
- `profileId` (query parameter): The ID of the member's profile.

**Request Body**: [CommunityMemberUpdateDTO](#communitymemberupdatedto)

**Response**:
- `200 OK` with a JSON object representing the updated community member: [CommunityMemberGetDTO](#communitymembergetdto)
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

**Request Body**: [PostCreateDTO](#postcreatedto)

**Response**:
- `201 Created` with a JSON object representing the created post: [PostGetDTO](#postgetdto)
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
- `200 OK` with a JSON object representing the post: [PostGetDTO](#postgetdto)
- `404 Not Found`  if the post does not exist.

### Update Post

**Endpoint**: `PUT /api/communities/{communityId}/posts`

**Description**: Update an existing post.

**Request Parameters**:
- `postId` (query parameter): The ID of the post to be updated.

**Request Body**: [PostUpdateDTO](#postupdatedto)

**Response**:
- `200 OK` with a JSON object representing the updated post: [PostGetDTO](#postgetdto)
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

**Request Body**: [CommentCreateDTO](#commentcreatedto)

**Response**:
- `201 Created` with a JSON object representing the created comment: [CommentGetDTO](#commentgetdto)
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
- `200 OK` with a JSON array of comments: [[CommentGetDTO](#commentgetdto)]
- `404 Not Found` if the post does not exist.

### Update Comment

**Endpoint**: `PUT /api/posts/{postId}/comments`

**Description**: Update an existing comment.

**Request Parameters**:
- `commentId` (query parameter): The ID of the comment to be updated.

**Request Body**: [CommentUpdateDTO](#commentupdatedto)
**Response**:
- `200 OK` with a JSON object representing the updated comment: [CommentGetDTO](#commentgetdto)
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

**Request Body**: [ReplyCreateDTO](#replycreatedto)

**Response**:
- `201 Created` with a JSON object representing the created reply: [ReplyGetDTO](#replygetdto)
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
- `200 OK` with a JSON array of replies: [[ReplyGetDTO](#replygetdto)]
- `404 Not Found` if the comment does not exist.

### Update Reply

**Endpoint**: `PUT /api/comments/{commentId}/reply`

**Description**: Update an existing reply.

**Request Parameters**:
- `replyId` (query parameter): The ID of the reply.

**Request Body**: [ReplyUpdateDTO](#replyupdatedto)

**Response**:
- `200 OK` with a JSON object representing the updated reply: [ReplyGetDTO](#replygetdto)
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
- `200 OK` with a JSON object representing the profile: [ProfileGetDTO](#profilegetdto)
- `404 Not Found` if the comment does not exist.

### Update Profile

**Endpoint**: `PUT /api/profiles/{profileId}`

**Description**: Update the profile.

**Request Parameters**:
- `profileId` (path parameter): The ID of the profile to be updated.

**Request Body**: [ProfileUpdateDTO](#profileupdatedto)
**Response**:
- `200 OK` with a JSON object representing the updated profile: [ProfileGetDTO](#profilegetdto)
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
- `200 OK` with a JSON array of community documents: [[CommunityDocument](#communitydocument)]
- `404 Not Found` if the profile does not exist.

### Get Profile Posts

**Endpoint**: `GET /api/profiles/{profileId}/posts`

**Description**: Retrieve a list of posts created by the profile.

**Request Parameters**:
- `profileId` (path parameter): The ID of the profile.
- `page` (query parameter, optional): The page number for pagination. The default is `0`.

**Response**:
- `200 OK` with a JSON array of post documents: [[PostDocument](#postdocument)]
- `404 Not Found` if the profile does not exist.

## User

### Change Email

**Endpoint**: `PUT /api/user/{userId}/change_email`

**Description**: Change the email address of a user.

**Request Parameters**:
- `userId` (path parameter): The ID of the user whose email is to be changed.

**Request Body**: [ChangeEmailDTO](#changeemaildto)

**Response**:
- `200 OK` with a JSON string representing the new email: `email`
- `400 Bad Request` if the request body is invalid.
- `401 Unauthorized` if not logged in or could not send the JWT token.
- `403 Forbidden` if the user does not have permission to change the email.
- `404 Not Found`  if the user does not exist.

### Change Password

**Endpoint**: `PUT /api/user/{userId}/change_password`

**Description**: Change the password of a user.

**Request Parameters**:
- `userId` (path parameter): The ID of the user whose password is to be changed.

**Request Body**: [ChangePasswordDTO](#changepassworddto)

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
- `200 OK` with a JSON array of popular communities: [[CommunityDocument](#communitydocument)]

### Get Popular Posts

**Endpoint**: `GET /api/popular/posts`

**Description**: Retrieve a list of the most popular posts based on click count and creation date.

**Request Parameters**:
- `page` (query parameter, optional): The page number for pagination. The default is `0`.

**Response**:
- `200 OK`  with a JSON array of popular posts: [[PostDocument](#postdocument)]

### Get Community Popular Posts

**Endpoint**: `GET /api/popular/communities/{communityId}/posts`

**Description**: Retrieve a list of the most popular posts within a specific community based on click count and creation date.

**Request Parameters**:
- `communityId` (path parameter): The ID of the community.
- `page` (query parameter, optional): The page number for pagination. The default is `0`.

**Response**:
- `200 OK` with a JSON array of popular posts within the specified community: [[PostDocument](#postdocument)]

### Get Popular Games

**Endpoint**: `GET /api/popular/games`

**Description**: Retrieve a list of the most popular games based on popularity.

**Response**:
- `200 OK` with a JSON array of popular games: [[GameDocument](#gamedocument)]

## Search

### Search Games

**Endpoint**: `POST /api/search/games`

**Description**: Search for games based on name, alternative names, and genre IDs.

**Request Body**: [GameSearchFilter](#gamesearchfilter)

**Response**:
- `200 OK` with a JSON array of game documents: [[GameDocument](#gamedocument)]

### Search Communities

**Endpoint**: `POST /api/search/communities`

**Description**: Search for communities based on title and associated game ID.

**Request Body**: [CommunitySearchFilter](#communitysearchfilter)

**Response**:
- `200 OK` with a JSON array of community documents: [[CommunityDocument](#communitydocument)]

### Search Profiles

**Endpoint**: `POST /api/search/profiles`

**Description**: Search for user profiles based on nickname.

**Request Body**: [[SearchFilter](#searchfilter)]

**Response**:
- `200 OK` with a JSON array of profile documents: [[ProfileDocument](#profiledocument)]

### Search Posts

**Endpoint**: `POST /api/search/posts`

**Description**: Search for posts based on title, community ID, and tag.

**Request Body**: [[PostSearchFilter](#postsearchfilter)]

**Response**:
- `200 OK` with a JSON array of post documents: [[PostDocument](#postdocument)]

## Like

### Like Post

**Endpoint**: `PATCH /api/like/post/{postId}`

**Description**: This endpoint allows a user to like or unlike a post. If the user has already liked the post, calling this endpoint will unlike it, and vice versa.

**Path Parameters**:
- `postId` (string): The ID of the post to like or unlike.

**Response**:
- `200 OK`: Returns true if the post is liked, and false if it is unliked.

### Like Comment

**Endpoint**: `PATCH /api/like/comment/{commentId}`

**Description**: This endpoint allows a user to like or unlike a comment. If the user has already liked the comment, calling this endpoint will unlike it, and vice versa.

**Path Parameters**:
- `commentId` (string): The ID of the comment to like or unlike.

**Response**:
- `200 OK`: Returns true if the comment is liked, and false if it is unliked.

### Like Reply

**Endpoint**: `PATCH /api/like/reply/{replyId}`

**Description**: This endpoint allows a user to like or unlike a reply. If the user has already liked the reply, calling this endpoint will unlike it, and vice versa.

**Path Parameters**:
- `replyId` (string): The ID of the reply to like or unlike.

**Response**:
- `200 OK`: Returns true if the reply is liked, and false if it is unliked.

## Returned JSONs

### Authentication

#### LoginRequestDTO
- `username`: `String` (must be between 6 and 30 characters)
- `password`: `String` (must be between 8 and 30 characters, allowed characters: a-z, A-Z, 0-9, @$!%?&)

#### RegisterRequestDTO
- `username`: `String` (must be between 6 and 30 characters)
- `nickname`: `String` (must be between 6 and 30 characters)
- `email`: `String` (must be a valid email address)
- `password`: `String` (must be between 8 and 30 characters, allowed characters: a-z, A-Z, 0-9, @$!%?&)

#### ChangeEmailDTO
- `newEmail`: `String` (must be a valid email address)

#### ChangePasswordDTO
- `currentPassword`: `String` (must be between 8 and 30 characters, allowed characters: a-z, A-Z, 0-9, @$!%?&)
- `newPassword`: `String` (must be between 8 and 30 characters, allowed characters: a-z, A-Z, 0-9, @$!%?&)

### Profile

#### ProfileGetDTO
- `id`: `Long`
- `nickname`: `String`
- `firstPageCommunities`: `List<CommunityDocument>` ([CommunityDocument](#communitydocument))
- `firstPagePosts`: `List<PostDocument>` ([PostDocument](#postdocument))

#### ProfileUpdateDTO
- `nickname`: `String` (must be between 6 and 30 characters)

### Community

#### CommunityCreateDTO
- `title`: `String` (must be between 6 and 30 characters)
- `description`: `String` (must be between 1 and 255 characters)
- `gameId`: `String` (not blank)

#### CommunityGetDTO
- `id`: `Long`
- `title`: `String`
- `description`: `String`
- `game`: `GameDocument` ([GameDocument](#gamedocument))
- `tags`: `List<String>`
- `firstPageMembers`: `List<CommunityMemberGetDTO>` ([CommunityMemberGetDTO](#communitymembergetdto))
- `firstPagePopularPosts`: `List<PostDocument>` ([PostDocument](#postdocument))

#### CommunityUpdateDTO
- `title`: `String` (must be between 6 and 30 characters)
- `description`: `String` (must be between 1 and 255 characters)

#### CommunityUpdateTagsDTO
- `tags`: `List<String>`
- `remove`: `boolean`

### Post

#### PostCreateDTO
- `title`: `String` (must be between 6 and 30 characters)
- `tag`: `String` (not blank)
- `text`: `String` (must be between 1 and 255 characters)

#### PostGetDTO
- `id`: `Long`
- `title`: `String`
- `tag`: `String`
- `text`: `String`
- `writerId`: `String`
- `writerNickname`: `String`
- `createdDate`: `Date`
- `lastModifiedDate`: `Date`
- `communityId`: `Long`
- `communityName`: `String`
- `firstPageComments`: `List<CommentGetDTO>` ([CommentGetDTO](#commentgetdto))

#### PostUpdateDTO
- `title`: `String` (must be between 6 and 30 characters)
- `tag`: `String` (not blank)
- `text`: `String` (must be between 1 and 255 characters)

### Comment

#### CommentCreateDTO
- `text`: `String` (must be between 1 and 255 characters)

#### CommentGetDTO
- `id`: `Long`
- `text`: `String`
- `writerId`: `Long`
- `writerNickname`: `String`
- `createdDate`: `Date`
- `lastModifiedDate`: `Date`

#### CommentUpdateDTO
- `text`: `String` (must be between 1 and 255 characters)

### Reply

#### ReplyCreateDTO
- `text`: `String` (must be between 1 and 255 characters)

#### ReplyGetDTO
- `id`: `Long`
- `text`: `String`
- `commentId`: `Long`
- `writerId`: `Long`
- `writerNickname`: `String`
- `createdDate`: `Date`
- `lastModifiedDate`: `Date`

#### ReplyUpdateDTO
- `text`: `String` (must be between 1 and 255 characters)

### Chat

#### ChatCreateDTO
- `participantProfileIds`: `List<Long>`

#### ChatGetDTO
- `id`: `Long`
- `firstPageParticipants`: `List<ChatParticipantGetDTO>` ([ChatParticipantGetDTO](#chatparticipantgetdto))
- `firstPageMessages`: `List<MessageGetDTO>` ([MessageGetDTO](#messagegetdto))

### Message

#### MessageCreateDTO
- `text`: `String` (must be between 1 and 255 characters)
- `isSent`: `boolean`

#### MessageGetDTO
- `senderProfileId`: `Long`
- `senderName`: `String`
- `text`: `String`
- `sendDate`: `Date`
- `isSent`: `boolean`

#### MessageUpdateDTO
- `id`: `Long`
- `text`: `String` (must be between 1 and 255 characters)

### Chat Participant

#### ChatParticipantCreateDTO
- `profileId`: `Long`

#### ChatParticipantGetDTO
- `id`: `Long`
- `nickname`: `String`
- `isMod`: `boolean`

#### ChatParticipantUpdateDTO
- `id`: `Long`
- `isMod`: `boolean`

### Community Member

#### CommunityMemberCreateDTO
- `profileId`: `Long`

#### CommunityMemberGetDTO
- `id`: `Long`
- `nickname`: `String`
- `role`: `CommunityMember.Role`

#### CommunityMemberUpdateDTO
- `role`: `CommunityMember.Role`

### Search Filters

#### SearchFilter
- `keyword`: `String`
- `page`: `Integer`
- `size`: `Integer`

#### CommunitySearchFilter
- `keyword`: `String`
- `page`: `Integer`
- `size`: `Integer`
- `gameId`: `String`

#### GameSearchFilter
- `keyword`: `String`
- `page`: `Integer`
- `size`: `Integer`
- `genreIds`: `List<Integer>`

#### PostSearchFilter
- `keyword`: `String`
- `page`: `Integer`
- `size`: `Integer`
- `communityId`: `String`
- `tag`: `String`

### Documents

#### CommunityDocument
- `id`: `String`
- `title`: `String`
- `description`: `String`
- `memberCount`: `Long`
- `clickCount`: `Long`
- `game`: `GameDocument` ([GameDocument](#gamedocument))

#### GameDocument
- `id`: `String`
- `name`: `String`
- `alternativeNames`: `List<String>`
- `genreIds`: `List<Integer>`
- `popularity`: `Double`
- `communityCount`: `Long`

#### PostDocument
- `id`: `String`
- `title`: `String`
- `text`: `String`
- `tag`: `String`
- `clickCount`: `Long`
- `profile`: `ProfileDocument` ([ProfileDocument](#profiledocument))
- `community`: `CommunityDocument` ([CommunityDocument](#communitydocument))
- `createdDate`: `Date`
- `likedByProfileIds`: `List<String>`

#### ProfileDocument
- `id`: `String`
- `nickname`: `String`
- `communityIds`: `List<String>`