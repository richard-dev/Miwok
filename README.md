# Miwok
Miwok project from Udacity.

My project differs slightly from Udacity in that I use one LoadActivity.java file instead of four separate activities java files for Numbers, Family Members, Colors and Phrases. With the use of intent passed from MainActivity, LoadActivity will display the correct activity with switch statements.

This project utilizies these concepts:

-ArrayAdapters

Load ListView with list items using custom ArrayAdapter that uses custom ArrayList.

-ArrayLists

create custom ArrayLists to accept more than one parameter.

-ListViews

-setOnItemClickListener

releaes MediaPlayer resources so that the app doesn't keep starting a new MediaPlayer and overlap.

-MediaPlayer

play audio files.

-AudioManager

request audio focus before playback.

handle different audio states like what happens when Miwok app is interrupted by other audio sources.

-App Lifecycle

onStop(); 
release MediaPlayer.
