package edu.miu.repositorypattern.data

import edu.miu.navdatatransfer.data.Student

class AppRepository: Repository {
    private val students = mutableListOf<Student>(
        Student("John Doe", "S101", 20, "A"),
        Student("Jane Smith", "S102",21, "B"),
        Student("Bob Johnson", "S103",19, "C")
    )

    override fun getStudent(regNo: String): Student {
        return students.find { it.regNo == regNo } ?: Student()
    }

    override fun setStudent(student: Student) {
        students.add(student)
    }
}