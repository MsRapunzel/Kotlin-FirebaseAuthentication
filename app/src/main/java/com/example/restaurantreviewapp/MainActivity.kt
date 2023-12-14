package com.example.restaurantreviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.restaurantreviewapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class MainActivity : AppCompatActivity() {
    private var firebaseAuth = FirebaseAuth.getInstance()
    private var currentUser = firebaseAuth.currentUser
    private lateinit var binding: ActivityMainBinding
    private lateinit var databaseReference: DatabaseReference
    private lateinit var currentFragment : Fragment

    //UI elements that are reused a lot private late init var

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        update()

        setupBottomAppBar()

        binding.logoutButton.setOnClickListener {
            currentUser = firebaseAuth.currentUser
            firebaseAuth.signOut()
            update()
        }
    }

    private fun setupBottomAppBar() {
        val bottomNavigationView = binding.bottomNavigationView

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.appbar_home -> {
                    Utils.displayMessage(binding.bottomAppBar,
                        getString(R.string.snackbar_home_not_ready))
                    true
                }
                R.id.appbar_feed -> {
                    Utils.displayMessage(binding.bottomAppBar,
                        getString(R.string.snackbar_feed_not_ready))
                    true
                }
                R.id.appbar_collection -> {
                    Utils.displayMessage(binding.bottomAppBar,
                        getString(R.string.snackbar_collection_not_ready))
                    true
                }
                R.id.appbar_profile -> {
                    if (currentUser == null) {
                        val intent = Intent(this, SignUpActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else {
                        Utils.displayMessage(binding.bottomAppBar,
                            getString(R.string.snackbar_profile_not_ready))
                    }
                    true
                }
                else -> false
            }
        }

        binding.floatingActionButton.setOnClickListener {
            Utils.displayMessage(binding.root,
                getString(R.string.snackbar_add_review_button))

            if(currentUser == null) {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun update(){
        if(currentUser == null) {
            binding.greetingView.text = getString(R.string.no_user_email)
        }
        else {
            binding.greetingView.text = getString(R.string.successful_auth, currentUser?.email.toString())
        }
    }
}