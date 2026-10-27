package com.vanlang.kiemtra_laptrinhungdungdidong

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/* ProfileActivity - Shows the account information.
 * Receives the email from LoginActivity through the Intent extras.
 * Views are mapped with findViewById (ViewBinding is NOT used).
 */
class ProfileActivity : AppCompatActivity() {

    private lateinit var tvHeader: TextView
    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSubjects: ListView

    // Sample subjects/skills shown in the ListView
    private val subjects = listOf(
        "Kotlin Programming",
        "XML Layout Design",
        "Git/GitHub Management",
        "Intent Processing",
        "Android Architecture",
        "ListView & ArrayAdapter",
        "Activity Lifecycle"
    )

    companion object {
        // Key for the Intent extra (shared with LoginActivity)
        const val EXTRA_EMAIL = "extra_email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

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
        tvHeader = findViewById(R.id.tvHeader)
        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)

        // Extract the email sent from LoginActivity
        val email = intent.getStringExtra(EXTRA_EMAIL) ?: getString(R.string.unknown_email)
        tvEmail.text = getString(R.string.profile_email, email)

        // Log Out: close this screen and return to LoginActivity
        btnLogout.setOnClickListener { finish() }

        setupSubjectList()
    }

    private fun setupSubjectList() {
        lvSubjects = findViewById(R.id.lvSubjects)

        // ArrayAdapter with the built-in android.R.layout.simple_list_item_1 template
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        lvSubjects.adapter = adapter

        // Show a Toast with the exact name of the selected subject
        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, getString(R.string.toast_selected, subjects[position]), Toast.LENGTH_SHORT).show()
        }
    }
}
