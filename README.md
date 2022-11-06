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
  "plantuml.diagramsRoot": "docs/src",
  "plantuml.exportOutDir": "docs/",
  "plantuml.exportOutDir": "docs/diagrams/out",
  "plantuml.server": "http://192.168.1.100:8080",
  "plantuml.render": "PlantUMLServer"
```
5. Open `Backend.wsd` in `./docs/diagrams/src/` directory.
6. Open the preview of the file by using <kbd>Alt</kbd> + <kbd>D</kbd>
7. [Refer](https://plantuml.com/class-diagram) this to make the UML diagrams.

## Working with the backend

We are using Java 17 so install it.

1. Clone the git repo.
2. Checkout to the `figuring-out` branch. Use the command center( <kbd>Ctrl</kbd> + <kbd>Shift</kbd> + <kbd>P</kbd> and search for `Git:Checkout to ...`) in VSCode.
3. Download postgresql.
   #### Linux

    * Follow this [link](https://wiki.archlinux.org/title/PostgreSQL) for instructions.
    * TLDR of the link after installing using your respective package managers. While creating user create with the same name as your linux username.
    ```bash
    sudo -iu postgres
    sudo systemctl enable --now postgresql.service
    createuser --interactive
    createdb dataBaseNameSameAsTheAboveUserName
    psql
    ```

   #### Windows

   * Watch this [video](https://www.youtube.com/watch?v=BLH3s5eTL4Y). I am not sure about windows, contact Pranav for troubleshooting.

4. After having your postgresql setup done. Install `Extension Pack for Java` and `Spring Boot Extension Pack` extensions on VSCode.
5. Go to the psql shell by typing `psql` or `psql -U postgres` and create a new using
   ```bash
    CREATE DATABASE silkroad;
   ```
6. In `src/main/resources` create a file named `application.properties` and add the following lines.
   ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/silkroad
    spring.datasource.username=
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=create-drop
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.properties.hibernate.format_sql=true
    server.error.include-message=always
   ```
   Add the username and password.