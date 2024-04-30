package com.example.project_dequeue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import android.widget.Toolbar


class
    user_interface : Fragment() {

    lateinit var viewu:View
    lateinit var list:ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewu=inflater.inflate(R.layout.fragment_user_interface, container, false)
        val arr= arrayOf(
            "KITCHEN ETTE ",
            "OVEN EXPRESS",
            "BENGALI KITCHEN",
            "CENTRAL MESS"
        )
        list=viewu.findViewById(R.id.lst)
        val adapter=ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,arr)
        list.adapter=adapter
        list.setOnItemClickListener(){
            ArrayAdapter,view,i,j->
            fragmentManager?.beginTransaction()?.replace(R.id.main,ItemList())?.commit()
            list.setSelector(androidx.appcompat.R.color.abc_background_cache_hint_selector_material_dark)
        }
        return viewu
    }

}