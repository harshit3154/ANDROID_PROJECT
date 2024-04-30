package com.example.project_dequeue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast


class ItemList : Fragment() {


    lateinit var viewi:View
    lateinit var list: ListView
    lateinit var button:Button
    lateinit var button2:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewi=inflater.inflate(R.layout.fragment_item_list, container, false)
        var selected_index:Int=0
        val arr= arrayOf(
            "Burger",
            "Tandoori chap",
            "French Fries",
            "Hot Dog",
            "Somoasa",
            "Noodle",
            "Chicken fry",
            "Rice bowl",
            "Egg Role",
            "Order this item"

        )
        list=viewi.findViewById(R.id.list2)
        val adapter= ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,arr)
        list.adapter=adapter
        list.setOnItemClickListener(){
                ArrayAdapter,view,i,j->
            list.setSelector(androidx.appcompat.R.color.ripple_material_light)
            if(i===0) {
                viewi.findViewById<ImageView>(R.id.img).setImageResource(R.drawable.burger)
                viewi.findViewById<TextView>(R.id.name).setText("Burger")
                viewi.findViewById<TextView>(R.id.price).setText("50")
            }else if(i==1){
                viewi.findViewById<ImageView>(R.id.img).setImageResource(R.drawable.tandoorichap)
                viewi.findViewById<TextView>(R.id.name).setText("Tandoori Chap")
                viewi.findViewById<TextView>(R.id.price).setText("150")
            }else if(i==2){
                viewi.findViewById<ImageView>(R.id.img).setImageResource(R.drawable.frenchfries)
                viewi.findViewById<TextView>(R.id.name).setText("French Fries")
                viewi.findViewById<TextView>(R.id.price).setText("50")
            }else if(i==3){
                viewi.findViewById<ImageView>(R.id.img).setImageResource(R.drawable.hotdog)
                viewi.findViewById<TextView>(R.id.name).setText("Hotdog")
                viewi.findViewById<TextView>(R.id.price).setText("150")
            }else if(i==4){
                viewi.findViewById<ImageView>(R.id.img).setImageResource(R.drawable.somosa)
                viewi.findViewById<TextView>(R.id.name).setText("Somosa")
                viewi.findViewById<TextView>(R.id.price).setText("15")
            }
            else if(i==5) {
                viewi.findViewById<ImageView>(R.id.img).setImageResource(R.drawable.noodle)
                viewi.findViewById<TextView>(R.id.name).setText("Noodle")
                viewi.findViewById<TextView>(R.id.price).setText("115")
            }else if(i==6) {
                viewi.findViewById<ImageView>(R.id.img).setImageResource(R.drawable.chickenleg)
                viewi.findViewById<TextView>(R.id.name).setText("Chicken Fry")
                viewi.findViewById<TextView>(R.id.price).setText("115")
            }else if(i==7) {
                viewi.findViewById<ImageView>(R.id.img).setImageResource(R.drawable.noodle)
                viewi.findViewById<TextView>(R.id.name).setText("Rice Bowl")
                viewi.findViewById<TextView>(R.id.price).setText("115")
            }else if(i==8) {
                viewi.findViewById<ImageView>(R.id.img).setImageResource(R.drawable.vegrool)
                viewi.findViewById<TextView>(R.id.name).setText("Veg Role")
                viewi.findViewById<TextView>(R.id.price).setText("115")
            }
            selected_index=i
        }


        button=viewi.findViewById(R.id.r)
        button.setOnClickListener(){
            fragmentManager?.beginTransaction()?.replace(R.id.main,RatingFra())?.commit()
        }

        button2=viewi.findViewById(R.id.order)
        button2.setOnClickListener(){
            Toast.makeText(context,"Thanks for ordering the ${arr[selected_index]}",Toast.LENGTH_SHORT).show()
            fragmentManager?.beginTransaction()?.replace(R.id.main,RatingFra())?.commit()
        }
        viewi.findViewById<Button>(R.id.logout).setOnClickListener(){
            var activity:MainActivity=activity as MainActivity
            activity.delete_info()
            fragmentManager?.beginTransaction()?.replace(R.id.main,FirstScreen())?.commit()
        }
        return viewi
    }
}