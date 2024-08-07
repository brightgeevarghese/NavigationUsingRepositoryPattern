package edu.miu.navdatatransfer.data

import kotlinx.serialization.Serializable

@Serializable
data class Student(
    val name: String = "unknown",
    val regNo: String = "unknown",
    val age: Int = 0,
    val grade: String = "unknown"
)
