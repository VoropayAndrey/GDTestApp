package com.hardway.gdtest.domain.entities.parts.implementations.third

import android.util.Log
import com.hardway.gdtest.constants.Constants
import com.hardway.gdtest.domain.entities.parts.interfaces.ThirdPartInterface

class ThirdPartImplementation1: ThirdPartInterface {
    override fun check(input: Array<Int>): Boolean {
        Log.d(Constants.TAG, "check from ThirdPartImplementation1")
        return true
    }
}