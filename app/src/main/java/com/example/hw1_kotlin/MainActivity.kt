package com.example.hw1_kotlin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NumberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root)) { view, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            WindowInsetsCompat.CONSUMED
        }

        val count = savedInstanceState?.getInt(KEY_COUNT) ?: 0
        adapter = NumberAdapter(count)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager =
            GridLayoutManager(this, resources.getInteger(R.integer.grid_columns))
        recyclerView.adapter = adapter

        findViewById<Button>(R.id.addButton).setOnClickListener {
            adapter.addItem()
            recyclerView.scrollToPosition(adapter.getCount() - 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, adapter.getCount())
    }

    private companion object {
        const val KEY_COUNT = "count"
    }
}