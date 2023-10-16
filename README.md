# Craps Game API
This project implements a simple API for playing the game of Craps. 
The API allows users to play a single round or multiple rounds of the game.

## Features
* Play a single round of the Craps game.
* Play multiple rounds of the Craps game with customizable parameters.

## Getting Started

### Prerequisites
Ensure you have the following prerequisites installed:
* Java Development Kit (JDK) 8 or later
* Apache Maven (for building and managing dependencies)

### Installation
1. Clone the repository:
   * git clone https://github.com/INestorov/Craps.git
   * cd craps
2. Build the application using Gradle:
   *   ./gradlew build
3. Run the application:
   * java -jar build/libs/craps-0.0.1-SNAPSHOT.jar

## Usage

### Play a Single Round
To play a single round of the Craps game, make a POST request to the /craps/play-single-round endpoint,
providing the necessary input in the request body.

Example Request:

    curl -X POST http://localhost:8080/craps/play-single-round
    -H "Content-Type: application/json"
    -d '{"stake": 1.0, "typeOfGame": "craps"}'

### Play Multiple Rounds

To play multiple rounds of the Craps game, make a POST request to the /craps/play-multiple-rounds endpoint, specifying the number of rounds and providing the necessary input in the request body.

Example Request:

    curl -X POST 'http://localhost:8080/craps/play-multiple-rounds?numberOfRounds=5'
    -H "Content-Type: application/json"
    -d '{"stake": 1.0, "typeOfGame": "craps"}'

## API Endpoints

* POST /craps/play-single-round: Play a single round of the Craps game.
    * Request Body: GameRequest with stake and game type.
    * Response: GameResponse with the game outcome.


* POST /craps/play-multiple-rounds: Play multiple rounds of the Craps game.
    * Request Parameters: numberOfRounds (integer): Number of rounds to play.
    * Request Body: GameRequest with stake and game type.
    * Response: List of GameResponse with the game outcomes for each round.
