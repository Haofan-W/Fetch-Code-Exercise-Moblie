package com.example.fetch_rewards_coding_exercise

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FetchDataTest {

    private lateinit var fetchData: FetchData

    @Before
    fun setUp() {
        fetchData = FetchData {}
    }

    @Test
    fun testParseJson() = runBlocking {
        val jsonString = """
            [
                {"id": 755, "listId": 2, "name": ""},
                {"id": 203, "listId": 2, "name": ""},
                {"id": 684, "listId": 1, "name": "Item 684"},
                {"id": 276, "listId": 1, "name": "Item 276"},
                {"id": 736, "listId": 3, "name": null},
                {"id": 926, "listId": 4, "name": null},
                {"id": 808, "listId": 4, "name": "Item 808"},
            ]
        """.trimIndent()

        val items = fetchData.parseJson(jsonString)

        assertEquals(3, items.size)
        assertEquals(Item(684, 1, "Item 684"), items[0])
    }
}