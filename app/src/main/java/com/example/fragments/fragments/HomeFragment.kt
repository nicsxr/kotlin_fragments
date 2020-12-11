package com.example.fragments.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.fragments.R

class HomeFragment : Fragment(R.layout.fragment_home){
    private lateinit var navController : NavController
    private lateinit var editText : EditText
    private lateinit var button : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        editText = view.findViewById(R.id.editTextNumber)
        button = view.findViewById(R.id.button)

        button.setOnClickListener{
            if(editText.text.isNotEmpty()){
                val amount = editText.text.toString().toInt()
                val action = HomeFragmentDirections.actionNavigationHomeToNavigationNotification(amount)
                navController.navigate(action)
            }else{
                Toast.makeText(activity?.applicationContext, "Input required", Toast.LENGTH_SHORT).show()            }
        }
    }

}