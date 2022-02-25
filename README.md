<h1 align="center">Share</h1>

<p align="center">
	    <a href="https://jitpack.io/#akshaaatt/Share-Android">
    <img src="https://jitpack.io/v/akshaaatt/Share-Android.svg?style=flat-square&logo=github&logoColor=white" alt="GitHub issues">
	</a>
	   
</p>
       
---

A `Media` & `Text` Sharing library for Android backed by Kotlin Coroutines. `Share` is: 


- **Fast**: `Share` performs it's operation in `Background Thread` using `Coroutines`.
- **Lightweight**: `Share` adds ~10 methods to your APK (for apps that already uses Coroutines).
- **Easy to use**: `Share's` API leverages Kotlin's language features for simplicity and minimal boilerplate.
- **Modern**: `Share` uses Coroutines.


## Implementation

`Share` is available on `jitpack`.

### Gradle
Add below code to your **root** `build.gradle` file (not your module/app build.gradle file).

```gradle
allprojects {
    repositories {

    ....

	maven { url 'https://jitpack.io' }
	
    }
}
```
And add a dependency code to your **APP**'s `build.gradle` file.
```gradle
dependencies {
   implementation 'com.github.akshaaatt:Share:1.0.0'
}
```

## Usage

### Simple usage 
- Only share the Image
``` kotlin
Share.with(context = this)
            .item(SharableItem(pictureUrl = "ImageUrl"),
                onStart = {},
                onFinish = { isSuccessful, errorMessage -> })
```


- Only share A Text
``` kotlin
Share.with(context = this)
            .item(SharableItem(data = "Text To Share"),
                onStart = {},
                onFinish = { isSuccessful, errorMessage -> })
```

### More Specific Example
``` kotlin

Share.with(context = this).item(SharableItem(
        pictureUrl = "https://images.unsplash.com/photo-1554290712-e640351074bd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=965&q=80",
        failOnDownloadFailing = true,             // default = false
	data = "body text",                       //default = ""
        shareAppLink = false,                    // don't generate appliaction playstore `download our app` message with the data text. default = false
        downloadOurAppMessage = "Find us here"  // A custom message for AppLink sharing feature
    ),

        onStart = {
            // do something onStart like : Loading
            Log.e(TAG, "Sharing Started.")
        },

        onFinish = { isSuccessful: Boolean, errorMessage: String ->

            // if isSuccessful : you will see an intent chooser
            // else            : check the error message

            if (isSuccessful)
                Log.e(TAG, "Successfully shared")
            else
                Log.e(TAG, "error happened : $errorMessage")

        }
    )

```

## Tips
-  if `pictureUrl = "ImageUrl"` is not a `valid` URL you will be sharing only the `data` text.
-  if `failOnDownloadFailing = true` the share process will fail if the image isn't downloaded `else` the process will continue with sharing other inputs.
-  if `downloadOurAppMessage  is provided and `shareAppLink` is false it will be ignored.
