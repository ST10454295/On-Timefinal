# On-Time

On-Time is a Time management Android app for students who need to balance academic work,
chores and personal activities in one place. Each activity gets a High,
Medium or Low importance level, and the app warns you when a new activity
overlaps an existing one so you can decide what to move.

I built this for students who value time but it works perfectly fine for people who are not students. as long as you've errands and plans , this app is for you.

## Features

| Requirement | How it is done in On-Time |
|---|---|
| Register and log in | Firebase Authentication (email and password). Firebase hashes and stores the password, so it is never saved in plain text. |
| Single sign-on (SSO) | "Continue with Google" on the Login screen, linked to the same Firebase account system. |
| Settings | Default activity duration, theme (light/dark), language, and reminder preferences. Saved on the phone and to the hosted database. |
| REST API and hosted database | The app calls the Firestore REST API with Retrofit, using the user's Firebase ID token for authorisation. |
| Offline mode with sync | Activities and settings are stored in a local Room database first. Changes made offline are uploaded automatically when the connection returns. |
| Real-time notifications | Firebase Cloud Messaging for push notifications, plus a local reminder before each activity starts. |
| Multi-language | English (default), isiZulu and isiXhosa, selectable in Settings. |

Other screens: Splash, Dashboard (today's activities and sync status),
Add Activity, Calendar.

### Add Activity and the conflict check
Each activity has a title, description, type (Assignment, Test, Practical,
Studying, Cleaning, Shopping, Exercise, Family activity, Social activity,
Personal appointment, Entertainment, Other), date, start and end time, and
an importance level. When you save, the app checks the new activity against
the others on the same day. If they overlap, it tells you the importance of
the clash and lets you change the time or save anyway. The check runs against
the local copy, so it also works offline.

## How it works

- **Offline-first:** every read and write goes through Room. After a save,
  `SyncManager` uploads anything marked PENDING to Firestore, then downloads
  anything new from the server. The same sync runs when a screen opens and
  whenever the phone reconnects to a network.
- **REST:** Retrofit calls the Firestore REST endpoints directly
  (create, list, get and set document).
- **Languages:** separate string files (`values`, `values-zu`, `values-xh`).
  The language is switched with Android's per-app locale support.
- **Logging:** key actions (login, register, saving, conflict checks, sync,
  notifications) are logged to Logcat.

## Change from the planning document

The planning document specified a PHP REST API with MySQL, hosted on
InfinityFree. I used Firebase (Authentication and Firestore) instead, called
through its REST endpoints. This still meets the requirement of RESTful calls
to a database hosted on the internet, and it let me deliver SSO, hosted
authentication and push notifications reliably in the time available.i also changed the colours of the app, as it was pink aswell as the logo. 
i changed it to a more settled colour .

## Tech used

Kotlin, Android Studio, Gradle 8.5, Retrofit and Gson, Room, Firebase
Authentication, Cloud Firestore (REST), Firebase Cloud Messaging, Google
Sign-In, Material Components.



## Trying the main features

- **Offline sync:** turn on airplane mode, add an activity, and check the
  Dashboard shows it as waiting to sync. Turn airplane mode off and it
  uploads automatically. Check the new document in the Firestore console.
- **Push notification:** Settings > Copy my push token, then in the Firebase
  console go to Cloud Messaging > Send test message and paste the token.
  Settings > Send test notification shows a local notification.
- **Language:** Settings > choose a language > Save.
- **SSO:** Login screen > Continue with Google.


## Known limitations

- Reminders scheduled by the app are not rescheduled after the phone restarts.
- Offline sync covers activities and settings. Registration and login need a
  connection.
- Activities can be added but not yet edited or deleted in the app.
- The isiZulu and isiXhosa text 

## YOUTUBE LINK BELOW
https://youtu.be/riDrMaCBGzA?feature=shared


