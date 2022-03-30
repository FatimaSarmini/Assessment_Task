package com.example.assessmenttask.adapter
import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.assessmenttask.ui.view.FavouritesTab
import com.example.assessmenttask.ui.view.PostsTab

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                PostsTab()
            }
            1 -> {
                FavouritesTab()
            }
            else -> {throw Resources.NotFoundException("Position Not Found")}

        }
    }

}