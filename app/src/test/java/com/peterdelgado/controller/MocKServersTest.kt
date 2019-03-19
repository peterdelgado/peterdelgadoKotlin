package com.peterdelgado.controller

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockserver.client.server.MockServerClient
import org.mockserver.integration.ClientAndServer



class MocKServersTest {

    val random = java.util.Random()
    internal fun randomFrom(from: Int = 1024, to: Int = 65535) : Int {
        return random.nextInt(to - from) + from
    }

    private val port = randomFrom()
    val url = "http://localhost:$port"
    var mockServer: MockServerClient = MockServerClient(url, port)

    @Before
    fun setUp() {

        mockServer = ClientAndServer.startClientAndServer(port)

    }

    @After
    fun tearDown() {
        mockServer.close()

    }

    @Test
    fun toUpdate() {

        setUp()


        tearDown()


    }
}