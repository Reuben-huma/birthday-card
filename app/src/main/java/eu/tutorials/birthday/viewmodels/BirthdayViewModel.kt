package eu.tutorials.birthday.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BirthdayViewModel : ViewModel() {
    private var _recipient = MutableLiveData<String>()
    val recipient: LiveData<String> = _recipient

    private var _emailAddress = MutableLiveData<String>()
    val emailAddress: LiveData<String> = _emailAddress

    private var _sender = MutableLiveData<String>()
    val sender: LiveData<String> = _sender

    init {
        _recipient.value = "James"
        _sender.value = "Jonah"
    }

    fun setProperties(recipientName: String?, emailAddress: String?, senderName: String?) {
        _recipient.value = recipientName ?: " "
        _emailAddress.value = emailAddress ?: " "
        _sender.value = senderName ?: " "
    }
}