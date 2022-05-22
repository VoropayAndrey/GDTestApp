package com.hardway.gdtest.domain.entities.parts.implementations.second

import android.util.Log
import com.hardway.gdtest.constants.Constants
import com.hardway.gdtest.domain.entities.parts.interfaces.SecondPartInterface

class SecondPartImplementation1: SecondPartInterface {
    override fun filter(input: Array<Int>): Array<Int> {
        Log.d(Constants.TAG, "filter from SecondPartImplementation1")
        return input
    }
}