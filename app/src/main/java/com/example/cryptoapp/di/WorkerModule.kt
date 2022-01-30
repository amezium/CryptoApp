package com.example.cryptoapp.di

import androidx.work.ListenableWorker
import com.example.cryptoapp.data.worker.ChildWorkerFactory
import com.example.cryptoapp.data.worker.RefreshDataWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindRefreshDataWorkerFactory(refresh: RefreshDataWorker.Factory): ChildWorkerFactory
}