package eu.tutorials.birthday.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BirthdayViewModel : ViewModel() {
    private var _recipient = MutableLiveData<String>()
    val recipient: LiveData<String> = _recipient

    private var _sender = MutableLiveData<String>()
    val sender: LiveData<String> = _sender

    init {
        _recipient.value = "James"
        _sender.value = "Jonah"
    }
}