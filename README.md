# Battleship

Battleship coding Challenge: A two player [game](https://en.wikipedia.org/wiki/Battleship_(game))

## Getting Started

Execute Class Battleship with the following inputs
~~~
5 E
2
Q 1 1 A1 B2
P 2 1 D4 C3
A1 B2 B2 B3
A1 B2 B3 A1 D1 E1 D4 D4 D5 D5 
~~~

### Prerequisites

jdk8 is used for the project

## Design
Battleship is the main class that starts the game
Here are the other key class
* Game: Consists of players and the logic of executing moves according to the rules of the game
* Player: Represents a player, has a list of ships specifically placed
* Ship: Represents a ship that spans one or more cells
* ShipSection: The cells that make up a ship. It also has a lifeCount representing the number of hits 
needed to kill it
* ShipType: Enum to represent a type of ship (hit count changes)
 
## Validations

No validations are added for constraints assuming they will be honored
Apart from those there may still be few more validations needed like
* ships should not overhang
* ships should not overlap
    
    
## Testcases
* GameTest is an integration test that simulates a full fledged game
* Rest of the classes have unit test cases where required (non trivial logic)
