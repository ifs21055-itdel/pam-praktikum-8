package com.ifs21055.pampraktikum8


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.ifs21055.pampraktikum8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupAction()
    }
    private fun setupView() {
        binding.navView.setCheckedItem(R.id.navigation_mail)
        binding.inAppBar.toolbar.overflowIcon =
            ContextCompat.getDrawable(this, R.drawable.ic_more_vert)
        loadFragment(FLAG_FRAGMENT_HOME)
    }
    private fun setupAction() {
        binding.inAppBar.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.inAppBar.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> true
            }
        }
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_utama -> {
                    loadFragment(FLAG_FRAGMENT_HOME)
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_sosial -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Menampilkan orang-orang yang terhubung dengan Anda!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_berbintang -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Menampilkan pesan yang Favorit")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_ditunda -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Menampilkan pesan yang Tertunda")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_penting -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Menampilkan pesan yang Penting")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_terkirim -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Menampilkan pesan yang Terkirim")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_terjadwal -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Menampilkan pesan yang Terjadwal")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_draf -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Menampilkan Draf")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_semuaemail -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Menampilkan semua pesan")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_spam -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Menampilkan pesan Spam")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_sampah -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Menampilkan Sampah")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }


                else -> true
            }
        }
        binding.inAppBar.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_mail -> {
                    loadFragment(FLAG_FRAGMENT_HOME)
                    true
                }
                R.id.navigation_meeting -> {
                    loadFragment(FLAG_FRAGMENT_MEETING)
                    true
                }
                else -> true
            }
        }
    }
    private fun loadFragment(flag: String, message: String? = null) {
        val fragmentManager = supportFragmentManager
        val fragmentContainerId =
            binding.inAppBar.inContentMain.frameContainer.id
        when (flag) {
            FLAG_FRAGMENT_HOME -> {
                binding.inAppBar.bottomNavView
                    .menu
                    .findItem(R.id.navigation_mail)
                    .setChecked(true)
                val homeFragment = HomeFragment()
                val bundle = Bundle().apply {
                    this.putString(
                        HomeFragment.EXTRA_MESSAGE,
                        message ?: "Tampilan Awal!"
                    )
                }
                homeFragment.arguments = bundle
                fragmentManager
                    .beginTransaction()
                    .replace(
                        fragmentContainerId,
                        homeFragment,
                        HomeFragment::class.java.simpleName
                    )
                    .commit()
            }

            FLAG_FRAGMENT_MEETING -> {
                val meetingFragment = MeetingFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(MeetingFragment::class.java.simpleName)
                if (fragment !is MeetingFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            meetingFragment,
                            MeetingFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
        }
    }
    companion object {
        const val FLAG_FRAGMENT_HOME = "fragment_home"
        const val FLAG_FRAGMENT_MEETING = "fragment_meeting"
    }
}