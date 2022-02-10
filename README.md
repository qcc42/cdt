# cdt
Crosskey coding test

Requirements: JDK and JRE. You can download them and find instructions on how to install them on https://www.oracle.com/java/technologies/downloads/

To run this application:
1. Download the code from Github in .zip format
2. Unpack the .zip file
3. Run PowerShell from the start menu
4. Locate the unpacked folder cdt-main
5. Build and test the application by running the gradle wrapper 'gradlew' provided in the folder:
  Command: ./gradlew build
6. In order to get output in UTF-8 encoding, execute the following command in PowerShell:
  Command: [Console]::OutputEncoding = [System.Text.Encoding]::UTF8
7. Run the application witht he gradle wrapper:
  Command: ./gradlew run
  
The source code of the application is found under cdt-main\app\src\main\java\cdt\
The source code of the JUnit test is found under cdt-main\app\src\test\java\cdt\
