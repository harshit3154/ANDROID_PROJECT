package com.example.project_dequeue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class RatingFra : Fragment() {

    lateinit var ratingbar: RatingBar
    lateinit var viewr:View
    lateinit var button:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewr = inflater.inflate(R.layout.fragment_rating, container, false)
        ratingbar=viewr.findViewById(R.id.ratingbar)
        ratingbar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Toast.makeText(context, "Rating: $rating", Toast.LENGTH_SHORT).show()
        }
        viewr.findViewById<Button>(R.id.button).setOnClickListener(){
            fragmentManager?.beginTransaction()?.replace(R.id.main,ItemList())?.commit()
        }
        return viewr
    }

}