package com.example.library2.raywanderlish.stateflow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library2.raywanderlish.model.PhoneNumber
import com.example.library2.raywanderlish.model.Session
import com.example.library2.raywanderlish.utils.getEmailPrefix
import com.example.library2.raywanderlish.utils.isValidEmail
import kotlinx.coroutines.flow.*
import java.util.*

private const val DEFAULT_FIRST_NAME = ""
private const val DEFAULT_LAST_NAME = ""
private const val DEFAULT_EMAIL = ""
private const val DEFAULT_SHOW_USERNAME = false
private const val DEFAULT_USERNAME = ""
private const val DEFAULT_ENABLE_REGISTRATION = false
private const val TAG = "StateFlow-ViewModel"

/**
 * This means that, for example, as the user updates their first name on the registration form, the value of firstName updates at the same time. The opposite is also valid:
 * If firstName‘s value changes, it’s reflected in the UI. This is called two-way binding.
Omitting the = sign and only writing @{viewmodel.firstName} makes it a one-way binding instead, going from the firstName field to the UI.
This means that as the user updates the first name on the registration form, firstName‘s value remains the same.


 */
class MainViewModel : ViewModel() {
    val firstName = MutableStateFlow(DEFAULT_FIRST_NAME)
    val lastName = MutableStateFlow(DEFAULT_LAST_NAME)
    val email = MutableStateFlow(DEFAULT_EMAIL)
    val sessions = MutableStateFlow<EnumMap<Session, Boolean>>(EnumMap(Session::class.java)).apply {
        Session.values().forEach { value[it] = false }
    }

    val showUsername: StateFlow<Boolean> =
        email.mapToStateFlow(::isValidEmail, DEFAULT_SHOW_USERNAME)
    val username: StateFlow<String> =
        email.mapToStateFlow(::generateUsername, DEFAULT_USERNAME)

    val enableRegistration: StateFlow<Boolean> = combine(firstName, lastName, email) { _ ->
        isUserInformationValid()
    }.toStateFlow(DEFAULT_ENABLE_REGISTRATION)

    val phoneNumber = PhoneNumber()
    private val _showRegistrationSuccessDialog = MutableStateFlow(false)
    val showRegistrationSuccessDialog: StateFlow<Boolean>
        get() = _showRegistrationSuccessDialog

    /**
     * Callback that's fired when the registration button is clicked.
     * Check out the logs (in Logcat) to see a dump of the user's information.
     */
    fun onRegisterClicked() {
        _showRegistrationSuccessDialog.value = true
        Log.d(TAG, getUserInformation())
    }

    /** Generates a random username from the user's email address. */
    private fun generateUsername(email: String): String {
        val prefix = getEmailPrefix(email)
        val suffix = prefix.length
        return "$prefix$suffix".toLowerCase()
    }

    /**
     * Returns true if the user's mandatory information is valid, false otherwise.
     * The mandatory user information includes their first name, last name and email address.
     * Everything else is optional.
     */
    private fun isUserInformationValid(): Boolean {
        return !firstName.value.isNullOrBlank()
                && !lastName.value.isNullOrBlank()
                && isValidEmail(email.value)
    }

    private fun getUserInformation(): String {
        return "User information:\n" +
                "First name: ${firstName.value}\n" +
                "Last name: ${lastName.value}\n" +
                "Email: ${email.value}\n" +
                "Username: ${username.value}\n" +
                "Phone number: ${phoneNumber.areaCode}-${phoneNumber.number}\n" +
                "Sessions: ${sessions.value}\n"
    }


    /** Convenience method to transform a [Flow] to a [StateFlow]. */
    private fun <T> Flow<T>.toStateFlow(initialValue: T): StateFlow<T> {
        return this.stateIn(viewModelScope, SharingStarted.Lazily, initialValue)
    }

    /** Convenience method to map output from a [Flow] and transform it to a [StateFlow]. */
    private fun <T, U> StateFlow<T>.mapToStateFlow(
        mapper: (value: T) -> U,
        initialValue: U
    ): StateFlow<U> {
        return this.map { mapper(it) }.toStateFlow(initialValue)
    }
}
