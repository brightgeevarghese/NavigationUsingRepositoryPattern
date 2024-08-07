package edu.miu.repositorypattern.data

import edu.miu.navdatatransfer.data.Student

interface Repository {
    fun getStudent(regNo: String): Student
    fun setStudent(student: Student)
}