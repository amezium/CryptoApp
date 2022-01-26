package com.example.cryptoapp.data.mapper

import com.example.cryptoapp.data.database.CoinInfoDbModel
import com.example.cryptoapp.data.network.model.CoinInfoDto
import com.example.cryptoapp.data.network.model.CoinInfoJsonContainerDto
import com.example.cryptoapp.data.network.model.CoinNamesListDto
import com.example.cryptoapp.domain.CoinInfo
import com.google.gson.Gson

class CoinMapper {

    fun mapDtoToDbModel(dto: CoinInfoDto): CoinInfoDbModel {
        return CoinInfoDbModel(
            toSymbol = dto.toSymbol,
            fromSymbol = dto.fromSymbol,
            price = dto.price,
            lastUpdate = dto.lastUpdate,
            highDay = dto.highDay,
            lowDay = dto.lowDay,
            lastMarket = dto.lastMarket,
            imageUrl = dto.imageUrl
        )
    }

    fun mapJsonContainerToListCoinInfoDto(jsonContainer: CoinInfoJsonContainerDto): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObject = jsonContainer.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapCoinNameDtoToString(namesListDto: CoinNamesListDto): String {
        return namesListDto.names?.map { it.coinInfoDto?.name }?.joinToString(",") ?: ""
    }

    fun mapDbModelToEntity(DbModel: CoinInfoDbModel): CoinInfo {
        return CoinInfo(
            toSymbol = DbModel.toSymbol,
            fromSymbol = DbModel.fromSymbol,
            price = DbModel.price,
            lastUpdate = DbModel.lastUpdate,
            highDay = DbModel.highDay,
            lowDay = DbModel.lowDay,
            lastMarket = DbModel.lastMarket,
            imageUrl = DbModel.imageUrl
        )
    }
}