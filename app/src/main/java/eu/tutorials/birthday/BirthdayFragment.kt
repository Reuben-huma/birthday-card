package eu.tutorials.birthday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import eu.tutorials.birthday.databinding.FragmentBirthdayBinding
import eu.tutorials.birthday.model.BirthdayViewModel

class BirthdayFragment : Fragment() {

    private var binding: FragmentBirthdayBinding? = null
    private val viewModel: BirthdayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBirthdayBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            birthdayFragment = this@BirthdayFragment
            birthdayViewModel = viewModel
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun onFabClick() {
        Toast.makeText(requireContext(), "Fab clicked", Toast.LENGTH_SHORT).show()
    }

}