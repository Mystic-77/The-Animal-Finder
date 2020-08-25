# The-Animal-Finder
A maven based javaFX application that uses mongoDB that helps to identify unknown animals if present in database.



## Screenshots

<img src="https://i.imgur.com/ounoqkB.png" alt="Screenshot1" style="zoom: 80%;" />

<img src="https://i.imgur.com/CUtxaRb.png" alt="Screenshot2" style="zoom:80%;" />![Screenshot3](https://i.imgur.com/P42ONpw.png)

<img src="https://i.imgur.com/CUtxaRb.png" alt="Screenshot2" style="zoom:80%;" />![Screenshot3](https://i.imgur.com/P42ONpw.png)

## How to Run the Code

1. Import the project using VCS as a maven project

2. Set the project SDK to Java 11

3. Have a [MongoDB Server](https://www.mongodb.com/try/download/community)  installed  and running for the program to be able to work.

4. Build the project and run the Main.java

5. *when the code is executed , you might encounter warnings regarding few mongoDB deprecated methods which you can ignore.*

   

## How to use the application

The application GUI allows you to create, update and delete entries to the DB. Using Add entries, one can add a new entry or update an existing one by filling the primary key field(Scientific name) and updating the required values.

The search feature also has a delete option to delete entries if the primary key is provided.

The search results are returned to the terminal instead of the GUI. 

Use the exit button to close the GUI.

No initial dataset is provided so users are required to add entries on their own.

