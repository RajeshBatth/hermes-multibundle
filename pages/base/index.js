import React from 'react'
import {NativeModules} from 'react-native'
import modulePathHashFunction from '../../modulePathHashFunction'

export default async function importLazy(modulePath){
    const moduleId = modulePathHashFunction(modulePath)
    await NativeModules.ChunkLoader.loadChunk(moduleId)
    return global.__r(moduleId)
}