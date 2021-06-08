package com.x.s.myspringbootapp.utils;

import org.junit.jupiter.api.*;
import org.mockito.Answers;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class XsunSessionTest {
    XsunSession session = mock(XsunSession.class,Answers.RETURNS_DEEP_STUBS);

    @Test
    void name_is_xsun() throws Exception{
        when(session.getUser().getName()).thenReturn("Xsun");
        assertThat(session.getUser().getName(), is("Xsun"));
    }
}
