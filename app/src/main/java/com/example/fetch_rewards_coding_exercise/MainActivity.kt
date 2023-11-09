package com.example.fetch_rewards_coding_exercise

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fetchData = fetchDataAndSort()

        GlobalScope.launch {
            fetchData.fetchData()
        }
    }

    /**
     * Fetch the data using the FetchData class, group the list of Items by it's listId,
     * then sort the items in each group by its' name.
     * @return FetchData object.
     */
    private fun fetchDataAndSort(): FetchData {
        return FetchData { items ->
            val groupedItems = items.groupBy { it.listId }
            val sortedItems = groupedItems
                .toSortedMap()
                .flatMap { (_, itemList) ->
                    itemList.sortedBy {
                        it.name?.substringAfter("Item ")
                            ?.toInt()
                    }
                }

            val listView: ListView = findViewById(R.id.listView)
            val adapter =
                ArrayAdapter(this, android.R.layout.simple_list_item_1, sortedItems.map { it.name })
            listView.adapter = adapter
        }
    }
}