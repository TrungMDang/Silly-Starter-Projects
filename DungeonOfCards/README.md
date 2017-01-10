#Dungeon of Cards

###Summary

This is a fun team project I've participated in. My team was made up of 3 people. We used JavaScript primarily for 
the entire project and the Canvas element of HTML.

The game is not yet complete but player can play indefinitely as long as there is health point left.

###My Contribution:

I helped to develop the initial idea for the project. One of my teamates was already working on the dungeon generator
using Python so we thought I would be cool to make a game based on that. 

I was tasked to implement the viewport Camera that always follows player-controlled character on screen.
I also added sounds which were later improved by my teamates to suit the style of the game.

###Project Structure:

- assetmanager: 
  - provided code that manages images for the game.
- character: 
  - implementation of player-controlled character and monsters.
- dungeonGenerator: 
  - generates the structure of the dungeon with monsters and doors to next level.
- gameEngine:
  - manages input from player. 
  - contains **Camera** object I worked on. There is detailed doc about how to use the camera for new object on screen.
- main:
  - downloads assets, set up and start the game.
  
###Team
```
Christopher Marriott - instructor
Matthew Cles
Brandon Scholer
Trung Dang
```


