package com.example.epoxyapplicationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.carousel
import com.example.epoxyapplicationdemo.model.CarouselItem
import com.example.epoxyapplicationdemo.model.Task

class MainActivity : AppCompatActivity() {
    //demo data
    val tasks = listOf(
        Task("id1", "Audio & Video", 4),
        Task("id2", "Updating", 6),
        Task("id3", "Drink and food", 2),
        Task("id4", "Security", 4),
        Task("id5", "Dark theme     ", 6),
    )

    val carouselItems = listOf(
        CarouselItem("id11", "Event problems", "Call issue center"),
        CarouselItem("id21", "Emergency", "Call policy"),
        CarouselItem("id31", "Tassk 4", "Call google"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }
    private fun setupRecyclerView() {
        val rvTask = findViewById<EpoxyRecyclerView>(R.id.rvTask)
        rvTask.withModels {
            // First title
            title {
                id("title-id")
                title("Need Assistant")
            }

            // Carousel Item
            val carouselItemModels = carouselItems.map { currentItem ->
                TaskCarouselBindingModel_()
                    .id(currentItem.id)
                    .carouselItem(currentItem)
                    .clickListener { v ->
                    }
            }

            // Carousel
            // This extension function come with epoxy
            carousel {
                id("car")
                models(carouselItemModels)
            }

            // Task title
            // item_title.xml
            title {
                id("title-id")
                title("Need Assistant")
            }

            // Tasks
            tasks.forEach { currentTask ->
                // item_task.xml
                task {
                    id(currentTask.id)
                    task(currentTask)
                    clickListener { v ->

                    }
                }
            }
        }
    }
}