package com.example.library2

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.net.Uri
import android.os.Build
import android.util.Base64
import android.util.TypedValue
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.library2.databinding.ViewAlertDialogBinding
import com.example.library2.databinding.ViewLoadingDialogBinding
import com.google.android.material.snackbar.Snackbar
import java.io.ByteArrayOutputStream
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.Locale
import kotlin.math.roundToInt


fun View.hide() = apply {
    visibility = View.GONE
}

fun View.invisible() = apply {
    visibility = View.INVISIBLE
}

fun View.show() = apply {
    visibility = View.VISIBLE
}

fun View.disable() = apply {
    isEnabled = false
}

fun View.enable() = apply {
    isEnabled = true
}


fun Activity.showSnackBar(message: String) {
    Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).apply {
        /*setAction(R.string.button_dismiss) {
            dismiss()
        }*/
    }.show()
}

fun Fragment.showSnackBar(message: String) {
    Snackbar.make(view!!, message, Snackbar.LENGTH_LONG).apply {
        /*setAction(R.string.button_dismiss) {
            dismiss()
        }*/
    }.show()
}

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(context, message, duration).show()
}

fun Fragment.askForLocationPermissions(
    onPreciseGranted: (() -> Unit)? = null,
    onApproximateGranted: (() -> Unit)? = null,
    onDeny: (() -> Unit)? = null
) {
    val locationPermissionRequest: ActivityResultLauncher<Array<String>> = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions: Map<String, Boolean> ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                // Precise location access granted.
                onPreciseGranted?.invoke()
            }

            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                // Only approximate location access granted.
                onPreciseGranted?.invoke()
            }

            else -> {
                onDeny?.invoke()
            }
        }
    }

    locationPermissionRequest.launch(
        arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )
}

fun Fragment.isLocationPermissionsGranted() = ActivityCompat.checkSelfPermission(
    activity!!,
    Manifest.permission.ACCESS_FINE_LOCATION
) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
    activity!!,
    Manifest.permission.ACCESS_COARSE_LOCATION
) == PackageManager.PERMISSION_GRANTED

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun View.background(drawableId: Int) = apply {
    background = ContextCompat.getDrawable(context, drawableId)
}

fun String.hash(): String {
    val digest: MessageDigest

    try {
        digest = MessageDigest.getInstance("SHA-256")
    } catch (e: NoSuchAlgorithmException) {
        throw IllegalArgumentException(e)
    }

    val encodedHash = digest.digest(
        this.toByteArray()
    )

    return encodedHash.bytesToHex()
}

fun ByteArray.bytesToHex(): String {
    val hexString = StringBuilder(2 * this.size)
    this.indices.forEach {
        val hex = Integer.toHexString(0xff and this[it].toInt())
        if (hex.length == 1) {
            hexString.append(0)
        }
        hexString.append(hex)
    }

    return hexString.toString()
}

fun Fragment.getColor(@ColorRes id: Int): Int {
    return resources.getColor(id, null)
}

val Number.toPx
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )

val Number.toRoundedPx
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).roundToInt()

fun <T> MutableList<T>.addIf(element: T, condition: () -> Boolean) {
    if (condition()) {
        add(element)
    }
}

fun <T> MutableList<T>.addAllIf(element: List<T>, condition: () -> Boolean) {
    if (condition()) {
        addAll(element)
    }
}

fun View.fadeIn() {
    alpha = 0f
    animate().alpha(1f).setInterpolator(AccelerateDecelerateInterpolator()).duration = 300
}

fun View.fadeOut() {
    animate().alpha(0f).setInterpolator(AccelerateDecelerateInterpolator()).duration = 300
}

inline fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

inline fun <T1 : Any, T2 : Any, T3 : Any, R : Any> safeLet(
    p1: T1?,
    p2: T2?,
    p3: T3?,
    block: (T1, T2, T3) -> R?
): R? {
    return if (p1 != null && p2 != null && p3 != null) block(p1, p2, p3) else null
}

fun Int.roundedToHundred(): Int {
    return ((this + 99) / 100) * 100
}


fun Context.setAppLocale(language: String): Context {
    val locale = Locale(language)
    Locale.setDefault(locale)
    val config = resources.configuration
    config.setLocale(locale)
    config.setLayoutDirection(locale)
    return createConfigurationContext(config)
}

fun String.convertNumbersBaseOnDeviceLanguage(): String {
    return if (Locale.getDefault().language == "ar") {
        this.replace("٠", "0")
            .replace("١", "1")
            .replace("٢", "2")
            .replace("٣", "3")
            .replace("٤", "4")
            .replace("٥", "5")
            .replace("٦", "6")
            .replace("٧", "7")
            .replace("٨", "8")
            .replace("٩", "9")
    } else {
        this
    }
}


fun String.reverseDateToArabicDirection(): String {
    val day = substring(0, 2)
    val month = substring(3, 5)
    val year = substring(6, 10)
    return ("$year/$month/$day")
}


fun String.isSixOrEightCharacters(): Boolean {
    return length == 6 || length == 8
}

fun String.toBitmap(): Bitmap? {
    val bytes = Base64.decode(this, BitmapBase64Flags)

    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}


fun TextView.setTextColor(color: Long) = this.setTextColor(color.toInt())

private const val BitmapBase64Flags = Base64.NO_PADDING or Base64.NO_WRAP
fun Bitmap.toBase64(): String =
    Base64.encodeToString(compress(), BitmapBase64Flags)

fun Bitmap.compress(): ByteArray {
    val outputStream = ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
    val byteArray = outputStream.toByteArray()
    val options = BitmapFactory.Options().apply { inSampleSize = 2 }

    while (byteArray.size / 1024 > 200) {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size, options).compress()
    }

    return byteArray
}

private var loadingDialog: AlertDialog? = null
private var isLoading: Boolean = false

fun Fragment.showLoading(
    title: String = getString(R.string.loading),
) {
    val viewAlertView = ViewLoadingDialogBinding.inflate(layoutInflater)
    viewAlertView.titleTextView.text = title
    if (title.isBlank()) {
        viewAlertView.titleTextView.hide()
    }

    loadingDialog = AlertDialog.Builder(requireContext())
        .setView(viewAlertView.root)
        .setCancelable(false)
        .show()

    loadingDialog?.window?.setBackgroundDrawableResource(R.color.transparent)

    isLoading = true
}

fun Fragment.dismissLoading() {
    loadingDialog?.dismiss()

    isLoading = false
}


enum class AlertType {
    Success,
    Error,
    Information,
    Warning
}
fun Fragment.showAlert(
    alertType: AlertType,
    title: String,
    content: String? = null,
    primaryButtonText: String = "Dismiss",
    primaryButtonOnClickListener: (() -> Unit)? = null,
    secondaryButtonText: String? = null,
    secondaryButtonOnClickListener: (() -> Unit?)? = null,
    onDismiss: (() -> Unit)? = null
) {
    val viewAlertView = ViewAlertDialogBinding.inflate(layoutInflater)
    val alertIcon: Int = when (alertType) {
        AlertType.Success -> R.drawable.alert_success
        AlertType.Error -> R.drawable.alert_error
        AlertType.Information -> R.drawable.alert
        AlertType.Warning -> R.drawable.alert_triangle
    }

    viewAlertView.alertIconImageView.setImageResource(alertIcon)
    viewAlertView.titleTextView.text = title

    content?.let {
        viewAlertView.contentTextView.apply {
            text = it
            show()
        }
    }

    viewAlertView.primaryButton.text = primaryButtonText

    secondaryButtonText?.let {
        viewAlertView.secondaryButton.apply {
            text = it
            show()
        }
    }

    val dialog = AlertDialog.Builder(requireContext())
        .setView(viewAlertView.root)
        .setCancelable(false)
        .setOnDismissListener {
            onDismiss?.invoke()
        }
        .show()

    dialog.window?.setBackgroundDrawableResource(R.color.transparent)

    viewAlertView.primaryButton.setOnClickListener {
        primaryButtonOnClickListener?.invoke()
        dialog.dismiss()
    }

    viewAlertView.secondaryButton.setOnClickListener {
        secondaryButtonOnClickListener?.invoke()
        dialog.dismiss()
    }
}
fun Uri.toBitmap(context: Context): Bitmap? {
    try {
        val inputStream = context.contentResolver.openInputStream(this)
        return BitmapFactory.decodeStream(inputStream)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return null
}
