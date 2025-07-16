package com.example.devicefingerprint;

import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.provider.Settings
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.security.MessageDigest
import java.util.Locale
import java.util.TimeZone

class MainActivity : AppCompatActivity() {
    private var deviceInfoTextView: TextView? = null

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        deviceInfoTextView = findViewById(R.id.deviceInfoTextView)
        displayDeviceFingerprint()
    }


    ///// Android Studio warning:
    //“Using these device identifiers is not recommended other than for high value fraud prevention and advanced telephony use-cases.”
    // Otherwise, Google may reject your app from the Play Store if you misuse it.

    private fun displayDeviceFingerprint() {
        val androidId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        val locale = Locale.getDefault().toString()
        val timezone = TimeZone.getDefault().id

        val metrics = resources.displayMetrics
        val screenWidth = metrics.widthPixels
        val screenHeight = metrics.heightPixels
        val screenDensity = metrics.densityDpi

        val supportedAbis = Build.SUPPORTED_ABIS.joinToString()
        val packageInfo = packageManager.getPackageInfo(packageName, 0)
        val versionName = packageInfo.versionName
        val versionCode = packageInfo.longVersionCode

        val uptime = SystemClock.uptimeMillis()
        val bootTime = System.currentTimeMillis() - SystemClock.elapsedRealtime()

        // Combine values for hashing
        val rawFingerprint = listOf(
            androidId,
            Build.FINGERPRINT,
            Build.BRAND,
            Build.MODEL,
            Build.MANUFACTURER,
            Build.HARDWARE,
            Build.BOARD,
            Build.BOOTLOADER,
            Build.VERSION.SDK_INT.toString(),
            Build.VERSION.RELEASE,
            locale,
            timezone,
            "$screenWidth x $screenHeight",
            screenDensity.toString(),
            supportedAbis,
            versionName,
            versionCode.toString(),
            uptime.toString(),
            bootTime.toString()
        ).joinToString("|")

        val hashedFingerprint = sha256(rawFingerprint)

        val info = """
        Android ID: $androidId
        Build Fingerprint: ${Build.FINGERPRINT}
        Brand: ${Build.BRAND}
        Manufacturer: ${Build.MANUFACTURER}
        Model: ${Build.MODEL}
        Hardware: ${Build.HARDWARE}
        Board: ${Build.BOARD}
        Bootloader: ${Build.BOOTLOADER}
        SDK Version: ${Build.VERSION.SDK_INT}
        Android Version: ${Build.VERSION.RELEASE}
        Locale: $locale
        Timezone: $timezone
        Screen: ${screenWidth}x$screenHeight @ ${screenDensity}dpi
        Supported ABIs: $supportedAbis
        App Version: $versionName ($versionCode)
        Uptime (ms): $uptime
        Boot Time (ms since epoch): $bootTime
        
        🔐 SHA-256 Fingerprint Hash:
        $hashedFingerprint
    """.trimIndent()

        deviceInfoTextView?.text = info
    }
    fun sha256(input: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(input.toByteArray(Charsets.UTF_8))
        return hashBytes.joinToString("") { "%02x".format(it) }
    }

}