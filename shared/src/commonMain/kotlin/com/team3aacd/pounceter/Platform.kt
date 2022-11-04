package com.team3aacd.pounceter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform