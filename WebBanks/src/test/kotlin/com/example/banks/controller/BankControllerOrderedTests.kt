package com.example.banks.controller

import com.example.banks.model.Bank
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.*
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.*

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class BankControllerOrderedTests @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {

    val baseUrl = "/api/banks"

    @Test
    @Order(1)
    fun `bank not exists`() {
        val invalidAccountNumber = "acc123"

        mockMvc.get("$baseUrl/$invalidAccountNumber")
            .andDo { print() }
            .andExpect { status { isNotFound() } }
    }

    @Test
    @Order(2)
    fun `add the new bank`() {
        val newBank = Bank("acc123", 31.415, 2)

        val performPost = mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newBank)
        }

        performPost
            .andDo { print() }
            .andExpect {
                status { isCreated() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                    json(objectMapper.writeValueAsString(newBank))
                }
            }

        mockMvc.get("$baseUrl/${newBank.accountNumber}")
            .andExpect { content { json(objectMapper.writeValueAsString(newBank)) } }
    }

    @Test
    @Order(3)
    fun `bank exists`() {
        val invalidAccountNumber = "acc123"

        mockMvc.get("$baseUrl/$invalidAccountNumber")
            .andDo { print() }
            .andExpect { status { isOk() } }
    }
}
