package com.github.christophpickl.myblockchain.common

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.commons.codec.binary.Base64
import java.io.File
import java.nio.file.Files

val objectMapper = jacksonObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)

fun File.toBytes() = Files.readAllBytes(toPath())

fun ByteArray.encodeBase64() = Base64.encodeBase64String(this)
fun String.decodeBase64() = Base64.decodeBase64(this)

fun ByteArray.toPrettyString() = "[${encodeBase64().substring(0, 4)}]"


fun ByteArray.leadingZerosCount(): Int {
    for (i in 0..size - 1) {
        if (get(i).toInt() != 0) {
            return i
        }
    }
    return size
}
