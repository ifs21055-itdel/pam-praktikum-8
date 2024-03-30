package com.ifs21055.pampraktikum8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.ifs21055.pampraktikum8.databinding.FragmentMeetingBinding

class MeetingFragment : Fragment() {
    private lateinit var binding: FragmentMeetingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMeetingBinding
            .inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = binding.vpFragmentMeeting
        val pagerAdapter = MeetingPagerAdapter(requireActivity())
        viewPager.adapter = pagerAdapter
        pagerAdapter.info1 = "Belum ada Jadwal Meeting"
        pagerAdapter.info2 = "Masukkan kode Meeting"
        val tabs = binding.tabFragmentMeeting
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = TAB_TITLES[position]
        }.attach()
    }
    companion object {
        private val TAB_TITLES = arrayOf(
            "New Meeting",
            "Join a Meeting",
        )
    }
}
