# EnablonInstaPic
Simple application displaying Instagram pictures from a specific account.
Made with IntelliJ Community.

# Architecture
The application is using a MVVM architecture, based on a single model InstaPic. 
The repository retrieves the information about the specific account from the Instagram APIs through a Retrofit class. 

# Used for debugging
// http loging interceptor
implementation 'com.squareup.okhttp3:logging-interceptor:3.12.1'
