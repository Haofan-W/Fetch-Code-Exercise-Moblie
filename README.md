# Fetch-Code-Exercise-Moblie

## Overview
This is a simple Android application written in Kotlin that retrieves and displays a list of items from a remote JSON API. The app groups the items by "listId," sorts the results by "listId" and then by "name," and filters out items with blank or null names.

## Features
Fetches data from https://fetch-hiring.s3.amazonaws.com/hiring.json

Display this list of items to the user based on the following requirements:

Markup : *Display all the items grouped by "listId"
         *Sort the results first by "listId" then by "name" when displaying.
         *Filter out any items where "name" is blank or null.
 Markup : * Bullet list
              * Nested bullet
                  * Sub-nested bullet etc
          * Bullet list item 2

The final result should be displayed to the user in an easy-to-read list.

## Dependencies
Kotlin Coroutines: Used for handling asynchronous operations.
AndroidX: Used for modern Android development components.
Getting Started
1. Clone the repository: ```git clone https://github.com/yourusername/ItemListApp.git```
2. Open the project in Android Studio.
3. Build and run the app on an Android emulator or device.
