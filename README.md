# CSF213 Mini Project

### Mid semester evaluation

Making UML diagrams for backend and frontend.

### End semester evaluation

Working site

## Running the backend

Have Java 17, postgresql installed. Create a database named `silkroad` in psql.

1. Clone the git repo
2. In `src/main/resources/` create a folder named `certs`. Now `cd` into the `certs` folder and run the following commands.
   ```bash
   openssl genrsa -out keypair.pem 2048
   openssl rsa -in keypair.pem -pubout -out public.pem
   openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem
   ```
3. In `src/main/resources/` rename `application.properties.example` to `application.properties`, Open `application.properties` and fill out the blank fields.
4. In the root directory, run `./mvnw spring-boot:run` or you can use the spring boot dashboard extension in VSCode to run.

## Running the frontend

Have `yarn`(preferable) or `npm` installed.

1. Clone the git repo.
2. `cd` into the `frontend` folder.
3. Run `yarn` to install the dependencies.
4. Run `yarn dev` to start it.

## Steps to make UML diagrams with plantuml

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
2. Checkout to a new branch named with the feature you want to work on. Use the command center( <kbd>Ctrl</kbd> + <kbd>Shift</kbd> + <kbd>P</kbd> and search for `Git:Checkout to ...`) in VSCode.
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