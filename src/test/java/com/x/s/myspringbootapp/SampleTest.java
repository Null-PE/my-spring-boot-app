package com.x.s.myspringbootapp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SampleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All tests...");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After each test");
    }

    @Test
    @DisplayName("正常的测试")
    void fail() {
    }

    static class StaticClass {
        @Test
        @DisplayName("静态类测试")
        void fail() {
        }
    }

    static class StaticTest {
        @Test
        @DisplayName("静态类测试")
        void fail() {
        }
    }

    class InnerTest {
        @Test
        @DisplayName("内部类测试")
        void fail() {
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class A_year_is_not_supported {

        @Test
        void if_it_is_zero() {
            System.out.println("nested test");
        }

        @DisplayName("A negative value for year is not supported by the leap year computation.")
        @ParameterizedTest(name = "For example, year {0} is not supported.")
        @ValueSource(ints = {-1, -4})
        void if_it_is_negative(int year) {
            System.out.println("nested test");
        }

    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
    class A_year_is_a_leap_year {

        @Test
        void if_it_is_divisible_by_4_but_not_by_100() {
            System.out.println("nested test");
        }

        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = {2016, 2020, 2048})
        void if_it_is_one_of_the_following_years(int year) {
            System.out.println("nested test");
        }

    }

}
