package com.hk.mvvmversion.network

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.internal.LinkedTreeMap
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.io.IOException
import java.util.ArrayList
import javax.inject.Inject
import javax.inject.Singleton


class CustomizedObjectTypeAdapter @Inject constructor(): TypeAdapter<Any?>() {
    private val delegate =
        Gson().getAdapter(Any::class.java)

    @Throws(IOException::class)
    override fun write(
        out: JsonWriter,
        value: Any?
    ) {
        delegate.write(out, value)
    }

    @Throws(IOException::class)
    override fun read(`in`: JsonReader): Any? {
        val token = `in`.peek()
        return when (token) {
            JsonToken.BEGIN_ARRAY -> {
                val list: MutableList<Any?> =
                    ArrayList()
                `in`.beginArray()
                while (`in`.hasNext()) {
                    list.add(read(`in`))
                }
                `in`.endArray()
                list
            }
            JsonToken.BEGIN_OBJECT -> {
                val map: MutableMap<String, Any?> =
                    LinkedTreeMap()
                `in`.beginObject()
                while (`in`.hasNext()) {
                    map[`in`.nextName()] = read(`in`)
                }
                `in`.endObject()
                map
            }
            JsonToken.STRING -> {
                `in`.nextString()
            }
            JsonToken.NUMBER -> {
                //return in.nextDouble();
                val n = `in`.nextString()
                if (n.indexOf('.') != -1) {
                    return n.toDouble()
                }
                n.toLong()
            }
            JsonToken.BOOLEAN -> {
                `in`.nextBoolean()
            }
            JsonToken.NULL -> {
                `in`.nextNull()
                null
            }
            else -> throw IllegalStateException()
        }
    }

    companion object {
        @JvmField
        val FACTORY: TypeAdapterFactory = object : TypeAdapterFactory {
            override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
                return if (MutableMap::class.java.isAssignableFrom(type.rawType)) {
                    CustomizedObjectTypeAdapter() as TypeAdapter<T>
                } else null
            }
        }
    }
}
