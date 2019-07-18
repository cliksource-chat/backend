# Backend
Created a backend Rest API that allows for a UI to have a Chat Messaging System.  It allows persistant data through utilizing MongoDB.

## Requirements

Access to a MongoDB that is deployed on a server.  Or have MongoDB installed on your system, and running in the background.  To use MongoDB locally, delete the lines starting with, `spring.data.mongodb.*`.  To configure MongoDB as per your requirements, replace: `HostName`, `PortName`, `UserName`, `Password`, and `DatabaseName`, so they line up with your database.  These settings can be
configured in __application.properties__ found in the directory __backend/src/main/resources__.  Additionally our Rest Service is configured to run using Port 8090.  These can only be accessed with the current setttings from a Front End Application using the Port 4200, or with a developer tool such as Postman.  If you have are getting an Error with starting the Server, and it says there is an application already running on the port, you can configure that in the __application.properties__, by changing the `PortNumber` to one that is not currently being used.  If you are trying to consume the Rest API from another source, that is not part of a developers tool, and uses another port, change the `@CrossOrigin(origins = "localhost:4200")` to the appropriate PortNumber. <br>

__application.properties__
<br>
`
server.port = PortNumber
` <br>
`
spring.data.mongodb.host = HostName
` <br>
`
spring.data.mongodb.port = PortName
` <br>
`
spring.data.mongodb.username = UserName
` <br>
`
spring.data.mongodb.password = Password
` <br>
`
spring.data.mongodb.database = DatabaseName
` <br>

## Using Rest API:

You will want to use the hostname in a request beginning with `http://localhost:8090/` or `localhost:8090/`, after the / insert the following content between the Quote Marks within the mapping parameters.

### Chat Room Rest Controller

#### ChatRooms GET Requests
##### GET ChatRooms
`@GetMapping("/api/chatrooms")` <br>
When making this `GET` request, it returns a list of all of the ChatRooms. __POTENTIAL SECURITY FLAW, ONLY USE FOR DEVELOPMENT!__

##### GET ChatRooms Based off of ChatRoomId
`@GetMapping("/api/chatrooms/{id}")` <br>
When making this `GET` request, tag on the `ObjectId` of a `ChatRoom` where it will return the approapriate ChatRoom as specified by the `{id}`.

##### GET ChatRooms Based off of UserId and Order them by Date Created
`@GetMapping("/api/chatrooms/userSpecific/{user}")` <br>
When making this `GET` request, tag on the `ObjectId` of a `User` where it will return a list of `ChatRooms` ordered by the dates that they were created.

#### ChatRooms POST Request
##### POST ChatRooms
`@PostMapping("/api/chatrooms")` <br>
When making this `POST` request, you will need to send a `RequestBody` that contains a `JSON` object that follows the same model as we have defined.  Otherwise the data will not be recoverable.  It returns a `ResponseEntity` with a body of "Created!".

### Message Rest Controller

#### Message GET Requests
##### GET Messages
`@GetMapping("/api/messages` <br>
When making this `GET` request, it returns a list of all of the Messages.  __POTENTIAL SECURITY FLAW, ONLY USE FOR DEVELOPMENT!__

##### GET Messages Based off of MessageId
`@GetMapping("/api/messages/{id}")` <br>
When making this `GET` request, tag on the `ObjectId` of a `Message` where it will return the appropriate Message as specified by the `{id}`.

##### GET Messages Based off of ChatRoomId and Orders them By Timestamp
`@GetMapping("/api/messages/byRoomId/{chatRoomId}")` <br>
When making this `GET` request, tag on the `ObjectId` for the `ChatRoom`, where it will then return a list of `Messages` ordered by the Timestamp that they have.

#### Message POST Requests
##### POST Messages
`@PostMapping("/api/messages")` <br>
When making this `POST` request, you will need to send a `RequestBody` that contains a `JSON` object that follows the same model as we have defined.  Otherwise the data will not be recoverable.  It returns a `ResponseEntity` with a body of "MESSAGE CREATED".

### User Rest Controller

#### User GET Requests
##### GET Users
`@GetMapping("/api/users")` <br>
When making this `GET` request, it returns a list of all of the Users. __POTENTIAL SECURITY FLAW, ONLY USE FOR DEVELOPMENT!__

##### GET User Based off of ID
`@GetMapping("/api/users/{id}")` <br>
When making this `GET` request, tag on the `ObjectId` for the `User` where it will return the appropriate User as specified by the `{id}`.

#### User POST Requests
##### POST User
`@PostMapping("/api/users")` <br>
When making this `POST` request, you will need to send a `RequestBody` that contains a `JSON` object that follows the same model as we have defined.  Otherwise the data will not be recoverable.  It returns a `ResponseEntity` with a body of "Created!".
