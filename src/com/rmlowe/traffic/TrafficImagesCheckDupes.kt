package com.rmlowe.traffic

import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory

fun main(args: Array<String>) {
    val stream = Dummy::class.java.getResourceAsStream("/Traffic_Camera_Locations_En.xml")
    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(stream)
    val images = doc.getElementsByTagName("image")
    println(images.length)

    val uniqueKeys = mutableSetOf<String>()

    for (i in 0 until images.length) {
        val node = images.item(i)

        if (node is Element) {
            val key = node.getElementsByTagName("key").item(0).textContent
            println(key)
            uniqueKeys.add(key)
        }
    }

    println(uniqueKeys.size)
}

// Dummy class to get the resource
class Dummy {

}