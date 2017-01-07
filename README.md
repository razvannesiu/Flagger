## Flagger (*Android app*)

###Description
Flagger is an entertaining and educational quiz game about the flags of various countries. It has a Single Player mode that allows players to practice guessing the flags, but it also has a single-device Offline Multiplayer mode, which encourages the 2 players to share stories about their background while learning the flags of virtually all the countries worldwide. In the Settings panel, players can choose how many questions to be displayed in a match, and they can also choose the pace of the game, meaning that they can choose how many seconds are allocated for each question.

###Minimum requirements:
- API level: 10 
- Framework version : 2.3.3 (Gingerbread)

###Features implemented:
- [x] Random occurence of questions & answer choices.
- [x] Make texts scalable by using **dp** instead of **sp**.
- [ ] Make images scalable.
- [x] Display images dynamically from the resources folder.
  - [ ] Display images dynamically from the asset folder. (*__optimization__*)
- [x] Create a Java Class as database.
  - [ ] Using a SQL Database. (*__optimization__*)
- [x] Implement "Back to start menu" item in End Menu
- Add questions & flags for all the countries from:
  - [x] Europe 
  - [x] Asia
  - [ ] North America
  - [ ] South America
  - [ ] Africa
  - [ ] Australia & Oceania
- Implement single player mode:
  - [x] Display item in Start Menu.
  - [x] Implement single player action (screen).
  - [x] Update rematch button, so that it works for single player mode.
- Implement a single-device multiplayer player mode:
  - [x] Display item in Start Menu.
  - [x] Implement multiplayer action (screen).
  - [ ] Randomly permute the answer choices for second player.
- Implement a "Find flag" tool:
  - [ ] Display item in Start Menu.
  - [ ] Create a drop-down list with the names of the countries.
  - [ ] Implement functionality. (display flag, capital & trivia of the selected country)
- Implement Settings tool:
  - [x] Display item in Start Menu.
- Change difficulty feature:
    - [ ] Create drop-down list.
    - [ ] Implement functionality. (on click handlers)
    - [ ] Easy: 15 seconds per question; questions related to well-known countries.
    - [ ] Normal: 10 seconds per question; all questions.
    - [ ] Hard: 5 seconds per question; exclude the questions used in Easy mode.
  - Change match length feature:
    - [x] Create seek bar with numbers from 3 to 30 (possible number of questions per match).
    - [x] Create seek bar with numbers from 3 to 30 (possible number of seconds per question).
    - [x] Implement functionality. (action taken when user selects a number)
  - Choose continents feature:
    - [ ] Create list with checkable text views (with the names of the continents - except Antarctica) 
    - [ ] Implement functionality. (questions regarding countries from the checked continent are enabled)

###Screenshots
![Game Over](/Screenshots/samsung_s3_game_over.png)
![Gameplay Multiplayer 1](/Screenshots/samsung_s3_multi.png)
![Gameplay Multiplayer 2](/Screenshots/samsung_s3_multi2.png)
![Settings](/Screenshots/samsung_s3_settings.png)
![Gameplay Single 1](/Screenshots/samsung_s3_single.png)
![Gameplay Single 2](/Screenshots/samsung_s3_single_correct.png)
![Gameplay Single 3](/Screenshots/samsung_s3_single_wrong.png)
![Start Menu](/Screenshots/samsung_s3_start.png)
![Feature graphic including logo](/Screenshots/Flagger-feature-graphic.png)

###Attributions
Flag images made by [antibakteriell] (http://antibakteriell.deviantart.com/) from DeviantArt. ([license] (http://creativecommons.org/licenses/by/3.0/))

Logo designed by my cousin, Ioana Barbara.

All the other icons are from [Material Design Icons] (https://materialdesignicons.com/). ([license] (https://creativecommons.org/licenses/by/4.0/))

All the new fonts used in this app are from [Google Fonts] (https://fonts.google.com/?query=oleo) ([terms of agreement] (https://developers.google.com/terms/))
