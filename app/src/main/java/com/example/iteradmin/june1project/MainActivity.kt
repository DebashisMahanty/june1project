package com.example.iteradmin.june1project

import android.content.Context
import android.icu.text.LocaleDisplayNames
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listview)


        val names= arrayOf("iron man","caption america","thor","hulk","barton")
        val real_name= arrayOf("robort downey","gress m stones","mark proof","hawk eye","tron man")
        val images = arrayOf(R.drawable.iron_man,R.drawable.captain_america,R.drawable.thor,R.drawable.hulk,R.drawable.barton)
        listView.adapter= Myadpter(this,names,real_name,images)

    }

        class Myadpter(context:Context,names: Array<String>,real_name:Array<String>,images:Array<Int>):BaseAdapter() {
        private val mContext:Context
        private val names:Array<String>
            private val real_name:Array<String>
            private val images:Array<Int>

        init {
            this.mContext =context
            this.names =names
            this.real_name=real_name
            this.images=images
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
           val layout = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rootView=layout.inflate(R.layout.card,null,true)
            val im =rootView.findViewById<ImageView>(R.id.icon)
            val txt =rootView.findViewById<TextView>(R.id.title)
            val subtext =rootView.findViewById<TextView>(R.id.sub_title)

            im.setImageResource(images[position])
            txt.text=names[position]
            subtext.text = real_name[position]
            im.setOnClickListener {
                Toast.makeText(mContext,names[position],Toast.LENGTH_LONG).show()
            }

            return rootView
        }

        override fun getItem(position: Int): Any {
            return "anything"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return  names.size

        }
    }
}
