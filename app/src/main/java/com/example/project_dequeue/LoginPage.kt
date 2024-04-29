package com.example.project_dequeue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class LoginPage : Fragment() {

    lateinit var viewl:View
    lateinit var name:TextView
    lateinit var email:TextView
    lateinit var button:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewl = inflater.inflate(R.layout.fragment_login_page, container, false)

        button=viewl.findViewById(R.id.lsubmit)
        button.setOnClickListener() {
            name = viewl.findViewById(R.id.lname)
            email = viewl.findViewById(R.id.lemail)
            var mainActivity: MainActivity = activity as MainActivity
            if (mainActivity.verify(name.text.toString(), email.text.toString())) {
                val first_screen = user_interface()
                fragmentManager?.beginTransaction()?.replace(R.id.signupscreen, first_screen)?.commit()
            } else {
                Toast.makeText(context, "Invalid credintial", Toast.LENGTH_SHORT).show()
            }
        }
        return viewl
    }

}