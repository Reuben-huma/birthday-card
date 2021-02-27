package eu.tutorials.birthday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.snackbar.Snackbar
import eu.tutorials.birthday.databinding.FragmentEditBinding
import eu.tutorials.birthday.viewmodels.BirthdayViewModel

class EditFragment : Fragment() {

    private var binding: FragmentEditBinding? = null
    private val viewModel: BirthdayViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            editFragment = this@EditFragment
            editViewModel = viewModel
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun onFloatingActionButton() {

        viewModel.setProperties(
            recipientName = binding?.nameEditText?.text.toString(),
            emailAddress = binding?.emailEditText?.text.toString(),
            senderName = binding?.fromEditText?.text.toString()
        )

        Snackbar.make(binding?.constraintLayout?.rootView!!, R.string.saved, Snackbar.LENGTH_SHORT).show()
    }

}