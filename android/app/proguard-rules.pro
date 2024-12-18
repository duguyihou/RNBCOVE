# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /usr/local/Cellar/android-sdk/24.3.3/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# Brightcove exoplayer
# @url https://github.com/BrightcoveOS/android-player-samples/blob/master/proguard-project.txt

# These classes use some Android closed captioning hidden APIs, so don't warn on them.
-dontwarn com.brightcove.player.display.VideoDisplayComponent
-dontwarn com.brightcove.player.view.BrightcoveClosedCaptioningSurfaceView
-dontwarn com.brightcove.player.view.BrightcoveClosedCaptioningSurfaceView$1
-dontwarn com.google.**
-dontwarn tv.freewheel.**
-dontwarn com.adobe.**
-dontwarn com.squareup.okhttp.**
-dontwarn io.requery.android.**
-dontwarn android.media.**

# These classes aren't used in the Brightcove Android SDK.
-dontwarn io.requery.android.QueryLoader
-dontwarn io.requery.android.QueryRecyclerAdapter

-keep class com.brightcove.** { *; }

-keep public class com.brightcove.player.** {
    public *;
}
-keepclassmembers public class com.brightcove.player.** {
    public *;
}
-keepclasseswithmembers public class com.brightcove.player.** {
    public *;
}
-keep class com.brightcove.iab.** { *; }
-keep class com.google.** { *; }
-keep interface com.google.** { *; }
-keep class com.google.ads.interactivemedia.** { *; }
-keep interface com.google.ads.interactivemedia.** { *; }