This is the complete project framework required for the Citi internship.

# Features

1. Utilises a General Store app.
2. Hardwired to run on an emulator called "Demo". 
3. No manual invocation of the emulator or appium server needed. Happens programmatically.
4. Cucumber & Maven are used to develop the framework.
5. Can run as a maven test through command prompt.
6. Object Repository as properties file is implemented.
7. Logger has been implemented.
8. Data Driven with Data Tables, Excel and Regular Expressions. 
9. Multiple feature files with multiple scenarios
10. Gestures like clicking, scrolling, entering text, checkboxes, switching context, slider, alert boxes, drag n drop have been implemented.
11. Reporting has been implemented through webpages with the help of pretty plugin.

# Prerequisites

1. Download and install **Java**  [Explain me how, JDK8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html#license-lightbox)
2.  Configure Java environment variables  [Explain me how](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html)
3. Download and install **Android Studio**  [Explain me how](https://developer.android.com/studio)
4. Configure Android environment variables  [Explain me how](http://www.automationtestinghub.com/setup-android-environment-variables/)
5. Configure Anroid emulator and name it **Demo**[Explain me how](https://developer.android.com/studio/run/managing-avds)
6. Download and install **Node.js**  [Explain me how](https://nodejs.org/en/download/)
7. Configure npm environment variables [Explain me how](https://stackoverflow.com/questions/27864040/fixing-npm-path-in-windows-8-and-10)
8. Download and install **Appium** [Explain me how](http://www.automationtestinghub.com/download-and-install-appium-1-6/)
9. You'll need an IDE. We suggest downloading and installing **Eclipse**. [Explain me how](https://www.eclipse.org/downloads/)
10. Configure **Maven** for Eclipse  [Explain me how](https://www.softwaretestinghelp.com/eclipse/configuring-maven-with-eclipse/)
11. Configure **Cucumber** for Eclipse [Explain me how](https://www.javatpoint.com/install-cucumber-eclipse-plugin)

# Running the project
1. Download the repository [UseMe](https://github.com/WiaN09/Citi/archive/master.zip) and unzip it, ideally in eclipse-workspace . 
2. Make sure the **GeneralStore.apk** present in Automation folder is installed in the emulator.
3. To directly run the tests, open Automation folder and run either of three **.bat** files.
4. To run as a Maven project, first import it  [Explain me how](http://people.cs.uchicago.edu/~kaharris/10200/tutorials/eclipse/import.html)
5. To run, **Automation->src/test/java->runner**. Right click **LogRunTest.java** and select **Run As**, left click **JUnit test**.
