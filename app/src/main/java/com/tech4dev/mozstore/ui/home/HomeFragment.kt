package com.tech4dev.mozstore.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import com.tech4dev.mozstore.R
import com.tech4dev.mozstore.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //To set the menu, we hve to override the funtion and set has  it doesnt work because for PI33 is deprecated
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(HomeMenuProvider(), viewLifecycleOwner, Lifecycle.State.RESUMED)

        // Listen for product
        homeViewModel.getAllProduct().observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Number of products ${it.size})", Toast.LENGTH_LONG).show()
        }

    }
}

class HomeMenuProvider(): MenuProvider{
    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.home_menu,menu)

    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return true

    }

}
