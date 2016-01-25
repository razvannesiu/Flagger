## Flagger (*Android app*)

###Description
Flagger is a single-device multiplayer quiz game with numerous questions in which users have to identify the flag of a specific country. 

###Minimum requirements:
- API level: 10 
- Framework version : 2.3 (Gingerbread)

###Features implemented:
- [x] Random occurence of questions & answer choices.
- [x] Make texts scalable by using **dp** instead of **sp**.
- [ ] Make images scalable.
- [x] Display images dynamically from the resources folder.
  - [ ] Display images dynamically from the asset folder. (*__optimization__*)
- [x] Create a Java Class as database.
  - [ ] Using a SQL Database. (*__optimization__*)
- [ ] Implement "Back to start menu" item in End Menu
- Add questions & flags for all the countries from:
  - [x] Europe 
  - [x] Asia
  - [ ] North America
  - [ ] South America
  - [ ] Africa
  - [ ] Australia & Oceania
- Implement single player mode:
  - [ ] Display item in Start Menu.
  - [ ] Implement single player action (screen).
  - [ ] Update rematch button, so that it works for single player mode.
- Implement a single-device multiplayer player mode:
  - [x] Display item in Start Menu.
  - [x] Implement multiplayer action (screen).
  - [ ] Randomly permute the answer choices for second player.
- Implement a "Find flag" tool:
  - [ ] Display item in Start Menu.
  - [ ] Create a drop-down list with the names of the countries.
  - [ ] Implement functionality. (display flag, capital & trivia of the selected country)
- Implement Settings tool:
  - [ ] Display item in Start Menu.
- Change difficulty feature:
    - [ ] Create drop-down list.
    - [ ] Implement functionality. (on click handlers)
    - [ ] Easy: 15 seconds per question; questions related to well-known countries.
    - [ ] Normal: 10 seconds per question; all questions.
    - [ ] Hard: 5 seconds per question; exclude the questions used in Easy mode.
  - Change match length feature:
    - [ ] Create drop-down list with numbers from 5 to 50 (possible number of questions per match).
    - [ ] Implement functionality. (action taken when user selects a number)
  - Choose continents feature:
    - [ ] Create list with checkable text views (with the names of the continents - except Antarctica) 
    - [ ] Implement functionality. (questions regarding countries from the checked continent are enabled)

###Screenshots
![Start Menu](/Screenshots/StartMenu.jpg)
![Gameplay 1](/Screenshots/Gameplay.jpg)
![Gameplay 2](/Screenshots/Gameplay2.jpg)
![End Menu](/Screenshots/EndMenu.jpg)
![Logo](/Screenshots/logoFlagger.png)

###Attributions
Flag images made by [antibakteriell] (http://antibakteriell.deviantart.com/) from DeviantArt. ([license] (http://creativecommons.org/licenses/by/3.0/))

All the other icons are from [Material Design Icons] (https://materialdesignicons.com/). ([license] (https://creativecommons.org/licenses/by/4.0/))
