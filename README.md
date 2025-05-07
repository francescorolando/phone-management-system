# Phone Management System

This project is a Java-based application designed to manage phones, tablets, and phone services. It provides functionalities to handle devices, their owners, and phone service providers, along with operations to query and manipulate the data.

## Project Structure

The project is organized as follows:

### Key Classes

-   **`Main`**: The entry point of the application. Demonstrates the usage of the various classes and their functionalities.
-   **`Persona`**: Represents a person with attributes like name and address.
-   **`Produttore`**: Represents a manufacturer of devices, including attributes like name and country.
-   **`Telefono`**: Represents a generic phone with attributes like memory, value, and owner. Implements the `Comparable` interface for sorting by memory.
-   **`TelefonoLavoro`**: A specialized phone for work purposes, extending `Telefono`. It includes additional attributes like the company name and overrides certain methods.
-   **`Tablet`**: Represents a tablet device, extending `Telefono`. Includes attributes for keyboard type and value.
-   **`PhoneService`**: Manages an array of phones, providing methods to add, remove, and query phones.
-   **`PhoneServiceList`**: Similar to `PhoneService`, but uses an `ArrayList` to manage phones.
-   **`YellowPages`**: Manages phone services by city, allowing operations like adding, removing, and querying phone services by city.

## Features

-   **Device Management**:

    -   Add, remove, and query phones and tablets.
    -   Modify device attributes like memory and owner.
    -   Sort devices by memory.

-   **Phone Service Management**:

    -   Add and remove phone services.
    -   Query phone services by city or other attributes.

-   **Yellow Pages**:

    -   Manage phone services across multiple cities.
    -   Query cities with specific phone services.

-   **Statistics**:
    -   Calculate the average memory of devices.
    -   Find devices with the smallest or largest memory.

## How to Run

1. Clone the repository to your local machine.
2. Open the project in an IDE like IntelliJ IDEA or Visual Studio Code.
3. Ensure you have Java 21 or higher installed.
4. Run the `Main` class to execute the application.

## Example Usage

The `Main` class demonstrates the following:

-   Creating instances of `Persona`, `Produttore`, `Telefono`, `Tablet`, and `TelefonoLavoro`.
-   Adding devices to `PhoneService` and `PhoneServiceList`.
-   Querying and manipulating devices and phone services.
-   Managing phone services in `YellowPages`.

## Requirements

-   **Java Version**: OpenJDK 21 or higher
-   **IDE**: IntelliJ IDEA, Visual Studio Code, or any Java-compatible IDE
