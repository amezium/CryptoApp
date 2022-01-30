package com.example.cryptoapp.data.worker

import android.content.Context
import androidx.work.*
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.database.CoinInfoDao
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.network.ApiService
import kotlinx.coroutines.delay
import javax.inject.Inject

class RefreshDataWorker (
    context: Context,
    workerParameters: WorkerParameters,
    private val coinInfoDao: CoinInfoDao,
    private val mapper: CoinMapper,
    private val apiService: ApiService
) :
    CoroutineWorker(context, workerParameters) {


    override suspend fun doWork(): Result {
        while (true) {
            try {
                val topCoins = apiService.getTopCoinsInfo(limit = 50)
                val fSymp = mapper.mapCoinNameDtoToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = fSymp)
                val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfoDto(jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.mapDtoToDbModel(it) }
                coinInfoDao.insertPriceList(dbModelList)
            } catch (e: Exception) {
            }
            delay(10000)
        }
    }


    companion object {

        const val NAME = "RefreshDataWorker"

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
        }

    }

    class Factory @Inject constructor(
        private val coinInfoDao: CoinInfoDao,
        private val mapper: CoinMapper,
        private val apiService: ApiService
    ) : ChildWorkerFactory {

        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return RefreshDataWorker(
                context, workerParameters, coinInfoDao, mapper, apiService
            )
        }

    }

}