package android.example.com.desafio4_firebase.ui

import android.content.Intent
import android.example.com.desafio4_firebase.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        bCreateAccount.setOnClickListener {
            openMainActivity()
        }

    }

    private fun openMainActivity() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

}