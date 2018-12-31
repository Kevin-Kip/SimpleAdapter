package com.revosleap.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.revosleap.simpleadapter.SimpleAdapter
import com.revosleap.simpleadapter.SimpleCallbacks
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*

class MainActivity : AppCompatActivity(), SimpleCallbacks {

    private var simpleAdapter: SimpleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SimpleAdapter(R.layout.list_item, this@MainActivity)

        list.apply {
            adapter = simpleAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        dummyDump()
    }

    private fun dummyDump(){
        simpleAdapter!!.addItem(Person(R.drawable.ic_launcher_background, "Background"))
        simpleAdapter!!.addItem(Person(R.drawable.ic_launcher_foreground, "Foreground"))
    }

    override fun onViewClicked(view: View, item: Any, position: Int) {
        Toast.makeText(applicationContext, "Item $position clicked", Toast.LENGTH_SHORT).show()
    }

    override fun bindView(view: View, item: Any, position: Int) {
        val person = item as Person
        val name = view.text //text is the ID of the View in the list item layout
        val image = view.image //image is also an ID in the layout

        //bind data to the views
        name.text = item.name
        image.setImageResource(person.image) //both using modelName and item work
    }
}
