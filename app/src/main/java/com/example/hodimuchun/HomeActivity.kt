package com.example.hodimuchun

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)

        val menuIcon = findViewById<ImageView>(R.id.menuIcon)
        val notificationIcon = findViewById<ImageView>(R.id.notificationIcon)
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)

        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(navigationView)
        }

        notificationIcon.setOnClickListener {
            val intent = Intent(this, MessageActivity::class.java)
            startActivity(intent)
        }

        profileIcon.setOnClickListener {
            val popup = PopupMenu(this, profileIcon)
            popup.menu.add("Profil")
            popup.menu.add("Chiqish")

            popup.setOnMenuItemClickListener { item: MenuItem ->
                when (item.title) {
                    "Profil" -> startActivity(Intent(this, ProfileActivity::class.java))
                    "Barcha" -> startActivity(Intent(this, AllDataActivity::class.java))
                    "Chiqish" -> {
                        val intent = Intent(this, LoginActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                }
                true
            }
            popup.show()
        }

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_tasks -> startActivity(Intent(this, TasksActivity::class.java))
                R.id.nav_grades -> startActivity(Intent(this, GradesActivity::class.java))
            }
            drawerLayout.closeDrawers()
            true
        }
    }
} 
