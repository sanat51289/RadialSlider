### RadialSlider
A library that mimics the native Android slider but in a radial fashion.

### Requirements:
1. Android SDK >= 14
1. Android Studio to compile and use

### How to include it?
Add following line under **dependencies** section of module's build.gradle:

` compile 'com.github.sanat51289:radialslider:0.0.1' `

### What does it look like:

![screenshot](https://cloud.githubusercontent.com/assets/5086113/20528365/f42c014c-b099-11e6-87c8-3bfd28e450be.png)


### Sample usage:
```
<san.radialslider.Slider
        slider_attributes:max="100"
        slider_attributes:min="0"
        slider_attributes:stroke_width="12dp"
        slider_attributes:thumb_color="@android:color/holo_blue_light"
        slider_attributes:arc_color="@android:color/holo_blue_light"
        slider_attributes:thumb_reading_text_size="14dp"
        slider_attributes:thumb_radius="16dp"
        slider_attributes:thumb_text_color="@android:color/black"
    />
```

### Notes:
Presently, this library lists appcompat-v7-24.0.0 as dependency.
If that creates a conflict in your project, you can explicitly exclude the download of appcompat by adding the following line:

 ```
 compile ('com.github.sanat51289:radialslider:0.0.1') {
         exclude group: 'com.android.support', module: 'appcompat-v7'
     }
 ```
