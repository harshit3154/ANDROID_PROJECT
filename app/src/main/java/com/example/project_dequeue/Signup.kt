package com.example.project_dequeue

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.concurrent.fixedRateTimer

class Signup : Fragment() {

    lateinit var views:View
    lateinit var button:Button
    lateinit var name:TextView
    lateinit var email:TextView

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        views=inflater.inflate(R.layout.fragment_signup, container, false)

        button=views.findViewById(R.id.submit)
        button.setOnClickListener(){
            name=views.findViewById(R.id.name)
            email=views.findViewById(R.id.email)
            if(name.text.isEmpty() && email.text.isEmpty()) {
                Toast.makeText(context, "Empty username & email can't create account", Toast.LENGTH_SHORT).show()
            }else if(name.text.isEmpty()){
                Toast.makeText(context,"Empty user name",Toast.LENGTH_SHORT).show()
            }else if(email.text.isEmpty()){
                Toast.makeText(context,"Empty email field",Toast.LENGTH_SHORT).show()
            }
            else {
                var activity_main:MainActivity=activity as MainActivity
                activity_main.save(name.text.toString(),email.text.toString())
                Toast.makeText(context,"Your account has been created successfully.",Toast.LENGTH_SHORT).show()
                val first_screen = LoginPage()
                    fragmentManager?.beginTransaction()?.replace(R.id.signupscreen, first_screen)?.commit()
            }
        }
        return views
    }
}