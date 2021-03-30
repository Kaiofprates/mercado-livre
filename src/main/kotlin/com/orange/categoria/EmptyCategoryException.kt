package com.orange.categoria

class EmptyCategoryException(s: String) : Exception() {
    override val message: String? = s
}
