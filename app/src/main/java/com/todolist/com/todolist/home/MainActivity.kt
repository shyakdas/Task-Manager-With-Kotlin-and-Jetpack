package com.todolist.com.todolist.home

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.todolist.com.todolist.R
import com.todolist.com.todolist.addnote.AddNoteFragment
import com.todolist.com.todolist.search.SearchFragment
import com.todolist.com.todolist.sort.SortFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        search_main.setOnClickListener(this)
        sort_main.setOnClickListener(this)
        new_note_main.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.search_main -> {
                var searchFragment = SearchFragment()
                supportFragmentManager.inTransaction { add(R.id.top, searchFragment) }
            }
            R.id.sort_main -> {
                var sortFragment = SortFragment()
                supportFragmentManager.inTransaction { add(R.id.top, sortFragment) }
            }
            R.id.new_note_main -> {
                var addNoteFragment = AddNoteFragment()
                supportFragmentManager.inTransaction { add(R.id.top, addNoteFragment) }
            }
        }
    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}