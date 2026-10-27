package com.vanlang.kiemtra_laptrinhungdungdidong

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/* LoginActivity - Login screen with input validation.
 * Views are mapped with findViewById (ViewBinding is NOT used).
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    companion object {
        private const val MIN_PASSWORD_LENGTH = 6
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Edge-to-edge: keep the content inside the system bars
        val root = findViewById<View>(R.id.main)
        val basePadding = root.paddingTop
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left + basePadding,
                systemBars.top + basePadding,
                systemBars.right + basePadding,
                systemBars.bottom + basePadding
            )
            insets
        }

        // Map the views from XML with findViewById
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener { validateInput() }
    }

    private fun validateInput() {
        val email = edtEmail.text.toString().trim()
        val password = edtPassword.text.toString()

        when {
            // 1. Blank Email and/or Password
            email.isEmpty() && password.isEmpty() -> showError(R.string.error_both_empty)
            email.isEmpty() -> showError(R.string.error_email_empty)
            password.isEmpty() -> showError(R.string.error_password_empty)

            // 2. Wrong email format or password too short
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> showError(R.string.error_email_format)
            password.length < MIN_PASSWORD_LENGTH -> showError(R.string.error_password_length)

            // 3. Completely valid data
            else -> onValidationSuccess()
        }
    }

    private fun showError(@StringRes messageRes: Int) {
        tvStatus.setTextColor(ContextCompat.getColor(this, R.color.status_error))
        tvStatus.setText(messageRes)
    }

    private fun onValidationSuccess() {
        tvStatus.setTextColor(ContextCompat.getColor(this, R.color.status_success))
        tvStatus.setText(R.string.validation_success)
    }
}
