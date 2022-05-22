package com.hardway.gdtest.domain.entities.parts.implementations.first

import android.util.Log
import com.hardway.gdtest.constants.Constants
import com.hardway.gdtest.domain.entities.parts.interfaces.FirstPartInterface

class FirstPartImplementation1: FirstPartInterface {
    override fun invoke() {
        Log.d(Constants.TAG, "invoke from FirstPartImplementation1")
    }
}