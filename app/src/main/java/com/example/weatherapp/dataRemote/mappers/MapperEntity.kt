package com.example.weatherapp.dataRemote.mappers

interface MapperEntity<M, E> {

    fun mapFromModel(model: M): E
}
