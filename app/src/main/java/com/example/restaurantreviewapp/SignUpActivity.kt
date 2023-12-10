package com.example.restaurantreviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.restaurantreviewapp.databinding.ActivitySignUpBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.registerButton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, LogInActivity::class.java)
                            startActivity(intent)
                        } else {
                            displayMessage(
                                binding.registerButton,
                                getString(R.string.register_failure)
                            )
                        }
                    }
            } else {
                displayMessage(binding.registerButton, getString(R.string.login_failure))
            }
        }
        binding.loginRedirectButton.setOnClickListener {
            displayMessage(binding.loginRedirectButton, getString(R.string.test))
            val loginIntent = Intent(this, LogInActivity::class.java)
            startActivity(loginIntent)
        }
    }

    private fun displayMessage(view: View, msgText: String) {
        val sb = Snackbar.make(view, msgText, Snackbar.LENGTH_SHORT)
        sb.show()
    }
}

// package com.example.restaurantreviewapp
//
// import android.content.Intent
// import androidx.appcompat.app.AppCompatActivity
// import android.os.Bundle
// import android.widget.Toast
// import com.example.restaurantreviewapp.databinding.ActivitySignUpBinding
// import com.google.firebase.auth.FirebaseAuth
//
// class SignupActivity : AppCompatActivity() {
//
// private lateinit var binding: ActivitySignUpBinding
// private lateinit var firebaseAuth: FirebaseAuth
//
// override fun onCreate(savedInstanceState: Bundle?) {
// super.onCreate(savedInstanceState)
// binding = ActivitySignUpBinding.inflate(layoutInflater)
// setContentView(binding.root)
//
// firebaseAuth = FirebaseAuth.getInstance()
//
// binding.registerButton.setOnClickListener {
// val email = binding.emailInput.text.toString()
// val password = binding.passwordInput.text.toString()
//
// if (email.isNotEmpty() && password.isNotEmpty()) {
//
// firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
// if (it.isSuccessful) {
// val intent = Intent(this, LogInActivity::class.java)
// startActivity(intent)
// } else {
// Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
// }
// }
// } else {
// Toast.makeText(this, "Password does not matched", Toast.LENGTH_SHORT).show()
// }
// }
// binding.loginRedirectText.setOnClickListener {
// val loginIntent = Intent(this, LogInActivity::class.java)
// startActivity(loginIntent)
// }
// }
// }