# Fetch-Code-Exercise-Moblie

## Overview
This is a simple Android application written in Kotlin that retrieves and displays a list of items from a remote JSON API. The app groups the items by "listId," sorts the results by "listId" and then by "name," and filters out items with blank or null names.

## Features
Fetches data from https://fetch-hiring.s3.amazonaws.com/hiring.json

Display this list of items to the user based on the following requirements:

* Display all the items grouped by "listId"
* Sort the results first by "listId" then by "name" when displaying.
* Filter out any items where "name" is blank or null.

The final result should be displayed to the user in an easy-to-read list.

## Dependencies
Kotlin Coroutines: Used for handling asynchronous operations. <br>
AndroidX: Used for modern Android development components. <br><br>
Getting Started:
1. Clone the repository: ```https://github.com/Haofan-W/Fetch-Code-Exercise-Moblie.git```
2. Open the project in Android Studio.
3. Build and run the app on an Android emulator or device.

## Note
Most of the code simples are at app/src/androidTest/java/com/example/fetch_rewards_coding_exercise <br>
Unit test locate at app/src/test/java/com/example/fetch_rewards_coding_exercise <br>
basic listview frontend locate at app/src/main/res/layout/activity_main.xml

## If I have more time
I will move the sorting operation to the background so that it doesn't block the main thread. Since this API have very little data, I think running on the main thread should be fine. If the information gets larger, my plan is to display the items unsorted, then create a sort button, when the user click the sort button, a loading icon should appear until the sorting is complete.
