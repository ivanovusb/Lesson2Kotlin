package com.example.lesson2kotlin.Lesson3

import android.util.Log
import kotlin.math.log

object Lesson3 {

    /**
    Дженерики
     */
    fun startLessonGenerics() { // не генерируют что либо, а обощают
        val phraseList = listOf<String>("I", "love", "kotlin!")
        val numList = listOf<Int>(1, 2, 5, 6, 8, 3, 2, 23, 23, 765, 566)
        val testList = listOf<Test>(Test(), Test(), Test(), Test(), Test())

        some("string")
        someGeneric(Test())
        someGeneric(Double)
        someGeneric(1)

        var uniLink = Producer<Any>()
        var uniLinkTwo = Consumer<Any>()

        val producerTest = Producer<Test>()
        val producerDouble = Producer<Double>()
        val producerString = Producer<String>()

        val consumerTest = Consumer<Test>()

        uniLink = producerTest
        uniLink.produce()

//        uniLinkTwo = consumerTest
        uniLinkTwo.consume(5)


    }

    private fun some(input: String) {
        Log.d("@@", input.toString())
    }

    fun some(input: Int) {
        Log.d("@@", input.toString())
    }

    fun some(input: Double) {
        Log.d("@@", input.toString())
    }

    private fun <MyType> someGeneric(input: MyType) {
        Log.d("@@", input.toString())
    } // в угловых скобках пишется любой тип данных который принимает функция

    class Producer<out T> { // то же что и с функцией
        private val list = listOf<T>()
        fun produce(): T {
            return list.first()
        }
    }

    class Consumer<in T> {
        private val list = listOf<T>()
        fun consume(input: T) {

        }
    }


    /**
    конец Дженериков
     */

    fun startLessonCollections() {
        val phraseArray = arrayOf("I", "love", "kotlin!")
        var phraseList = listOf("I", "love", "kotlin!")
        val numList = listOf(1, 2, 5, 6, 8, 3, 2, 23, 23, 765, 566)
        val phraseMap = mapOf("I" to "2", "love" to "2", "kotlin!" to "2")
        phraseList = phraseList.toMutableList()
        phraseList.add("")
        phraseList.removeAt(1)

        val newFilteredPhraseList = phraseList.filter { it.length > 3 }
        val newFilteredNumList = numList.sorted()
        val newList = phraseList.map { "$it +" }

        val phraseArrayMutable = arrayOf("I", "love", "kotlin!")
        val phraseListMutable = mutableListOf("I", "love", "kotlin!")
        val phraseMapMutable = mutableMapOf("I" to "2", "love" to "2", "kotlin!" to "2")
        phraseListMutable.add("")
        phraseListMutable.removeAt(1)


        /*
        Пары
         */
        val lat: Double = 1.0
        val lon: Double = 1.1
        val location = Pair(lat, lon) // Создается взаимодействующая пара
        location.first // Обращение происходит по "первому"..
        location.second // .. и "второму" значению

        val locationSecondExample = lat to lon // то же самое обращение как и выше
        locationSecondExample.first
        locationSecondExample.second
    }
}