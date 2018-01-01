# Welcome to PacMan-solves-a-maze Project

#### About

This is a fun project in my artificial intelligence course. The goal is to use search algorithms
to help PacMan find the path through a maze. The path is something like "East, South, South, West, South". 
The problem input is a graph. Search algorithms used:
- Depth first search: search the deepest nodes first
- Breath first search: search the shallowest nodes first
- Uniform cost search: search with path cost 
- A* search: search with heuristic and path cost

#### To run

- Just clone this repository. You will need Python installed.
- Add Python to your system environment variable (You can do this at installation, too).
- Run CMD and navigate to this folder.
Run this command to find available syntax:
	```
	python pacman.py -h
	```
Commands I used (each line is a separate command):
	python pacman.py
	python pacman.py --layout testMaze --pacman GoWestAgent
	python pacman.py --layout tinyMaze --pacman GoWestAgent
	python pacman.py -l tinyMaze -p SearchAgent -a fn=tinyMazeSearch
	python pacman.py -l tinyMaze -p SearchAgent
	python pacman.py -l mediumMaze -p SearchAgent
	python pacman.py -l bigMaze -z .5 -p SearchAgent
	python pacman.py -l mediumMaze -p SearchAgent -a fn=bfs
	python pacman.py -l bigMaze -p SearchAgent -a fn=bfs -z .5
	python eightpuzzle.py
	python pacman.py -l mediumMaze -p SearchAgent -a fn=ucs
	python pacman.py -l mediumDottedMaze -p StayEastSearchAgent
	python pacman.py -l mediumScaryMaze -p StayWestSearchAgent
	python pacman.py -l bigMaze -z .5 -p SearchAgent -a fn=astar,heuristic=manhattanHeuristic 

#### Credits

Special thanks to my Professor Sakpal for helping me with implementations of the algorithms.