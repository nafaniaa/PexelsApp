# PexelsApp

PexelsApp is an Android application that uses the Pexels API to fetch and display a collection of photos. 

###Technology stack

## Features (on development stage)

- Fetch and display photos from the Pexels API.
- Bookmark favorite photos.
- Search for photos.
- Light and Dark themes support.
- Network Observer


## Dependencies 
```kotlin
 // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.navigation:navigation-fragment:2.7.7")

    // Hilt
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    implementation("com.google.dagger:hilt-android:2.49")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Room dependencies
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    // Coil
    implementation("io.coil-kt:coil:2.7.0")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")

    implementation("com.google.android.material:material:1.12.0")

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-compose:1.9.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

hilt {
    enableAggregatingTask = true
}
```

### Prerequisites

- Android Studio Bumblebee or later
- Gradle 7.0 or later
- Kotlin 1.5 or later

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/nafaniaa/PexelsApp.git
    ```

2. Open the project in Android Studio.

3. Build the project to download all dependencies.

4. Get your Pexels API key from [Pexels API](https://www.pexels.com/api/).

5. Add your Pexels API key to `local.properties`:

    ```
    PEXELS_API_KEY=cdxZ4nNCpse0YXKgTwUCAviD7H1xrGiIlMM5xfw2SxsjBegiQ5MlHWz1
    ```

### Usage

Run the application on your Android device or emulator.


###Architecture
- app
  - build
  - src
    - androidTest
    - main
      - java
        - com
          - example
            - pexelsapp
              -custom
                - CustomNetworkStatusView
              - data
                - local
                  - dao
                    - PhotoDao
                  - entities
                    - Photo
                  - database
                    - AppDatabase
                - remote
                  - dto
                     - PexelsResponseDto
                     - PhotoDto
                     - SrcDto
                  -AuthInterceptor
                  -PexelsApi
                  -RetrofitInstance      
              - mappers
              - repositories
           - domain
                - models
                  - PhotoModel
                - usecases
                  - DeletePhotoUseCase
                  - GetAllPhotosUseCase
                  - GetPhotoByIdUseCase
                  - GetPhotosUseCase
                  - InsertPhotoUseCase
                  - UpdatePhotoUseCase
          - presentation
                - activities
                  - SplashActivity
                - adapters
                  - PhotoAdapter
                  - PhotosDiffCallback
                  - PopularPhotoAdapter
                - fragments
                  - HomeFragment
           - ui
                  - theme
                  - viewModels
                    - HomeViewModel
                    - PhotoViewModel
                    - SplashViewModel
           - di
                  - AppModule
                  - DatabaseModule
           - util
                  -NetworkObserver
           - MainActivity
           - PexelsApplication
- res
  - drawable
  - layout
    - activity_splash.xml
    - custom_network_status_view.xml
    - fragment_home.xml
    - item_photo.xml
    - main_activity.xml
  - navigation
    - nav_graph.xml
  - layout-navexposed-nonav
  - mipmap-anydpi-v26
  - mipmap-hdpi
  - mipmap-mdpi
  - mipmap-xhdpi
  - mipmap-xxhdpi
  - mipmap-xxxhdpi
- values
  -colors.xml
  -image_style.xml
  -strings.xml
  -themes.xml
  - navigation
    - nav_graph.xml
  - values
  - values-night
  - values-notnight
