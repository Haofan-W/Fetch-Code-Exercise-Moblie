package com.example.fetch_rewards_coding_exercise

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.reflect.typeOf

/**
 * Fetches data from https://fetch-hiring.s3.amazonaws.com/hiring.json and parses it into a list of items.
 * @return List of filtered Item objects.
 */
class FetchData(private val callback: (List<Item>) -> Unit) {

    /**
     * Fetch data from https://fetch-hiring.s3.amazonaws.com/hiring.json./
     */
    suspend fun fetchData() {
        withContext(Dispatchers.IO) {
            val url = URL("https://fetch-hiring.s3.amazonaws.com/hiring.json")
            val connection = url.openConnection() as HttpURLConnection
            try {
                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                val jsonString = reader.readLines().joinToString("\n")
                val items = parseJson(jsonString)
                withContext(Dispatchers.Main) {
                    callback(items)
                }
            } finally {
                connection.disconnect()
            }
        }
    }

    /**
     * Parse the Json file and filter out the items that name is null or empty.
     * @param jsonString
     * @return List of Item objects.
     */
    internal fun parseJson(jsonString: String): List<Item> {
        val jsonArray = JSONArray(jsonString)
        val items = mutableListOf<Item>()
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val id = jsonObject.getInt("id")
            val listId = jsonObject.getInt("listId")
            val name = jsonObject.optString("name", null)
            if (!name.isNullOrBlank() && name != "null") {
                items.add(Item(id, listId, name))
            }
        }
        return items
    }
}