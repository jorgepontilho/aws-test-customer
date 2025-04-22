package com.postech.mscustomers.usecase;

import com.postech.mscustomers.entity.Customer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerUseCaseTest {
    @Test
    void testValidarInsertCustomer_ValidInput() {
        // Arrange
        Customer customer = new Customer();
        customer.setNome("John Doe");

        // Act & Assert
        assertDoesNotThrow(() -> CustomerUseCase.validarInsertCustomer(customer));
    }

    @Test
    void testValidarInsertCustomer_NullName_ThrowsException() {
        // Arrange
        Customer customer = new Customer();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> CustomerUseCase.validarInsertCustomer(customer));
    }

    @Test
    void testValidarUpdateCliente_ValidInput() {
        // Arrange
        Customer customerToUpdate = new Customer();
        customerToUpdate.setId(999);
        Customer customerNew = new Customer();
        customerNew.setId(999);

        // Act & Assert
        assertDoesNotThrow(() -> CustomerUseCase.validarUpdateCliente(String.valueOf(999), customerToUpdate, customerNew));
    }

    @Test
    void testValidarUpdateCliente_CustomerNotFound_ThrowsException() {
        // Arrange
        Customer customerNew = new Customer();
        customerNew.setId(999);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> CustomerUseCase.validarUpdateCliente(String.valueOf(999), null, customerNew));
    }

    @Test
    void testValidarDeleteCliente_ValidInput() {
        // Arrange
        Customer customer = new Customer();

        // Act & Assert
        assertDoesNotThrow(() -> CustomerUseCase.validarDeleteCliente(customer));
    }

    @Test
    void testValidarDeleteCliente_CustomerNotFound_ThrowsException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> CustomerUseCase.validarDeleteCliente(null));
    }
}
