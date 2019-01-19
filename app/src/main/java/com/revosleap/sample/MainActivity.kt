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

        simpleAdapter = SimpleAdapter(R.layout.list_item, this@MainActivity)

        list.apply {
            adapter = simpleAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        dummyDump()
    }

    private fun dummyDump(){
        val p = Person(R.drawable.preview, "One")
        simpleAdapter!!.addItem(p)
        simpleAdapter!!.addItem(Person(R.drawable.preview, "Two"))
        simpleAdapter!!.addItem(Person(R.drawable.preview, "Three"))
        simpleAdapter!!.addItem(Person(R.drawable.preview, "Four"))
        simpleAdapter!!.addItem(Person(R.drawable.preview, "Five"))
        simpleAdapter!!.addItem(Person(R.drawable.preview, "Six"))
        simpleAdapter!!.addItem(Person(R.drawable.preview, "Seven"))
    }

    override fun onViewClicked(view: View, item: Any, position: Int) {
        item as Person
        Toast.makeText(applicationContext, "Item ${item.name} at position $position clicked", Toast.LENGTH_SHORT).show()
    }

    override fun bindView(view: View, item: Any, position: Int) {
        item as Person // cast to access its attributes
        val name = view.textView //textView is the ID of the View in the list item layout
        val image = view.image //image is also an ID in the layout

        //bind data to the views
        name.text = item.name
        image.setImageResource(item.image) //both using modelName and item work
    }

    override fun onViewLongClicked(it: View?, item: Any, position: Int) {
        item as Person
        Toast.makeText(applicationContext, "Item ${item.name} at position $position long clicked", Toast.LENGTH_SHORT).show()
    }
}
