# nimmsta-java-ubuntu-example-project

# requirement

#### please make sure requirements meets

- JDK 17+
- Gradle
- Debian OS (it's tested on Ubuntu)
- [Laird bluetooth dongle driver and configuration](https://github.com/LairdCP/UwTerminalX) (NIMMSTA Bluetooth Dongle)

## Installation

Before running the application, you need to install the dependencies. for that you have to update username and password; to access the private repository. If you do not know your username and password; Please contact the repository owner.

After setting the username and password, you can run the following command to install the dependencies.

```bash
./gradlew clean build
```

To run the project, you can use the following command.
```bash
./gradlew clean run
```

## Usage
This demo project tries to update the device on connect, for that purpose, you need to pair the device to the system.
After that updating the update path and then allowing the command to execute.
