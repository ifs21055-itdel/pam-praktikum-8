package com.ifs21055.pampraktikum8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21055.pampraktikum8.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var listMessageAdapter: ListMessageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi ListMessageAdapter
        listMessageAdapter = ListMessageAdapter(ArrayList())
        binding.rvMessages.layoutManager = LinearLayoutManager(context)
        binding.rvMessages.adapter = listMessageAdapter

        // Mengambil data dari string-array
        val personNames = resources.getStringArray(R.array.person_name)
        val personIcons = resources.obtainTypedArray(R.array.person_icon)
        val personMessages = resources.getStringArray(R.array.isi_pesan)

        // Membuat ArrayList untuk menyimpan data
        val messages = ArrayList<Message>()

        // Mengisi ArrayList dengan data dari string-array
        for (i in personNames.indices) {
            val name = personNames[i]
            val icon = personIcons.getResourceId(i, R.drawable.spotify)
            val message = personMessages[i]
            messages.add(Message(name, icon, message))
        }

        // Atur data ke adapter
        listMessageAdapter.setListMessage(messages)
    }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
    }
}
