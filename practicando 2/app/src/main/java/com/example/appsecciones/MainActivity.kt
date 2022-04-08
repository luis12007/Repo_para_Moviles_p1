package com.example.appsecciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), SumFragment.OnActionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentManager = supportFragmentManager
        val fragmentTrasaction = fragmentManager.beginTransaction()



        val fragment = SumFragment.newInstance(2,3)
        fragmentTrasaction
            .add(R.id.framelayout_fragment, fragment)
            .commit()

        val cambiar: Button = findViewById(R.id.Action_cambiar)

        cambiar.setOnClickListener{
        val n1 = (1..1000).random()
        val n2 = (1..1000).random()
        val Action_fragment = SumFragment.newInstance(n1,n2)
            fragmentManager.beginTransaction()
                .replace(R.id.framelayout_fragment,Action_fragment)
                .addToBackStack("$n1+$n2")
                .commit()
        }



        /** con fragmento normal
         * val fragment = HellowFrangment()
        fragmentTrasaction
            .add(R.id.framelayout_fragment, fragment)
            .commit() **/
    }

    override fun onActionClick(result: Int) {
        Toast.makeText(this,"el resultado es $result",Toast.LENGTH_SHORT)
            .show()
    }
}