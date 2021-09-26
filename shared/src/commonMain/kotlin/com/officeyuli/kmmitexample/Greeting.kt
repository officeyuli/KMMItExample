package com.officeyuli.kmmitexample

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}