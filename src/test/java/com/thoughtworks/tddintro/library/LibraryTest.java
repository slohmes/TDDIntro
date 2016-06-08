package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */
    private List<String> books = new ArrayList<>();
    private PrintStream printStream = mock(PrintStream.class);
    private DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
    private Library library = new Library(books, printStream, dateTimeFormatter);

    private String title = "Book Title";
    private DateTime time = new DateTime();


    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        DateTime time = new DateTime();
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        books.add(title);
        library = new Library(books, printStream, dateTimeFormatter);

        library.listBooks();

        verify(printStream).println(title);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        library = new Library(books, printStream, dateTimeFormatter);
        library.listBooks();

        verify(printStream, never()).println();

    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {

        String secondTitle = "Second Title";
        books.add(title);
        books.add(secondTitle);

        library = new Library(books, printStream, dateTimeFormatter);
        library.listBooks();

        verify(printStream).println(title);
        verify(printStream).println(secondTitle);
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is ");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        // implement me
        // then move common test variables into a setup method

    }
}
