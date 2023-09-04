# Fly Application

The Fly Application is an application that allows you to control and track the position of a space capsule as it follows a planned course.

## Requirements

- Java 17 or higher
- Maven (for compiling and managing dependencies)

## Configuration

1. Clone this repository to your local machine.
2. Ensure you have Java 17 or higher installed.
3. You can configure the location of the input file by modifying the `input.file` property in the `application.properties` file.

## Usage

1. Compile the application using the Maven command:

   ```shell
   mvn clean package
   ```

2. Run the application with the following command:

   ```shell
   java -jar target/fly-x.x.x-SNAPSHOT.jar
   ```

## Input Data

The input file should follow the following format:

   ```shell
   forward 5
   down 3
   up 2
   ```

## Results

After running the application, the result, which is the product of the horizontal position and final altitude, will be displayed in the console.