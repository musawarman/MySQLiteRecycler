package com.aurumsystem.mysqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class UpdateActivity : AppCompatActivity() {
    companion object{
        const val Nama = "nama"
        const val Age = "age"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        val btnCancel: MaterialButton = findViewById(R.id.btnCancel)
        val tiName: TextInputLayout = findViewById(R.id.tiName)
        val tiAge: TextInputLayout = findViewById(R.id.tiAge)
        val btnUpdate: MaterialButton = findViewById(R.id.btnUpdate)
        val nama = intent.getStringExtra(Nama);
        tiName.editText?.setText(nama)
        val db = DBHelper(this, null)

        val age = intent.getStringExtra(Age);
        tiAge.editText?.setText(age)



        btnCancel.setOnClickListener {
            finish()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnUpdate.setOnClickListener {
            db.updateData(tiName.editText?.text?.trim().toString(), tiAge.editText?.text?.trim().toString().toInt())

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}