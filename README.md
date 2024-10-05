# Studystack

Studystack is a collaborative platform that has been created to help users collaborate and help each other with academic as well as professional difficulties.

## Steps to run locally

1. Clone this repository to an IDE of your own choice.
2. Make sure that you have gradle installed.
3. Run the class `StudyStackApplication.java` to start the application locally.
4. When you search for `localhost:8080`, you should find the error `Whitelabel error` on the screen. This does not mean that the application is not working properly. It means that the server is setup properly locally.

## APIs developed within this application:

localhost:8080/users/create(POST): Create a new user.
localhost:8080/groups/create(POST): Create a new group of users.
localhost:8080/groups/users/create(POST): Add a new user to a group.
localhost:8080/question(POST): Ask a question in a group.
localhost:8080/answer(POST): Answer a question that has been asked by a user.
