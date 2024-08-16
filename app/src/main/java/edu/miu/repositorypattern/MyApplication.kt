package edu.miu.repositorypattern

import android.app.Application
import edu.miu.repositorypattern.data.AppRepository
import edu.miu.repositorypattern.data.Repository

class MyApplication: Application() {
    private lateinit var repository: Repository

    override fun onCreate() {
        super.onCreate()
        repository = AppRepository()
    }

    fun getRepository(): Repository {
        return repository
    }
}
