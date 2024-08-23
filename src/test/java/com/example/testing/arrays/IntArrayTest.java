package com.example.testing.arrays;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@ExtendWith(MockitoExtension.class)
public class IntArrayTest {

    ArgumentCaptor<Integer> intCaptor = ArgumentCaptor.forClass(Integer.class);

    @Mock
    private IntArray intArray;

    @BeforeEach
    public void setUp() {
    }

    @Test
    @DisplayName("testArrayInsert")
    public void testArrayInsertMultiple() {
        int value = 10;

        intArray = new IntArray(3);

        intArray.insert(value);
        intArray.insert(value);
        intArray.insert(value);
        intArray.insert(value);
        intArray.insert(value);

        Assertions.assertEquals(5, intArray.size());
    }

    @Test
    @DisplayName("testArraySize")
    public void testArraySize() {
        Assertions.assertNotNull(intArray);
    }

    @Test
    @DisplayName("testArrayInsert")
    public void testArrayInsert() {
        int value = 10;

        Mockito.doNothing().when(intArray).insert(intCaptor.capture());
        intArray.insert(value);
        Mockito.verify(intArray, Mockito.times(1)).insert(value);

        Mockito.verify(intArray).insert(intCaptor.capture());
        Assertions.assertEquals(value,intCaptor.getValue());

    }

}
