package com.example.project_dequeue

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_dequeue.R.id.appbar

class MainActivity : AppCompatActivity() {

    lateinit var s_p: SharedPreferences
    lateinit var toolbar:Toolbar
    val file_name = "MyPref"
    val name_key = "NAME"
    val email_key = "EMAIL"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        toolbar=findViewById(appbar)
        toolbar.setTitle("Dequeu")
        setActionBar(toolbar)
        toolbar.setOnClickListener(){

        }
        supportFragmentManager.beginTransaction().replace(R.id.main1,ItemList()).commit()
//        if(login()){
//            val firstScreen=LoginPage()
//            supportFragmentManager.beginTransaction().replace(R.id.main1,firstScreen)
//        }else{
//            val first_screen = FirstScreen()
//            supportFragmentManager.beginTransaction().replace(R.id.main1, first_screen).commit()
//        }

    }
    fun save(name: String, email: String) {
        s_p = getSharedPreferences(file_name, MODE_PRIVATE)
        val editor = s_p.edit()
        editor.putString(name_key, name
        )
        editor.putString(email_key, email)
        editor.apply()
    }

    fun login():Boolean{
        s_p=getSharedPreferences(file_name, MODE_PRIVATE)
        val editor=s_p.edit()
        val n=s_p.getString(name_key,"")
        val e=s_p.getString(email_key,"")
        System.out.println(n.toString()+e.toString())
        if(e.toString().isNotEmpty() && n.toString().isNotEmpty())
            return true
        return false
    }

    fun verify(name:String,email:String):Boolean{

        s_p=getSharedPreferences(file_name, Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor=s_p.edit()
        val n=s_p.getString(name_key,"")
        val e=s_p.getString(email_key,"")

        if(e.toString().equals(email) && n.toString().equals(name) && name.toString().isNotEmpty() && email.toString().isNotEmpty())
            return true
        return false
    }
    fun show() {
        s_p = getSharedPreferences(file_name, MODE_PRIVATE)
        val editor = s_p.edit()
        var n:String= s_p.getString(name_key, "").toString()
        var e:String= s_p.getString(email_key, "").toString()
    }

    fun delete_info() {
        s_p = getSharedPreferences(file_name, MODE_PRIVATE)
        val editor = s_p.edit()
        editor.remove(name_key)
        editor.remove(email_key)
        editor.apply()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.action_settings) {
            Toast.makeText(applicationContext, "Settings Menu", Toast.LENGTH_LONG).show()
            return true
        } else if (id == R.id.action_email) {
            Toast.makeText(applicationContext, "Email", Toast.LENGTH_LONG).show()
            return true
        } else if (id == R.id.action_add) {
            Toast.makeText(applicationContext, "Add", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}