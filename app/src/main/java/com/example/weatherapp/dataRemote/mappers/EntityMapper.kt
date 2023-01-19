package com.example.weatherapp.dataRemote.mappers

interface EntityMapper<M, E> {

    fun mapFromModel(model: M): E
}
