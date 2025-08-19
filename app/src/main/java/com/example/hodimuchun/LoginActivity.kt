package com.example.hodimuchun

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etLogin = findViewById<EditText>(R.id.etLogin)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val ivTogglePassword = findViewById<ImageView>(R.id.ivTogglePassword)

        // Parolni ko‘rsatish/yashirish funksiyasi
        ivTogglePassword.setOnClickListener {
            if (isPasswordVisible) {
                // Parolni yashirish
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.visibility_24dp_1f1f1f_fill0_wght400_grad0_opsz24__1_)
            } else {
                // Parolni ko‘rsatish
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.visibility_off_24dp_1f1f1f_fill0_wght400_grad0_opsz24)
            }
            etPassword.setSelection(etPassword.text.length) // kursor oxirida tursin
            isPasswordVisible = !isPasswordVisible
        }

        // Kirish tugmasi
        btnLogin.setOnClickListener {
            val login = etLogin.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (login == "admin" && password == "admin123") {
                Toast.makeText(this, "Kirish muvaffaqiyatli!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Login yoki parol noto‘g‘ri!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
