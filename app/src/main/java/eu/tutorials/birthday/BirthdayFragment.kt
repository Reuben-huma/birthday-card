package eu.tutorials.birthday

import android.content.ActivityNotFoundException
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import eu.tutorials.birthday.databinding.FragmentBirthdayBinding
import eu.tutorials.birthday.model.BirthdayViewModel

class BirthdayFragment : Fragment() {

    private var binding: FragmentBirthdayBinding? = null
    private val viewModel: BirthdayViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.share -> share()
        }
        return super.onOptionsItemSelected(item)
    }

    fun onFabClick() {
        findNavController().navigate(R.id.action_birthdayFragment_to_editFragment)
    }

    private fun share() {

        val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
            .setEmailTo(arrayOf(viewModel.emailAddress.value))
            .setSubject(getString(R.string.birthday_title, viewModel.recipient.value))
            .setText(getString(R.string.birthday_message))
            .setType("text/plain")
            .intent

        try {
            startActivity(shareIntent)
        }
        catch (ex: ActivityNotFoundException) {
            Toast.makeText(requireContext(), getString(R.string.sharing_not_available), Toast.LENGTH_LONG).show()
        }
    }

}