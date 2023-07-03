# demo-nimmsta-core

# requirement

- JDK 17+
- Gradle
- Debian OS (it's tested on Ubuntu)
- Laird bluetooth

## Installation

before running the application, you need to install the dependencies, for that you have to update username and password, 
to access the private repository. if you do not have username or password please contact the repository owner.

after setting the username and password, you can run the following command to install the dependencies.

```bash
./gradlew clean build
```

to run the project you can use following command.
```bash
./gradlew clean run
```

## Usage
this demo project  trys to update the device on connect, so for that purpose you need to connect the device to the system.
after that updating the update path and then allowing the command to execute.