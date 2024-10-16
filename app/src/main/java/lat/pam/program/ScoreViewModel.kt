package lat.pam.program

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int>
        get() = _scoreA

    fun incrementScore() {
        _scoreA.value = _scoreA.value?.plus(1)
    }
    fun decrementScore() {
        _scoreA.value = (_scoreA.value ?: 0) - 1
    }

    fun resetScore() {
        _scoreA.value = 0
    }
}