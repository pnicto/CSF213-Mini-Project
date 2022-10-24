# CSF213 Mini Project


## Mid semester evaluation

Making UML diagrams for backend and frontend.

### TODO

#### Backend

- Figure out how spring boot works and make classes according to that

#### Frontend

- Finalize the figma flow chart.

### Steps to make UML diagrams with plantuml

1. Have [VSCode](https://code.visualstudio.com/).
2. Install this extension [VSCode plantuml](https://github.com/qjebbs/vscode-plantuml#how-to-install).
3. Install plantuml. Follow either the local render or server render method.[Instructions](https://github.com/qjebbs/vscode-plantuml#requirements). I use the server render method specifically the third one with picoweb.
4. Add these settings in VScode settings json file. Can be accessed with <kbd>Ctrl</kbd> + <kbd>Shift</kbd> + <kbd>P</kbd>

  ![Command Palette](https://i.imgur.com/qxBrHts.png)

```json
  "plantuml.diagramsRoot": "docs/diagrams/src",
  "plantuml.exportOutDir": "docs/diagrams/out",
  "plantuml.server": "http://192.168.1.100:8080",
  "plantuml.render": "PlantUMLServer"
```
5. Open `Backend.wsd` in `./docs/diagrams/src/` directory.
6. Open the preview of the file by using <kbd>Alt</kbd> + <kbd>D</kbd>
7. [Refer](https://plantuml.com/class-diagram) this to make the UML diagrams.