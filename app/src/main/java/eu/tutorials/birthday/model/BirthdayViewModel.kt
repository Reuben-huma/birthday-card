package eu.tutorials.birthday.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BirthdayViewModel : ViewModel() {
    private var _recipient = MutableLiveData<String>()
    val recipient: LiveData<String> get() = _recipient

    private var _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    private var _sender = MutableLiveData<String>()
    val sender: LiveData<String> get() = _sender

    init {
        _recipient.value = "James"
        _sender.value = "Reuben"
    }
}