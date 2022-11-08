package com.aacd.posterday

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform